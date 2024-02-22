package com.shohab.CreateApi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-argument constructor
@Entity
public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date joiningDate;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private String salary;
    @ManyToOne
    private Department department;


}
