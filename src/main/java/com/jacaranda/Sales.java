package com.jacaranda;

import java.util.ArrayList;
import java.util.List;

public class Sales {
	private List<Element> mysales;

	public Sales() {
		super();
		this.mysales=new ArrayList<Element>();
	}

	public List<Element> getMysales() {
		return mysales;
	}

	public void setMysales(Element mysales) {
		this.mysales.add(mysales);
	}
	
}
