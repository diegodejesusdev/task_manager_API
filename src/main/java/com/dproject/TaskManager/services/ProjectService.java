package com.dproject.TaskManager.services;

import com.dproject.TaskManager.persistence.entity.ProjectEntity;
import com.dproject.TaskManager.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<ProjectEntity> findById(Integer id) {
        return projectRepository.findById(id);
    }

    public List<ProjectEntity> findAll() {
        return projectRepository.findAll();
    }

    public ProjectEntity findByName(String name) {
        return projectRepository.findByNameProject(name);
    }

    public ProjectEntity save(ProjectEntity project) {
        return projectRepository.save(project);
    }
}
