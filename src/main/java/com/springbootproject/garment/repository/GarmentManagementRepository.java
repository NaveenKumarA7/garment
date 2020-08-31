package com.springbootproject.garment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springbootproject.garment.model.GarmentManagementDto;

public interface GarmentManagementRepository extends MongoRepository<GarmentManagementDto, Integer> {
	
	GarmentManagementDto findByGarmentName(String garmentName);
	
}
