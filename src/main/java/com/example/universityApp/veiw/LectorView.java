package com.example.universityApp.veiw;

import com.example.universityApp.model.Lector;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LectorView {

    public void statisticForDepartmentView(int assistantCountForDepartment,
                                           int associateProfessorsCountForDepartment, int professorCountForDepartment) {
        System.out.println("assistants - " + assistantCountForDepartment);
        System.out.println("associate professors - " + associateProfessorsCountForDepartment);
        System.out.println("professors  - " + professorCountForDepartment);
    }

    public void selectedLectorsView(List<Lector> lectorList) {
        if (lectorList.size() > 0) {
            String commaSeparatedStringValueOf = lectorList.stream()
                    .map(lector -> {
                        return lector.getFirstName() + " " + lector.getLastName();
                    })
                    .collect(Collectors.joining(","));
            System.out.println(commaSeparatedStringValueOf);
        } else {
            System.out.println("No result");
        }
    }

}
