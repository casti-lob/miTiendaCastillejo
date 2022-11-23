package com.jacaranda;

import java.util.ArrayList;
import java.util.List;

public class Sales {
	private List<Element> mysales = new ArrayList<>();

	public Sales() {
		
	}

	public List<Element> getMysales() {
		return mysales;
	}

	public void setMysales(Element mysales) {
		this.mysales.add(mysales);
	}
	
}
