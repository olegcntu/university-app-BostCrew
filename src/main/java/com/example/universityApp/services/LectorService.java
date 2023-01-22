package com.example.universityApp.services;

import com.example.universityApp.model.Department;
import com.example.universityApp.model.Lector;
import com.example.universityApp.model.enums.Degree;
import com.example.universityApp.repositories.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LectorService {
    @Autowired
    private final LectorRepository lectorRepository;


    public int getCountAssistantForDepartment(Department department) {
        List<Lector> lectors = department.getLectors();
        return (int) lectors.stream().filter(lector -> lector.getRoles() == Degree.ASSISTANT).count();
    }

    public int getCountAssociateProfessorsForDepartment(Department department) {
        List<Lector> lectors = department.getLectors();
        return (int) lectors.stream().filter(lector -> lector.getRoles() == Degree.ASSOCIATE_PROFESSOR).count();
    }

    public int getCountProfessorsForDepartment(Department department) {
        List<Lector> lectors = department.getLectors();
        return (int) lectors.stream().filter(lector -> lector.getRoles() == Degree.PROFESSOR).count();
    }

    public List<Lector> gelSelectedLectors(String query) {
        List<Lector> lectors = lectorRepository.findAll();
        List<Lector> selectedLectors = new ArrayList<>();
        lectors.forEach(lector -> {
            if (lector.getFirstName().contains(query) || lector.getLastName().contains(query)) {
                selectedLectors.add(lector);
            }
        });
        return selectedLectors;
    }
}
