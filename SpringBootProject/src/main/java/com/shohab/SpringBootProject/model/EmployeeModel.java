package com.shohab.SpringBootProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String contact;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joiningDate;
    private String salary;
    private String gender;
    private String department;

}
