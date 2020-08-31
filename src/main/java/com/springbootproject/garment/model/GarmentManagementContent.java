package com.springbootproject.garment.model;

import java.util.List;

public class GarmentManagementContent {
	
	List<GarmentManagementDto> garmentManagementDtoList;
	int totalLength;
	
	public GarmentManagementContent() {
		
	}
	
	public List<GarmentManagementDto> getGarmentManagementDtoList() {
		return garmentManagementDtoList;
	}
	public void setGarmentManagementDtoList(List<GarmentManagementDto> garmentManagementDtoList) {
		this.garmentManagementDtoList = garmentManagementDtoList;
	}
	public int getTotalLength() {
		return totalLength;
	}
	public void setTotalLength(int totalLength) {
		this.totalLength = totalLength;
	}
}
