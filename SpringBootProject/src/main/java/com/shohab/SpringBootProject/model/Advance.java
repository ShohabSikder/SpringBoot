package com.shohab.SpringBootProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "advance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( nullable = false)
    private String name;

    @Column( nullable = false)
    private String department;

    @Column( nullable = false)
    private int amount;

    @Column( nullable = false)
    private String advanceDate;

    @Column( nullable = false)
    private String reason;

}
