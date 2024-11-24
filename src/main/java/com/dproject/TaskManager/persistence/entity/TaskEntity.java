package com.dproject.TaskManager.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Integer idTask;
    @Column(name = "name_task")
    private String nameTask;
    @Column(name = "description_task")
    private String descriptionTask;
    @Column(name = "expiration_date_task")
    private LocalDate expirationDateTask;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_task")
    private Status statusTask;


    private Integer idPriorityTask;
    private Integer idProjectTask;

}
