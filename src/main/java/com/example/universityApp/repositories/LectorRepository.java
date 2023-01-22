package com.example.universityApp.repositories;

import com.example.universityApp.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    Lector findById(long id);

    List<Lector> findAll();
}
