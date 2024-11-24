package com.dproject.TaskManager.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task_tag")
@Getter
@Setter
@NoArgsConstructor
public class TaskTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task_tag")
    private Integer idTaskTag;

    @ManyToOne
    @JoinColumn(name = "id_task_tt", referencedColumnName = "id_task", insertable = false, updatable = false)
    private TaskEntity idTaskT;
    @ManyToOne
    @JoinColumn(name = "id_tag_tt", referencedColumnName = "id_tag", insertable = false, updatable = false)
    private TagEntity idTagT;
}
