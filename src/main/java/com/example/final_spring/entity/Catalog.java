package com.example.final_spring.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name ="catalog")
public class Catalog {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy ="catalog")
	private Set<Product> products;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
