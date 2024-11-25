package com.dproject.TaskManager.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Column(name = "expiration_date_task", nullable = false, columnDefinition = "DATE")
    private LocalDate expirationDateTask;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_task")
    private Status statusTask;

    @ManyToOne
    @JoinColumn(name = "id_priority_task", nullable = false, referencedColumnName = "id_priority", insertable = false, updatable = false)
    private PriorityEntity priorityTask;
    @ManyToOne
    @JoinColumn(name = "id_project_task", nullable = false, referencedColumnName = "id_project", insertable = false, updatable = false)
    private ProjectEntity projectTask;
    @ManyToMany
    @JoinTable(name = "task_tag",
            joinColumns = @JoinColumn(name = "id_task_tt"),
            inverseJoinColumns = @JoinColumn(name = "id_tag_tt"))
    private Set<TagEntity> tags = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "assignments",
            joinColumns = @JoinColumn(name = "id_task_assignments"),
            inverseJoinColumns = @JoinColumn(name = "id_user_assignments"))
    private List<UserEntity> assignedUsers;
}
