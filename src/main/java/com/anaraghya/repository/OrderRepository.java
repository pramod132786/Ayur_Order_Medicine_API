package com.anaraghya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anaraghya.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	public Order findByCustomerId(Integer customerId);

}
