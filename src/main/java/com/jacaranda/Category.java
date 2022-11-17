package com.jacaranda;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity(name="CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code_cat;
	private String name;
	private String description;
	@OneToMany(mappedBy = "categ")
	private Set<Element> element;
	
	public Category() {
		super();
	}

	public int getCode_cat() {
		return code_cat;
	}

	public void setCode_cat(int code_cat) {
		this.code_cat = code_cat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Element> getElement() {
		return element;
	}

	public void setElement(Set<Element> element) {
		this.element = element;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code_cat, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return code_cat == other.code_cat && Objects.equals(name, other.name);
	}
	
	
}
