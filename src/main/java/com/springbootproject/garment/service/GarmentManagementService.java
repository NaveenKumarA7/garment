package com.springbootproject.garment.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.garment.model.GarmentManagementContent;
import com.springbootproject.garment.model.GarmentManagementDto;
import com.springbootproject.garment.repository.GarmentManagementRepository;

@Service
public class GarmentManagementService {
	
	@Autowired
	GarmentManagementRepository garmentManagementRepository;
	
	public GarmentManagementDto insertGarmentDetail(GarmentManagementDto garmentManagementDto) {
		System.out.println("---------------------------2-----------------");
			return garmentManagementRepository.save(garmentManagementDto);
	}
	
	public GarmentManagementContent viewAllGarmentDetail(String filter, String sortOrder, int pageIndex, int pageSize) {
		List<GarmentManagementDto> garmentManagementDtoList = garmentManagementRepository.findAll();
		GarmentManagementContent garmentManagementContent = new GarmentManagementContent();
		garmentManagementContent.setTotalLength(garmentManagementDtoList.size());
		pageSize = (pageSize == -1 || pageSize > garmentManagementContent.getTotalLength()) ? garmentManagementContent.getTotalLength() : pageSize;
		garmentManagementContent.setGarmentManagementDtoList(getFilterListValue(garmentManagementDtoList, filter, sortOrder).subList(pageIndex, pageSize));
		return garmentManagementContent;
	}
	
	public static List<GarmentManagementDto> getFilterListValue(List<GarmentManagementDto> garmentManagementDtoList, String filter, String sortOrder) {
		switch(filter) {
			case "garmentName": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getGarmentName, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
			case "purchaseDate": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getPurchaseDate, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
			case "materialName": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getMaterialName, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
			case "materialColor": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getMaterialColor, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
			case "materialWeight": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getMaterialWeight, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
			case "materialPrice": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getMaterialPrice, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
			case "totalAmount": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getTotalAmount, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
			case "balanceAmount": garmentManagementDtoList.sort(Comparator.comparing(GarmentManagementDto::getBalanceAmount, sortOrder.equals("asc") ? Comparator.naturalOrder() : Comparator.reverseOrder()));
				break;
		}
		return garmentManagementDtoList;
	}
	
	public GarmentManagementDto findByGarmentName(String name) {
		return garmentManagementRepository.findByGarmentName(name);
	}
	
	public GarmentManagementDto updateGarmentDetail(String name, Date date) {
		GarmentManagementDto garmentManagementDto = garmentManagementRepository.findByGarmentName(name);
		garmentManagementDto.setPurchaseDate(date);
		return garmentManagementRepository.save(garmentManagementDto);
	}
	
	public void deleteAllGarmentDetail() {
		garmentManagementRepository.deleteAll();
	}
	
	public void deleteGarmentDetail(String name) {
		GarmentManagementDto garmentManagementDto = garmentManagementRepository.findByGarmentName(name);
		garmentManagementRepository.delete(garmentManagementDto);
	}
}
