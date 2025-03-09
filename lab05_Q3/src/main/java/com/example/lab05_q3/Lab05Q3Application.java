package com.example.lab05_q3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab05Q3Application {

	public static void main(String[] args) {
		//event Class : ID , description , capacity, startDate , endDate
		//• Create a new event (ID , description , capacity, startDate , endDate)
		//• Display all event .
		//• Update a event
		//• Delete a event
		//• Change capacity
		//• Search for a event by given id

		//Hint ( use @JsonFormat(pattern="yyyy-MM-dd") and LocalDateTime )
		SpringApplication.run(Lab05Q3Application.class, args);
	}

}
