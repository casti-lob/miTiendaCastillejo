package com.jacaranda;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="PRODUCT")
public class Cart {
	@Id
	@ManyToOne
	@JoinColumn(name="nick")
	private String nick;
	private int code_ele;
	private int number;
	private double price;
	private LocalDate dateBuy;
	
	
	
	
}
