package com.dproject.TaskManager.persistence.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private LocalDate startDateProject;
    @Column(name = "end_date_project", nullable = false, columnDefinition = "DATE")
    private LocalDate endDateProject;

    @OneToMany(mappedBy = "projectTask", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TaskEntity> tasks = new ArrayList<>();

}
