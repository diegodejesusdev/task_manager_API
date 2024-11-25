package com.dproject.TaskManager.persistence.repository;

import com.dproject.TaskManager.persistence.entity.TaskEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TaskRepository extends ListCrudRepository<TaskEntity, Integer> {
    List<TaskEntity> findByNameTask(String name);
    List<TaskEntity> findByProjectTaskIdProject(Integer idProject);
    List<TaskEntity> findByAssignedUsersIdUser(Integer idUser);
}
