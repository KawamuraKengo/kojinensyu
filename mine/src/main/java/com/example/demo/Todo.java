package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private int id;
	private String task;
	private LocalDate deadLineDate;
	private LocalTime deadLineTime;
	private boolean everyDay=false;
	private boolean complete=false;
	private boolean warning=false;
	
	public boolean getWarnig() {
		return this.warning;
	}
}
