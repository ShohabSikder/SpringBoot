package com.shohab.SpringBootProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "employeeLeave")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( nullable = false)
    private String name;

    @Column( nullable = false)
    private String department;

    @Column( nullable = false)
    private String leaveType;

    @Column( nullable = false)
    private String leaveDate;

    @Column( nullable = false)
    private String reason;

}
