package com.equipments.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equipments.entity.EquipmentEntity;
import com.equipments.model.Equipment;
import com.equipments.repository.EquipmentsRepository;

@Component
public class EquipmentsService {
	
	@Autowired
	private EquipmentsRepository repository;

	public List<Equipment> equipmentByCustomerId(int id) {

		List<EquipmentEntity> allEquipments = repository.findByCustomerId(id);
		
		List<Equipment>  equipmentsList = new ArrayList<>();
		
		for(EquipmentEntity ee: allEquipments) {
			Equipment equipment = new Equipment();
			BeanUtils.copyProperties(ee, equipment);
			equipmentsList.add(equipment);
		}
		
		return equipmentsList;
	}	
	
	
	public List<String> retrieveEquipmentsOnly(int id) {
		
		List<EquipmentEntity> allEquipments = repository.findByCustomerId(id);
		
		List<String> equipmentString = new ArrayList<>();
		
		for(EquipmentEntity ee: allEquipments) {
			String eName = ee.getName();
			equipmentString.add(eName);
		}
		
		return equipmentString;
	}
	
}
