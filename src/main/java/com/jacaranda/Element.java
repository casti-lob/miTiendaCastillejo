package com.jacaranda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="ELEMENT")
public class Element {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code_ele;
	private String name_ele;
	private String description_ele;
	private double price;
	private String img;
	@ManyToOne
	@JoinColumn(name = "code_cat")
	private Category categ;
	
	@OneToMany(mappedBy = "element")
	private List<Cart> cart = new ArrayList<>();
	
	public Element() {
		super();
	}

	public int getCode_ele() {
		return code_ele;
	}

	public void setCode_ele(int code_ele)  {
		this.code_ele = code_ele;
	}

	public String getName_ele() {
		return name_ele;
	}

	public void setName_ele(String name_ele) throws ElementException {
		if(name_ele.length()>100||name_ele.length()<2) {
			throw new ElementException("Nombre del elemento demasiado largo o corto");
		}
		this.name_ele = name_ele;
	}

	public String getDescription_ele() {
		return description_ele;
	}

	public void setDescription_ele(String description_ele) throws ElementException {
		if(description_ele.length()>300||description_ele.length()<2) {
			throw new ElementException("Descripcion del elemento demasiado larga o corta");
		}
		this.description_ele = description_ele;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws ElementException{
		if(price<=0.5) {
			throw new ElementException("El precio no puede ser inferior a 0.5");
		}
		this.price = price;
	}

	public Category getCateg() {
		return categ;
	}

	public void setCateg(Category categ) {
		this.categ = categ;
	}
	
	
}
