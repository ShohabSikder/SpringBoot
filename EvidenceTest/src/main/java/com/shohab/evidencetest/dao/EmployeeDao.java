/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shohab.evidencetest.dao;

import com.shohab.evidencetest.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author user
 */
public class EmployeeDao {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveEmp(Employee e) {

        String sql = "insert into employee(name, department, salary)"
                + "values('" + e.getName() + "', '" + e.getDepartment() + "', '" + e.getSalary() + "')";

        return jdbcTemplate.update(sql);
    }
   public int deleteEmp(int id) {

        String sql = "delete from employee where emid=" + id + " ";

        return jdbcTemplate.update(sql);
    } 
   public int updateEmp(Employee e) {

        String sql = "update  employee set name='" + e.getName() + "', department='" + e.getDepartment() + "', salary='" + e.getSalary() + "' where emid='" + e.getEmid() + "' ";

        return jdbcTemplate.update(sql);
    }
    
   public List<Employee> getAllEmp() {
        return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee e = new Employee(
                        rs.getInt("emid"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("salary")
                      
                );

                return e;
            }
        });
    }
   
    public Employee getEmpById(int id) {
        String sql = "select * from employee where emid=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
    } 
}
