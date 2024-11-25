package com.dproject.TaskManager.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assignments")
@Getter
@Setter
@NoArgsConstructor
public class AssigmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assignments")
    private Integer idAssignment;

    @ManyToOne
    @JoinColumn(name = "id_task_assignments", nullable = false, referencedColumnName = "id_task", insertable = false, updatable = false)
    private TaskEntity taskAssignment;
    @ManyToOne
    @JoinColumn(name = "id_user_assignments", nullable = false, referencedColumnName = "id_user", insertable = false, updatable = false)
    private UserEntity userAssignment;
}
