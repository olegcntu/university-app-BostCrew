package com.example.universityApp.veiw;

import com.example.universityApp.model.Lector;
import org.springframework.stereotype.Component;

@Component
public class DepartmentView {

    public void departmentHeadView(String departmentName, Lector departmentHeader) {
        System.out.println("Head of " + departmentName + " department is " + departmentHeader.getFirstName() + " " + departmentHeader.getLastName());
    }

    public void averageSalaryForDepartmentView(int averageSalary, String departmentName) {
        System.out.println("The average salary of" + departmentName + " is " + averageSalary);
    }

    public void allLectorsCountForDepartmentView(int count) {
        System.out.println(count);
    }

    public void noDepartmentErrorView(String departmentName) {
        System.out.println("No department with name " + departmentName);
    }

    public void noDepartmentHeadErrorView(String departmentName) {
        System.out.println("No department head for " + departmentName);
    }
}
