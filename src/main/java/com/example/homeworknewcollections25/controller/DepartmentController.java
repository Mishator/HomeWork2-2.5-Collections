package com.example.homeworknewcollections25.controller;


import com.example.homeworknewcollections25.entity.Employee;
import com.example.homeworknewcollections25.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Employee withMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.withMaxSalary(departmentId);
    }
}
