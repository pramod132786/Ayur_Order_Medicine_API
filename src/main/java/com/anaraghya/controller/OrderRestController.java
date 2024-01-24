package com.anaraghya.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anaraghya.consumer.OrderServiceConsumer;
//import com.anaraghya.entity.CartModuleEntity;
import com.anaraghya.entity.Customer;
import com.anaraghya.entity.Order;
import com.anaraghya.entity.OrderResponse;
import com.anaraghya.exception.OrderNotFoundException;
import com.anaraghya.service.OrderService;

/*Controller Class for Order Controller
Author : Shubham Tripathi
*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderServiceConsumer orderServiceConsumer;

	@Autowired
	private OrderResponse orderResponse;

	/****************************
	 * Method: createOrder Description: It is used to add Order into the ORDER_DTLS
	 * table
	 * 
	 * @returns return statement here is used to send an HTTP response with a
	 *          specific status code and response body after processing the order
	 *          creation or update operation.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 *               URL expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 * 
	 *               Created By- Shubham Tripathi
	 * 
	 ****************************/
	@PostMapping("/createOrder/{customerId}")
	public ResponseEntity<Order> createOrder(@RequestBody Order order, @PathVariable Integer customerId) {
		Order orderD = orderService.createOrder(order, customerId);
		System.out.println("Order Created");
		return new ResponseEntity<>(orderD, HttpStatus.CREATED);
	}

	// =========================================================================================================================================
	/****************************
	 * Method: getCustomer Description: It is used to get the customer based on
	 * CustomerId
	 * 
	 * @returns it will return a list of Customer objects based on the customerId
	 *          provided in the URL when this endpoint is accessed via a GET
	 *          request.
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given
	 *              URL expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 * 
	 *               Created By- Shubham Tripathi
	 * 
	 ****************************/
	@GetMapping("/getCust/{customerId}")
	public Order getCustomerById(@PathVariable Integer customerId) {
		return orderService.getCustomerById(customerId);

	}
	// =========================================================================================================================================

	/****************************
	 * Method:Show order based in orderId 
	 * Description: It is used to get order record based on orderId
	 * 
	 * @returns order based on orderId
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given
	 *              URL expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 * 
	 * 
	 *               Created By- Shubham Tripathi
	 * 
	 ****************************/

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> showOrder(@PathVariable Integer orderId) {
		Order order = orderService.showOrder(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	// =========================================================================================================================================

	/****************************
	 * Method: Get all the Orders Description: It is used to get all the order
	 * record
	 * 
	 * @returns all the orders
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given
	 *              URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 * 
	 * 
	 *               Created By- Shubham Tripathi
	 * 
	 ****************************/
	@GetMapping("/orders")
	public List<Order> showAllOrders() {
		List<Order> allOrders = orderService.showAllOrders();
		return allOrders;
	}

	// =========================================================================================================================================
	/****************************
	 * Method: Update the order Description: It is used to Update the order
	 * 
	 * @returns returns the status of the update operation as a response with an
	 *          HTTP status code of 200 OK.
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given
	 *              URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type. Created By-Shubham
	 *               Tripathi
	 * 
	 ****************************/

	@PutMapping("/updateOrder")
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {
		String status = orderService.upsertOrder(order);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	// =========================================================================================================================================
	/****************************
	 * Method: Update the order based on orderId 
	 * Description: It is used to Update the order based on orderId
	 * 
	 * @returns sends back a response with a status message indicating the result of
	 *          the update operation and an HTTP status code of 201 (Created) if the
	 *          operation was successful.
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given
	 *              URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type. Created By-Shubham
	 *               Tripathi
	 * 
	 ****************************/
	@PutMapping("/updateOrder/{orderId}")
	public ResponseEntity<String> updateOrderById(@PathVariable Integer orderId, @RequestBody Order order) {
		String status = orderService.upsertOrder(order);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	// =========================================================================================================================================
	/****************************
	 * Method: cancelOrder based on orderId Description: It is used to remove the
	 * order in the order_dtls
	 * 
	 * @returns returns a response containing the cancellation status with an HTTP
	 *          status code of 200 (OK).
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with
	 *                 given URL expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type. Created By: Shubham
	 *               Tripathi
	 * 
	 ****************************/
	@DeleteMapping("/cancelOrder/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable Integer orderId) {
		String status = orderService.cancelOrder(orderId);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	// =========================================================================================================================================
	/****************************
	 * Method: Update Order Status Description: 
	 * It is used to update the status of order
	 * 
	 * @returns whether the "Order not found" condition is met, this code will
	 *          return either an HTTP 404 response or an HTTP 200 response with a
	 *          String message as the response body.
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given
	 *              URL expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type. Created By-Shubham
	 *               Tripathi
	 * 
	 ****************************/
	@PutMapping("/{orderID}/updateStatus")
	public ResponseEntity<String> updateOrderStatus(@PathVariable Integer orderID, @RequestBody Order newOrderStatus) {
		String updateOrderStatus = orderService.updateOrderStatus(orderID, newOrderStatus);

		if (updateOrderStatus.startsWith("Order not found")) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(updateOrderStatus);
		}
	}

	// =========================================================================================================================================
	/****************************
	 * Method: get total cost based on orderId Description: It is used to get total
	 * cost based on orderId
	 * 
	 * @returns calculates the total cost for the order specified in the URL path
	 *          variable, and returns either the calculated total cost with a 200
	 *          status code or a 404 status code if the order is not found.
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given
	 *              URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 *               Created By: Shubham Tripathi
	 *               
	 * 
	 ****************************/

	@GetMapping("/{orderID}/totalCost")
	public ResponseEntity<Double> calculateTotalCost(@PathVariable Integer orderID) {
		try {
			double totalCost = orderService.calculateTotalCost(orderID);
			return ResponseEntity.ok(totalCost);
		} catch (OrderNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// =========================================================================================================================================
	/****************************
	 * Method: get customer details Description: It is used to get customer details
	 * using feign client
	 * 
	 * @returns the method returns the mainResponse list, which is a list of
	 *          OrderResponse objects.
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given
	 *              URL expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type. 
	 *               Created By: Shubham Tripathi
	 * 
	 ****************************/
	/*
	 * @GetMapping("/getOrderCustomerDetails") public List<OrderResponse>
	 * getOrderCustomerDetails() { List<OrderResponse> mainResponse = new
	 * ArrayList<OrderResponse>(); OrderResponse orderResponse = new
	 * OrderResponse(); Customer customerResponse = new Customer(); List<Order>
	 * orderModule = orderService.showAllOrders(); List<Customer> allCustomer =
	 * orderServiceConsumer.getAllCustomer();
	 * 
	 * for (Order order : orderModule) {
	 * orderResponse.setOrderId(order.getOrderId());
	 * orderResponse.setDispatchDate(order.getDispatchDate());
	 * orderResponse.setOrderDate(order.getOrderDate());
	 * orderResponse.setCost(order.getCost());
	 * orderResponse.setTotalCost(order.getTotalCost());
	 * orderResponse.setStatus(order.getOrderStatus());
	 * mainResponse.add(orderResponse); }
	 * 
	 * for (Customer customer : allCustomer) {
	 * customerResponse.setCustomerId(customer.getCustomerId());
	 * customerResponse.setCustomerName(customer.getCustomerName());
	 * customerResponse.setMobileNumber(customer.getMobileNumber());
	 * customerResponse.setEmailId(customer.getEmailId());
	 * customerResponse.setPassword(customer.getPassword());
	 * orderResponse.setCustomer(allCustomer);
	 * 
	 * }
	 * 
	 * return mainResponse; }
	 */
	
	
	
}
