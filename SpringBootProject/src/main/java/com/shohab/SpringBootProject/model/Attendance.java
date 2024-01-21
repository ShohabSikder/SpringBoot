package com.shohab.SpringBootProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "attendance")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER , cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;



    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

}
