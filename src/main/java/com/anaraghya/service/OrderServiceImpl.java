package com.anaraghya.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anaraghya.consumer.OrderServiceConsumer;
import com.anaraghya.entity.Customer;
import com.anaraghya.entity.Order;
import com.anaraghya.exception.OrderNotFoundException;
import com.anaraghya.repository.CustomerRepository;
import com.anaraghya.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderServiceConsumer feign;

	@Override
	public String upsertOrder(Order order) {
		orderRepository.save(order);
		return "Success";
	}

//	@Override
//	public Order createOrder(Order order, Integer customerId) {
//		Customer customer = new Customer();
//		Order order1 = new Order();
//
//		Customer customerDetails = feign.getCustomer(customerId);
//		customer.setCustomerId(customerDetails.getCustomerId());
//		customer.setCustomerName(customerDetails.getCustomerName());
//		customer.setEmailId(customerDetails.getEmailId());
//		customer.setMobileNumber(customerDetails.getMobileNumber());
//		customer.setPassword(customerDetails.getPassword());
//		System.out.println(customerDetails.getCustomerName());
//		System.out.println(order.getOrderDate());
//		order1.setCost(order.getCost());
//		order1.setDispatchDate(order.getDispatchDate());
//		order1.setOrderDate(order.getOrderDate());
//		order1.setStatus(order.getOrderStatus());
//		order1.setTotalCost(order.getTotalCost());
//		order1.setCustomer(customer);
//		orderRepository.save(order1);
//		return order1;
//	}
	
	@Override
	public Order createOrder(Order order, Integer customerId) {
		Customer customer = new Customer();
		Order order1 = new Order();

		Customer customerDetails = feign.getCustomerById(customerId);
		customer.setCustomerId(customerDetails.getCustomerId());
		customer.setCustomerName(customerDetails.getCustomerName());
		customer.setEmailId(customerDetails.getEmailId());
		customer.setMobileNumber(customerDetails.getMobileNumber());
		customer.setPassword(customerDetails.getPassword());
		System.out.println(customerDetails.getCustomerName());
		System.out.println(order.getOrderDate());
		order1.setCost(order.getCost());
		order1.setDispatchDate(order.getDispatchDate());
		order1.setOrderDate(order.getOrderDate());
		order1.setStatus(order.getOrderStatus());
		order1.setTotalCost(order.getTotalCost());
		order1.setCustomer(customer);
		order1.setCustomeremailId(customerDetails.getEmailId());
		orderRepository.save(order1);
		return order1;
	}

	
	@Override
	public Order showOrder(Integer orderId) {
		Optional<Order> findById = orderRepository.findById(orderId);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	
	@Override
	public List<Order> showAllOrders() {
		List<Order> orderdata = new ArrayList<Order>();
		List<Order> findAll = orderRepository.findAll();
		if (!findAll.isEmpty()) {
			findAll.forEach(c -> orderdata.add(c));
			return orderdata;
		}
		return null;
	}


	@Override
	public String cancelOrder(Integer orderId) {
		if (orderRepository.existsById(orderId)) {
			orderRepository.deleteById(orderId);
			return "Delete Success";
		} else {
			return "No Record Found";
		}
	}

	
	@Override
	public String updateOrderStatus(Integer orderID, Order newOrderStatus) {
		Optional<Order> optionalOrder = orderRepository.findById(orderID);

		if (optionalOrder.isPresent()) {
			Order existingOrder = optionalOrder.get();
			existingOrder.setStatus(newOrderStatus.getOrderStatus());
			orderRepository.save(existingOrder);
			return "Order status updated successfully.";
		} else {
			return "Order not found with ID: " + orderID;
		}
	}

	
	@Override
	public double calculateTotalCost(Integer orderID) {
		Optional<Order> optionalOrder = orderRepository.findById(orderID);

		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			return order.getTotalCost();
		} else {
			throw new OrderNotFoundException("Order not found with ID: " + orderID);
		}
	}

	
	@Override
	public Order getCustomerById(Integer customerId) {
//		List<Customer> customer = new ArrayList<Customer>();
		Order findByCustomerId = orderRepository.findByCustomerId(customerId);
//		allCustomer.forEach(c -> customer.add(c));
		return findByCustomerId;
	}
}
