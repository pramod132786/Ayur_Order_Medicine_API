package com.anaraghya.consumer;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.anaraghya.entity.Customer;
//import com.anarghya.aayurvedaapp.entity.CustomerModule;

//@FeignClient(name = "customerfeign", url = "http://localhost:9091/api/v1/")
@FeignClient(name = "customerfeign", url = "http://localhost:8081/api/v1")
public interface OrderServiceConsumer {
	/*
	 * @GetMapping("/customerData") public List<Customer>
	 * viewAllCustomerDataDetails();
	 */

	/*
	 * @GetMapping("/customers") public List<Customer> getAllCustomer();
	 */

//	@GetMapping("/gcustomer/{customerId}")
//	public Customer getCustomer(@PathVariable Integer customerId);
	
	@GetMapping("/get/{customerId}")
	public Customer getCustomerById(@PathVariable Integer customerId);

}
