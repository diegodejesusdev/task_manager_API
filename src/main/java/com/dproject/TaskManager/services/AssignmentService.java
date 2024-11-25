package com.dproject.TaskManager.services;

import com.dproject.TaskManager.persistence.entity.TaskEntity;
import com.dproject.TaskManager.persistence.entity.UserEntity;
import com.dproject.TaskManager.persistence.repository.TaskRepository;
import com.dproject.TaskManager.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public AssignmentService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public void assignUserToTask(Integer taskId, Integer userId) {
        TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        task.getAssignedUsers().add(user);
        taskRepository.save(task);
    }


}
