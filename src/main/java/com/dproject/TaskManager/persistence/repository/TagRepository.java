package com.dproject.TaskManager.persistence.repository;

import com.dproject.TaskManager.persistence.entity.TagEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TagRepository extends ListCrudRepository<TagEntity, Integer> {
}
