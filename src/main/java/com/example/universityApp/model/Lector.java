package com.example.universityApp.model;

import com.example.universityApp.model.enums.Degree;
import com.example.universityApp.model.enums.Degree;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "lector")
@Getter
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "roles", nullable = false)
    private Degree roles;

    @Column(name = "last_name", nullable = false)
    @Nullable
    String lastName;

    @Column(name = "salary", nullable = false)
    @Nullable
    int salary;
}
