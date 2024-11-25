package com.dproject.TaskManager.services;

import com.dproject.TaskManager.persistence.entity.TagEntity;
import com.dproject.TaskManager.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagEntity> findAll() {
        return tagRepository.findAll();
    }

    public TagEntity save(TagEntity tag) {
        return tagRepository.save(tag);
    }
}
