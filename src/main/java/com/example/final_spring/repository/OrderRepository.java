package com.example.final_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.final_spring.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
