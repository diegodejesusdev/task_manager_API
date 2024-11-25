package com.dproject.TaskManager.web;

import com.dproject.TaskManager.persistence.entity.UserEntity;
import com.dproject.TaskManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/email")
    public UserEntity getUserByEmail(String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/save")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        if(user.getRecordDateUser() == null) {
            user.setRecordDateUser(LocalDate.now());
        }
        return userService.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
