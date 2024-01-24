package com.anaraghya.service;

import java.util.List;

import com.anaraghya.entity.Customer;
import com.anaraghya.entity.Order;

public interface OrderService {

	public String upsertOrder(Order order);

	public Order createOrder(Order order, Integer customerId);

	public Order showOrder(Integer orderId);

	public List<Order> showAllOrders();

	public String cancelOrder(Integer orderId);

	public String updateOrderStatus(Integer orderID, Order newOrderStatus);

	public double calculateTotalCost(Integer orderID);
	
	// public List<Order> showOrdersByCustomer(Integer customerID);
	
	public Order getCustomerById(Integer customerId);
	
	

}
