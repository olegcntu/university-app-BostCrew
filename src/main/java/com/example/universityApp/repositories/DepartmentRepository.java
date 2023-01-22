package com.example.universityApp.repositories;

import com.example.universityApp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

}
