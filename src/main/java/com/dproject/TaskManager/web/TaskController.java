package com.dproject.TaskManager.web;

import com.dproject.TaskManager.persistence.entity.TaskEntity;
import com.dproject.TaskManager.persistence.entity.UserEntity;
import com.dproject.TaskManager.services.AssignmentService;
import com.dproject.TaskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController{
    private final TaskService taskService;
    private final AssignmentService assignmentService;

    @Autowired
    public TaskController(TaskService taskService, AssignmentService assignmentService){
        this.taskService = taskService;
        this.assignmentService = assignmentService;
    }

    @GetMapping("/all")
    public List<TaskEntity> getAllTasks(){
        return taskService.findAll();
    }

    @GetMapping("/{taskId}/users")
    public ResponseEntity<List<UserEntity>> getUsersByTask(@PathVariable Integer taskId){
        TaskEntity task = taskService.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        return ResponseEntity.ok(task.getAssignedUsers());
    }

    @PostMapping("/save")
    public TaskEntity saveTask(@RequestBody TaskEntity task){
        return taskService.save(task);
    }

    @PostMapping("/{taskId}/assign/{userId}")
    public ResponseEntity<String> assignUserToTask(@PathVariable Integer taskId, @PathVariable Integer userId){
        assignmentService.assignUserToTask(taskId, userId);
        return ResponseEntity.ok("User assigned to task");
    }

    @PostMapping("/{taskId}/tag/{tagId}")
    public ResponseEntity<TaskEntity> addTagToTask(@PathVariable Integer taskId, @PathVariable Integer tagId){
        return ResponseEntity.ok(taskService.addTagToTask(taskId, tagId));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteById(id);
    }
}
