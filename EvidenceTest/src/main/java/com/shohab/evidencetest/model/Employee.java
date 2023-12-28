/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shohab.evidencetest.model;

/**
 *
 * @author user
 */
public class Employee {
    private int emid;
    private String name;
    private String department;
    private String salary;

    public Employee() {
    }

    public Employee(int emid, String name, String department, String salary) {
        this.emid = emid;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmid() {
        return emid;
    }

    public void setEmid(int emid) {
        this.emid = emid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "emid=" + emid + ", name=" + name + ", department=" + department + ", salary=" + salary + '}';
    }
    
}
