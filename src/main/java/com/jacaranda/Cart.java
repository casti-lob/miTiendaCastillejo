package com.jacaranda;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="PRODUCT")
@IdClass(CartId.class)
public class Cart {
	@Id
	@ManyToOne
	@JoinColumn(name="nick")
	private Users user;
	
	
	
	@Id 
	@ManyToOne
	@JoinColumn(name="code_ele")
	private Element element;
	
	
	@Id
	private LocalDate dateBuy;
	
	private int number;
	private double price;
	
	public Cart(Users user, Element element, LocalDate dateBuy, int number, double price) {
		super();
		this.user = user;
		this.element = element;
		this.dateBuy = dateBuy;
		this.number = number;
		this.price = price;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public LocalDate getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(LocalDate dateBuy) {
		this.dateBuy = dateBuy;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) throws CardException {
		if (number<1) {
			throw new CardException("La cantidad no puede ser menor que 1");
		}
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws CardException {
		if(price<1) {
			throw new CardException("El precio no puede ser menor a 1");
		}
		this.price = price;
	}
	
	
	
	
	
}
