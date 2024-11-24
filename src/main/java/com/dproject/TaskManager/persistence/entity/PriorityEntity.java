package com.dproject.TaskManager.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}