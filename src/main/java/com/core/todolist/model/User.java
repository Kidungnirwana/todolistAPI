package com.core.todolist.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


import java.util.Set;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private Long id;

    @Column(name = "user_name", length = 50, unique = true)
    private String userName;

    @Column(length = 100)
    private String description;

    @Column(length = 50)
    private String email;

//    @OneToMany
//    @JoinColumn(name = "id")
//    private Set<TodoItem> todoItems;
}
