package com.jacaranda;

import java.time.LocalDate;
import java.util.Objects;

public class CartId {
	private String nick;
	private int code_ele;
	private LocalDate dateBuy;
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getCode_ele() {
		return code_ele;
	}
	public void setCode_ele(int code_ele) {
		this.code_ele = code_ele;
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
		return Objects.hash(code_ele, dateBuy, nick);
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
		return code_ele == other.code_ele && Objects.equals(dateBuy, other.dateBuy) && Objects.equals(nick, other.nick);
	}
	
	
}
