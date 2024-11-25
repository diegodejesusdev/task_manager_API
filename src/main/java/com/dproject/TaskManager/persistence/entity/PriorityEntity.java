package com.dproject.TaskManager.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priorities")
@Getter
@Setter
@NoArgsConstructor
public class PriorityEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_priority")
    private Integer idPriority;
    @Column(name = "name_priority")
    private String namePriority;

    @OneToMany(mappedBy = "priorityTask", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TaskEntity> tasks = new ArrayList<>();
}