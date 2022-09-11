package com.example.final_spring.service;

import java.util.List;
import java.util.Optional;

import com.example.final_spring.entity.Order;
import com.example.final_spring.entity.User;

public interface OrderServiceImp {
	public List<Order> getAllOrder();
	public Order createOrder(Order order);
	public void deleteOrderById(int id);
	public Optional<Order> findOrderById(int id);
}
