package com.springbootproject.garment.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.garment.model.GarmentManagementContent;
import com.springbootproject.garment.model.GarmentManagementDto;
import com.springbootproject.garment.service.GarmentManagementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/garment-management/api")
public class GarmentManagementController {

	@Autowired
	GarmentManagementService garmentManagementService;
	
	@ResponseBody
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody GarmentManagementDto garmentManagementDto) {
		try {
			GarmentManagementDto updatedGarmentManagementDto = garmentManagementService.insertGarmentDetail(garmentManagementDto);
			return new ResponseEntity<String>(Objects.nonNull(updatedGarmentManagementDto) ? "Inserted" : null, HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			return ResponseEntity.ok("INTERNAL_SERVER_ERROR");
		}
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<GarmentManagementContent> viewAll(String filter, String sortOrder, int pageIndex, int pageSize) {
		try {
			GarmentManagementContent garmentManagementContent = garmentManagementService.viewAllGarmentDetail(filter, sortOrder, pageIndex, pageSize);
			return new ResponseEntity<>(garmentManagementContent, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/find")
//	public ResponseEntity<List<GarmentManagementDto>> find() {
//		try {
//			List<GarmentManagementDto> updatedGarmentManagementDto = GarmentManagementService.viewAllGarmentDetail();
//			return new ResponseEntity<>(updatedGarmentManagementDto, HttpStatus.CREATED);
//		}
//		catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
