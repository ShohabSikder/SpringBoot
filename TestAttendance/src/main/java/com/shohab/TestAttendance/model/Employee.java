package com.shohab.TestAttendance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Define the relationship with Attendance entity
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Attendance> attendances;
}
