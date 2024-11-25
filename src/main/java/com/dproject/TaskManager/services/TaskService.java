package com.dproject.TaskManager.services;

import com.dproject.TaskManager.persistence.entity.TagEntity;
import com.dproject.TaskManager.persistence.entity.TaskEntity;
import com.dproject.TaskManager.persistence.repository.TagRepository;
import com.dproject.TaskManager.persistence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, TagRepository tagRepository) {
        this.taskRepository = taskRepository;
        this.tagRepository = tagRepository;
    }

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> findById(Integer id) {
        return taskRepository.findById(id);
    }

    public List<TaskEntity> getTasksByProject(Integer idProject) {
        return taskRepository.findByProjectTaskIdProject(idProject);
    }

    public TaskEntity save(TaskEntity task) {
        return taskRepository.save(task);
    }

    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

    public TaskEntity addTagToTask(Integer idTask, Integer idTag) {
        TaskEntity task = taskRepository.findById(idTask).orElseThrow(() -> new RuntimeException("Task not found"));
        TagEntity tag = tagRepository.findById(idTag).orElseThrow(() -> new RuntimeException("Tag not found"));

        task.getTags().add(tag);
        return taskRepository.save(task);
    }
}
