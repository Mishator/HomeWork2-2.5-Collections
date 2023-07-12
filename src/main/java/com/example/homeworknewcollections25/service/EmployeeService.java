package com.example.homeworknewcollections25.service;

import com.example.homeworknewcollections25.entity.Employee;
import com.example.homeworknewcollections25.exception.EmployeeAlreadyAddedException;
import com.example.homeworknewcollections25.exception.EmployeeNotFoundException;
import com.example.homeworknewcollections25.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final int MAX_SIZE = 4;

    public EmployeeService() {
        employees.add(new Employee("Андрей", "Аршавин", 1, 50000));
        employees.add(new Employee("Александр", "Кержаков", 1, 50000));
        employees.add(new Employee("Владислав", "Радимов", 1, 75000));
        employees.add(new Employee("Сергей", "Семак", 2, 86000));
        employees.add(new Employee("Вячеслав", "Малафеев", 3, 98000));
        employees.add(new Employee("Златан", "Ибрагимович", 4, 155999));
    }

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employee newEmployee = new Employee(firstName, lastName);

        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + newEmployee + " уже существует");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employeeForFind = new Employee(firstName, lastName);

        if (!employees.contains(employeeForFind)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        return employees.get(employees.indexOf(employeeForFind));
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeForRemove = new Employee(firstName, lastName);

        if (!employees.contains(employeeForRemove)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }

        employees.remove(employeeForRemove);
        return employeeForRemove;
    }

    public List<Employee> getAll() {
        return employees;
    }


}
