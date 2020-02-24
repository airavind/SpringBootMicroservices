package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.CustomerEntity;

public interface  CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	CustomerEntity findById(int id);

}
