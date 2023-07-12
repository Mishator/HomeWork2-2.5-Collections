package com.example.homeworknewcollections25.controller;


import com.example.homeworknewcollections25.entity.Employee;
import com.example.homeworknewcollections25.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee withMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.withMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee withMinSalary(@RequestParam Integer departmentId) {
        return departmentService.withMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> employeesByDepartment() {
        return departmentService.employeesByDepartment();
    }
}
