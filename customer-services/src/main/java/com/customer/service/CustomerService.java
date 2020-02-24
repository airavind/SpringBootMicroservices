package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.entity.CustomerEntity;
import com.customer.repository.CustomerRepository;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	public CustomerEntity retrieveCustomer(int id) {
		
		CustomerEntity customer = repository.findById(id);
		
		return customer;
	}
}
