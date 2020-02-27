package com.equipments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.equipments.entity.EquipmentEntity;

public interface  EquipmentsRepository extends JpaRepository<EquipmentEntity, Long> {
	
	//EquipmentEntity findById(int id);
	
	@Query("SELECT e FROM EquipmentEntity e WHERE e.customerID = ?1")
	List<EquipmentEntity> findByCustomerId(int id);
	
}
