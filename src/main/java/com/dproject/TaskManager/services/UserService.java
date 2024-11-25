package com.dproject.TaskManager.services;

import com.dproject.TaskManager.persistence.entity.UserEntity;
import com.dproject.TaskManager.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Integer id) {
        return userRepository.findById(id);
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmailUser(email);
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
