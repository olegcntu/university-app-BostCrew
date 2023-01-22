package com.example.universityApp.controller;

import com.example.universityApp.model.Department;
import com.example.universityApp.model.Lector;
import com.example.universityApp.services.DepartmentService;
import com.example.universityApp.services.LectorService;
import com.example.universityApp.veiw.DepartmentView;
import com.example.universityApp.veiw.ErrorView;
import com.example.universityApp.veiw.LectorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class MainController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LectorService lectorService;

    @Autowired
    private DepartmentView departmentView;
    @Autowired
    private LectorView lectorView;
    @Autowired
    private ErrorView errorView;

    public void requestWork(String request) {

        Pattern patternHeadOfDepartment = Pattern.compile("[W|w]ho[ ]+is[ ]+head[ ]+of[ ]+department[ ]+.+");// Who is head of department PI
        Pattern patternStatistics = Pattern.compile("[S|s]how[ ]+.+ statistics");//Show PI statistics
        Pattern patternAverageSalary = Pattern.compile("[S|s]how[ ]+the[ ]+average[ ]+salary[ ]+for[ ]+the[ ]+department[ ]+.+");//Show the average salary for the department PI
        Pattern patternCountOfEmployee = Pattern.compile("[S|s]how[ ]+count[ ]+of[ ]+employee for .+");//Show count of employee for PI
        Pattern patternGlobalSearch = Pattern.compile("[G|g]lobal[ ]+search[ ]+by[ ]+.+");//Global search by ol

        if (patternHeadOfDepartment.matcher(request).find()) {
            String departmentName = request.substring(request.lastIndexOf(" ") + 1);
            departmentHead(departmentName);

        } else if (patternStatistics.matcher(request).find()) {
            String departmentName = request.split(" ")[1];
            statistics(departmentName);

        } else if (patternAverageSalary.matcher(request).find()) {
            String departmentName = request.substring(request.lastIndexOf(" ") + 1);
            averageSalaryForDepartment(departmentName);

        } else if (patternCountOfEmployee.matcher(request).find()) {
            String departmentName = request.substring(request.lastIndexOf(" ") + 1);
            countOfEmployeeForDepartment(departmentName);

        } else if (patternGlobalSearch.matcher(request).find()) {
            String paramForSearch = request.substring(request.lastIndexOf(" ") + 1);
            globalSearch(paramForSearch);
        } else {
            ErrorRequest(request);
        }

    }


    private void departmentHead(String departmentNameSt) {
        Department department = departmentService.getDepartment(departmentNameSt);

        if (department == null) {
            departmentView.noDepartmentErrorView(departmentNameSt);
        } else if (department.getHead() == null) {
            departmentView.noDepartmentHeadErrorView(departmentNameSt);
        } else {
            Lector departmentHeader = departmentService.getDepartmentHeader(department);
            departmentView.departmentHeadView(department.getName(), departmentHeader);
        }
    }

    private void statistics(String departmentNameSt) {
        Department department = departmentService.getDepartment(departmentNameSt);
        if (department != null) {
            int assistantCountForDepartment = lectorService.getCountAssistantForDepartment(department);
            int associateProfessorsCountForDepartment = lectorService.getCountAssociateProfessorsForDepartment(department);
            int professorCountForDepartment = lectorService.getCountProfessorsForDepartment(department);

            lectorView.statisticForDepartmentView(assistantCountForDepartment,
                    associateProfessorsCountForDepartment, professorCountForDepartment);
        } else {
            departmentView.noDepartmentErrorView(departmentNameSt);
        }
    }

    private void averageSalaryForDepartment(String departmentNameSt) {
        Department department = departmentService.getDepartment(departmentNameSt);
        if (department != null) {
            int averageSalary = departmentService.getAverageSalaryForDepartment(department);
            departmentView.averageSalaryForDepartmentView(averageSalary, departmentNameSt);
        } else {
            departmentView.noDepartmentErrorView(departmentNameSt);
        }
    }

    private void countOfEmployeeForDepartment(String departmentNameSt) {
        Department department = departmentService.getDepartment(departmentNameSt);
        if (department != null) {
            int allLectorsForDepartment = departmentService.getCountOfEmployeeForDepartment(department);
            departmentView.allLectorsCountForDepartmentView(allLectorsForDepartment);
        } else {
            departmentView.noDepartmentErrorView(departmentNameSt);
        }
    }

    private void globalSearch(String paramForSearch) {
        List<Lector> lectorList = lectorService.gelSelectedLectors(paramForSearch);
        lectorView.selectedLectorsView(lectorList);
    }

    private void ErrorRequest(String request) {
        errorView.error(request);
    }

}
