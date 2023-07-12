package com.example.homeworknewcollections25.service;

import com.example.homeworknewcollections25.entity.Employee;
import com.example.homeworknewcollections25.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee withMaxSalary(Integer departmentId) {
        return streamByDepartment(departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    public Employee withMinSalary(Integer departmentId) {
        return streamByDepartment(departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    private Stream<Employee> streamByDepartment(Integer departmentId) {
        List<Employee> employees = employeeService.getAll();
        return employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId);
    }

    public Map<Integer, List<Employee>> employeesByDepartment(Integer departmentId) {
        List<Employee> employees = employeeService.getAll();
        return employees.stream()
                .filter(e -> departmentId == null || e.getDepartmentId().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.toList()));
    }
}
