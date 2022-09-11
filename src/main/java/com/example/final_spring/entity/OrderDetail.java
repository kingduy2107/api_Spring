package com.example.final_spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="status")
	private int status;
	
	@Column(name="amount")
	private int amount;
	
	@ManyToOne
	@JoinColumn(name="orders_id")
	Order order;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
