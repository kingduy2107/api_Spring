package com.example.final_spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_spring.entity.Order;
import com.example.final_spring.entity.User;
import com.example.final_spring.repository.OrderRepository;

@Service
@Transactional
public class OrderService implements OrderServiceImp {
	
	@Autowired OrderRepository orderRepository;
	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return  orderRepository.findAll();
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrderById(int id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
	}

	@Override
	public Optional<Order> findOrderById(int id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}
	
}
