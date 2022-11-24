package com.jacaranda;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CartId implements Serializable{
	private String user;
	private int element;
	private LocalDate dateBuy;
	
	
	public CartId() {
		super();
	}
	
	public CartId(String nick, int code_ele, LocalDate dateBuy) {
		super();
		this.user = nick;
		this.element = code_ele;
		this.dateBuy = dateBuy;
	}

	public String getNick() {
		return user;
	}
	public void setNick(String nick) {
		this.user = nick;
	}
	public int getCode_ele() {
		return element;
	}
	public void setCode_ele(int code_ele) {
		this.element = code_ele;
	}
	public LocalDate getDateBuy() {
		return dateBuy;
	}
	public void setDateBuy(LocalDate dateBuy) throws CardException {
		if(dateBuy.isAfter(LocalDate.now())) {
			throw new CardException("No puedes comprar varias veces en el mismo dia");
		}
		this.dateBuy = dateBuy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(element, dateBuy, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartId other = (CartId) obj;
		return element == other.element && Objects.equals(dateBuy, other.dateBuy) && Objects.equals(user, other.user);
	}
	
	
}
