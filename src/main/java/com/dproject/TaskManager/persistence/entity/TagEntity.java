package com.dproject.TaskManager.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
@Getter
@Setter
@NoArgsConstructor
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Integer idTag;
    @Column(name = "name_tag")
    private String nameTag;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<TaskEntity> tasks = new HashSet<>();
}
