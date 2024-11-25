package com.dproject.TaskManager.web;

import com.dproject.TaskManager.persistence.entity.ProjectEntity;
import com.dproject.TaskManager.persistence.entity.TaskEntity;
import com.dproject.TaskManager.services.ProjectService;
import com.dproject.TaskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final TaskService taskService;

    @Autowired
    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<ProjectEntity> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/name")
    public ProjectEntity getProjectByName(String name) {
        return projectService.findByName(name);
    }

    @PostMapping("/save")
    public ProjectEntity saveProject(@RequestBody ProjectEntity project) {
        return projectService.save(project);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskEntity>> getTasksByProject(@PathVariable int id) {
        Optional<ProjectEntity> project = projectService.findById(id);
        if(project.isPresent()) {
            List<TaskEntity> tasks = taskService.getTasksByProject(id);
            return ResponseEntity.ok(tasks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
