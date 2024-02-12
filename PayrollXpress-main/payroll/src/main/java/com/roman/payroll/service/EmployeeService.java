package com.roman.payroll.service;

import com.roman.payroll.entity.Employee;
import com.roman.payroll.response.ResponseWithResults;

import java.util.List;

public interface EmployeeService {
    void  saveEmployee(Employee e);

    void deleteEmployeeById(int eid);

    List<Employee> getAllEmployee();

    ResponseWithResults findEmployeeById(int eid);
    void update(Employee e, int id);
}
