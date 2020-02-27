package com.equipments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.equipments.entity.EquipmentEntity;
import com.equipments.model.Equipment;
import com.equipments.repository.EquipmentsRepository;
import com.equipments.service.EquipmentsService;

@RestController
public class EquipmentsController {
	
	@Autowired
	private EquipmentsRepository repository;

	@Autowired
	private EquipmentsService equipmentService;
	
	@PostMapping("/equipments")
	public EquipmentEntity newCustomer(@RequestBody EquipmentEntity newCustomer) {
	    return repository.save(newCustomer);
	  }
	 
	@GetMapping(value="/equipments/{customerId}")
	public ResponseEntity<List<Equipment>> getequipment(@PathVariable int customerId) {
		List<Equipment> equipments = equipmentService.equipmentByCustomerId(customerId);
		return  new ResponseEntity<>( equipments, HttpStatus.OK);
	}
	
	@GetMapping(value="/equipmentsOnly/{customerId}")
	public List<String> getEquipmentsOnly(@PathVariable int customerId){
		List<String> equipmentsOnly = equipmentService.retrieveEquipmentsOnly(customerId);
		return equipmentsOnly;
	}
	
	/*
	@GetMapping("/customer/{id}")
	@ResponseBody
	public EquipmentEntity retrieveCustomer(@PathVariable int id) {
		return customerService.retrieveCustomer(id);
	}	
	
	@GetMapping("/customer/equipments/{id}")
	@ResponseBody
	public String[] retrieveEquipments(@PathVariable int id) {
		return customerService.retrieveEquipments(id);
	}	
	 */	
}