package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.CustomerEntity;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/{id}")
	@ResponseBody
	public CustomerEntity retrieveCustomer(@PathVariable int id) {
		return customerService.retrieveCustomer(id);
	}	
	
	@PostMapping("/customer")
	CustomerEntity newCustomer(@RequestBody CustomerEntity newCustomer) {
	    return repository.save(newCustomer);
	  }
}