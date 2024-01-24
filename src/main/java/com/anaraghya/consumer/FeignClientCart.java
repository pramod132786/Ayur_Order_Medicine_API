//package com.anaraghya.consumer;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.anaraghya.entity.CartModuleEntity;
//
//@FeignClient(name = "feigncart", url = "http://localhost:9091/api/v1/")
//public interface FeignClientCart {
//		/*
//		 * @GetMapping("/customerData") public List<Customer>
//		 * viewAllCustomerDataDetails();
//		 */
//
//	@GetMapping("/cart")
//	public ResponseEntity<List<CartModuleEntity>> showAll();
//
//}
//
//
//
