package com.example.homeworknewcollections25.controller;


import com.example.homeworknewcollections25.entity.Employee;
import com.example.homeworknewcollections25.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
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
    public Map<Integer, List<Employee>> employeesByDepartment(@RequestParam(required = false) Integer departmentId) {
        return departmentService.employeesByDepartment(departmentId);
    }

    @GetMapping("{id}/employees")
    public List<Employee> getEmployeesByDepId(@PathVariable int id) {
        return departmentService.getEmployeesByDepId(id);
    }

    @GetMapping("{id}/salary/sum")
    public double getSalarySumByDepId(@PathVariable int id) {
        return departmentService.getSalarySumByDepId(id);
    }

    @GetMapping("{id}/salary/max")
    public double getMaxSalaryByDepId(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepId(id);
    }

    @GetMapping("{id}/salary/min")
    public double getMinSalaryByDepId(@PathVariable int id) {
        return departmentService.getMinSalaryByDepId(id);
    }
}
