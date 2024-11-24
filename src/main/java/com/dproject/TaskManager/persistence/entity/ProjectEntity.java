package com.dproject.TaskManager.persistence.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects", schema = "task_manager")
@Getter
@Setter
@NoArgsConstructor
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private Integer idProject;
    @Column(name = "name_project")
    private String nameProject;
    @Column(name = "description_project")
    private String descriptionProject;
    @Column(name = "start_date_project", nullable = false, columnDefinition = "DATE")
    private LocalDate starDateProject;
    @Column(name = "end_date_project", nullable = false, columnDefinition = "DATE")
    private LocalDate endDateProject;
}
