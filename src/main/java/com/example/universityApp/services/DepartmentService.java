package com.example.universityApp.services;

import com.example.universityApp.model.Department;
import com.example.universityApp.model.Lector;
import com.example.universityApp.repositories.DepartmentRepository;
import com.example.universityApp.repositories.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentService {
    @Autowired
    private final DepartmentRepository departmentRepository;
    @Autowired
    private final LectorRepository lectorRepository;

    public Lector getDepartmentHeader(Department department) {
        Lector lector = null;
        if (department != null) {
            lector = lectorRepository.findById((long) department.getHead().getId());
        }
        return lector;
    }

    public Department getDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName);
    }

    public int getAverageSalaryForDepartment(Department department) {
        List<Lector> lectors = department.getLectors();
        if (lectors.size() == 0) {
            return 0;
        } else {
            int allSum = lectors.stream().mapToInt(Lector::getSalary).sum();
            return allSum / lectors.size();
        }
    }

    public int getCountOfEmployeeForDepartment(Department department) {
        List<Lector> lectors = department.getLectors();
        return lectors.size();
    }
}
