package com.shohab.TestSpringBoot55.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roll;
    @Column(name = "studentName", length = 50)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String gender;
    private String department;
    private String hobby;
    private Date DOB;


}
