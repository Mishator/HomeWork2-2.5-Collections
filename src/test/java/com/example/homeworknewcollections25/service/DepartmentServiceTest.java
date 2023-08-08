package com.example.homeworknewcollections25.service;

import com.example.homeworknewcollections25.entity.Employee;
import com.example.homeworknewcollections25.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private EmployeeService employeeService;

    @Test
    void withMaxSalary_success() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        double expectedMaxSalary = Math.max(salary1, salary2);

        //Начало теста
        double actualMaxSalary = departmentService.getMaxSalaryByDepId(departmentId1);
        assertEquals(expectedMaxSalary, actualMaxSalary);
        assertNotEquals(departmentId1, departmentId33);
        verify(employeeService).getAll();
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    void withMaxSalary_withEmployeeNotFoundException() {
        //Подготовка входных данных
        int departmentId = 1;

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Collections.emptyList());
        String expectedErrorMessage = "Сотрудник не найден";

        //Начало теста
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            departmentService.withMaxSalary(departmentId);
        });
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @Test
    void withMinSalary_success() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        double expectedMinSalary = Math.min(salary1, salary2);

        //Начало теста
        double actualMinSalary = departmentService.getMinSalaryByDepId(departmentId1);
        assertEquals(expectedMinSalary, actualMinSalary);
        assertNotEquals(departmentId1, departmentId33);
        verify(employeeService).getAll();
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    void withMinSalary_withEmployeeNotFoundException() {
        //Подготовка входных данных
        int departmentId = 1;

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Collections.emptyList());
        String expectedErrorMessage = "Сотрудник не найден";

        //Начало теста
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
            departmentService.withMinSalary(departmentId);
        });
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @Test
    void employeesByDepartment_AllEmployeesSuccess() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        Map<Integer, List<Employee>> expectedEmployeesByDepId = new HashMap<>();
        expectedEmployeesByDepId.put(departmentId1, Arrays.asList(employee1, employee2));
        expectedEmployeesByDepId.put(departmentId33, Arrays.asList(employee3));


        //Начало теста
        Map<Integer, List<Employee>> actualEmployessByDepId = departmentService.employeesByDepartment(null);
        assertEquals(expectedEmployeesByDepId, actualEmployessByDepId);
        verify(employeeService).getAll();

    }

    @Test
    void employeesByDepartment_byDepIdSuccess() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        Map<Integer, List<Employee>> expectedEmployeesByDepId = new HashMap<>();
        expectedEmployeesByDepId.put(departmentId1, Arrays.asList(employee1, employee2));

        //Начало теста
        Map<Integer, List<Employee>> actualEmployeesByDepId = departmentService.employeesByDepartment(departmentId1);
        assertEquals(expectedEmployeesByDepId, actualEmployeesByDepId);
        verify(employeeService).getAll();
    }

    @Test
    void getEmployeesByDepId_success() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        Map<Integer, List<Employee>> expectedGetEmployeesByDepId = new HashMap<>();
        expectedGetEmployeesByDepId.put(departmentId1, Arrays.asList(employee1, employee2));

        //Начало теста
        Map<Integer, List<Employee>> actualGetEmployeesByDepId = departmentService.employeesByDepartment(departmentId1);
        assertEquals(expectedGetEmployeesByDepId, actualGetEmployeesByDepId);
        verify(employeeService).getAll();
    }

    @Test
    void getSalarySumByDepId_success() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        double expectedGetSalarySumByDepId = Math.addExact((int) salary1, (int) salary2);

        //Начало теста
        double actualGetSalarySumByDepId = departmentService.getSalarySumByDepId(departmentId1);
        assertEquals(expectedGetSalarySumByDepId, actualGetSalarySumByDepId);
        assertNotEquals(departmentId1, departmentId33);
        verify(employeeService).getAll();
        verifyNoMoreInteractions(employeeService);
    }

    @Test
    void getMaxSalaryByDepId_success() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        double expectedGetMaxSalaryByDepId = Math.max(salary1, salary2);

        //Начало теста
        double actualGetMaxSalaryByDepId = departmentService.getMaxSalaryByDepId(departmentId1);
        assertEquals(expectedGetMaxSalaryByDepId, actualGetMaxSalaryByDepId);
        assertNotEquals(departmentId1, departmentId33);
        verify(employeeService).getAll();
        verifyNoMoreInteractions(employeeService);

    }

    @Test
    void getMinSalaryByDepId_success() {
        //Подготовка входных данных
        int departmentId1 = 1;

        String firstName1 = "Andrey";
        String lastName1 = "Arshavin";
        double salary1 = 55555;

        Employee employee1 = new Employee(firstName1, lastName1, departmentId1, salary1);

        String firstName2 = "Alexander";
        String lastName2 = "Kerzhakov";
        double salary2 = 75555;

        Employee employee2 = new Employee(firstName2, lastName2, departmentId1, salary2);

        String firstName3 = "Sergey";
        String lastName3 = "Semak";
        double salary3 = Double.MAX_VALUE;

        int departmentId33 = 33;
        Employee employee3 = new Employee(firstName3, lastName3, departmentId33, salary3);

        //Подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        double expectedGetMinSalaryByDepId = Math.min(salary1, salary2);

        //Начало теста
        double actualGetMinSalaryByDepId = departmentService.getMinSalaryByDepId(departmentId1);
        assertEquals(expectedGetMinSalaryByDepId, actualGetMinSalaryByDepId);
        assertNotEquals(departmentId1, departmentId33);
        verify(employeeService).getAll();
        verifyNoMoreInteractions(employeeService);

        System.out.println();
    }
}