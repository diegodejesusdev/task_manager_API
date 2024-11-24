package com.dproject.TaskManager.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

public class AssigmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assigment")
    private Integer idAssigment;
    @Column(name = "record_date_assigment", nullable = false, columnDefinition = "DATE")
    private LocalDate recordDateAssigment;

    @ManyToOne
    @JoinColumn(name = "id_task_assigment", nullable = false, referencedColumnName = "id_task", insertable = false, updatable = false)
    private TaskEntity idTaskAssigment;
    @ManyToOne
    @JoinColumn(name = "id_user_assigment", nullable = false, referencedColumnName = "id_user", insertable = false, updatable = false)
    private UserEntity idUserAssigment;
}
