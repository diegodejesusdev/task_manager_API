package com.dproject.TaskManager.persistence.repository;

import com.dproject.TaskManager.persistence.entity.ProjectEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ProjectRepository extends ListCrudRepository<ProjectEntity, Integer> {
    ProjectEntity findByNameProject(String name);
}
