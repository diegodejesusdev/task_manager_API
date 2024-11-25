package com.dproject.TaskManager.persistence.repository;

import com.dproject.TaskManager.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UserRepository extends ListCrudRepository<UserEntity, Integer> {
    UserEntity findByEmailUser(String email);
    List<UserEntity> findByTasksIdTask(Integer idTask);
}