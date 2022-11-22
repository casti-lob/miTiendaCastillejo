package com.jacaranda;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="PRODUCT")
public class Cart {
	@Id
	private String nick;
	@ManyToOne
	@JoinColumn(name="nick")
	
	@Id 
	private int code_ele;
	@ManyToOne
	
	@Id
	private LocalDate dateBuy;
	
	private int number;
	private double price;
	
	
	
	
	
}
