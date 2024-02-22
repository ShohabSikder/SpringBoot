package com.shohab.TestAttendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TestAttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAttendanceApplication.class, args);
		String timestampString = "2024-02-18T06:36:13.116Z";

		// Parse the timestamp string with time zone offset
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(timestampString, DateTimeFormatter.ISO_DATE_TIME);

		// Convert to LocalDateTime (remove time zone information)
		LocalDateTime localDateTime = (LocalDateTime) zonedDateTime.toLocalDateTime();

		System.out.println("Parsed LocalDateTime: " + localDateTime);
	}
	}


