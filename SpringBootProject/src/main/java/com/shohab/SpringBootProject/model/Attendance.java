package com.shohab.SpringBootProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "attendance")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private String inTime;
    @Column(nullable = false)
    private String outTime;
    @Column(nullable = false)
    private String date;

}
