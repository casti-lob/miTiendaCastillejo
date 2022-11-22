package com.jacaranda;

import java.util.List;

public class Sales {
	private List<Sales> mysales;

	public Sales(List<Sales> mysales) {
		super();
		this.mysales = mysales;
	}

	public List<Sales> getMysales() {
		return mysales;
	}

	public void setMysales(Sales mysales) {
		this.mysales.add(mysales) ;
	}
	
}
