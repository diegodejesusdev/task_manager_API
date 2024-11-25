package com.dproject.TaskManager.web;

import com.dproject.TaskManager.persistence.entity.TagEntity;
import com.dproject.TaskManager.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/all")
    public List<TagEntity> getAllTags() {
        return tagService.findAll();
    }

    @PostMapping("/save")
    public TagEntity saveTag(@RequestBody TagEntity tag) {
        return tagService.save(tag);
    }
}
