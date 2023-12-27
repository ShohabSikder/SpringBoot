/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shohab.midevdtest.dao;

import com.shohab.midevdtest.model.Student;
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
public class StudentDao {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveStu(Student s) {

        String sql = "insert into student(roll,name, department, marks)"
                + "values('" + s.getRoll() + "', '" + s.getName() + "', '" + s.getDepartment() + "','" + s.getMarks() + "')";

        return jdbcTemplate.update(sql);
    }
    public int deleteStu(int id) {

        String sql = "delete from student where sid=" + id + " ";

        return jdbcTemplate.update(sql);
    }
    public int updateStu(Student s) {

        String sql = "update  student set roll='" + s.getRoll() + "', name='" + s.getName() + "', department='" + s.getDepartment() + "', marks='" + s.getMarks() + "' where sid='" + s.getSid() + "' ";

        return jdbcTemplate.update(sql);
    }
    public List<Student> getAllStu() {
        return jdbcTemplate.query("select * from student", new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int row) throws SQLException {
                Student s = new Student(
                        rs.getInt("sid"),
                        rs.getString("roll"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("marks")
                );

                return s;
            }
        });
    }
    
    public Student getStuById(int id) {
        String sql = "select * from student where sid=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    } 
}
