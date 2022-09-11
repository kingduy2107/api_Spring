package com.example.final_spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_spring.entity.Order;
import com.example.final_spring.entity.User;
import com.example.final_spring.service.OrderService;
import com.example.final_spring.service.UserService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("")
	public ResponseEntity<?> getAllOrder() {
		return new ResponseEntity<List<Order>>(orderService.getAllOrder(), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.createOrder(order),HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteOrderById(@PathVariable("id") int id) {
		try {
			orderService.deleteOrderById(id);
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateOrderById(@PathVariable("id") int id, @RequestBody Order order) {
		Optional<Order> optional = orderService.findOrderById(id);
		if (optional.isPresent()) {
			Order _order = optional.get();
			_order.setStatus(order.getStatus());
			_order.setDescription(order.getDescription());
			_order.setTotal(order.getTotal());
			_order.setPayment(order.getDescription());
			_order.setCreateAt(order.getCreateAt());
			User user = new User();
			user.setId(order.getUser().getId());
			_order.setUser(user);
			
			return new ResponseEntity<Order>(orderService.createOrder(_order), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
