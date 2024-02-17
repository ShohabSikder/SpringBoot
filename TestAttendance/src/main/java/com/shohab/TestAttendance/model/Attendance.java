package com.shohab.TestAttendance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // FetchType.LAZY to load employee lazily
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;
//    public LocalDateTime getLocalCheckIn() {
//        return checkIn.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
//    }
//
//    // Helper method to convert LocalDateTime to user's local time zone
//    public LocalDateTime getLocalCheckOut() {
//        return checkOut.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
//    }
}
