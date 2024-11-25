package com.dproject.TaskManager.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "full_name_user")
    private String nameUser;
    @Column(name = "email_user")
    private String emailUser;
    @Column(name = "record_date_user", columnDefinition = "DATE")
    private LocalDate recordDateUser;

    @ManyToMany(mappedBy = "assignedUsers")
    @JsonIgnore
    private List<TaskEntity> tasks;
}
