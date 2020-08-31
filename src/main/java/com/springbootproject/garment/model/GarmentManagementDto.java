package com.springbootproject.garment.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "garment_details_test")
public class GarmentManagementDto {
	
	@Id
	private String purchaseNumber;
	
	private String garmentName;
	
	private Date purchaseDate;
	
	private String materialName;
	
	private String materialColor;
	
	private int materialWeight;
	
	private int materialPrice;
	
	private int totalAmount;
	
	private int amountPaid;
	
	private int balanceAmount;
	
	public GarmentManagementDto() {
		
	}
	
	public GarmentManagementDto(String garmentName, Date purchaseDate, String materialName, String materialColor,
		int materialWeight, int materialPrice, int totalAmount, int amountPaid, int balanceAmount) {
		this.garmentName = garmentName;
		this.purchaseDate = purchaseDate;
		this.materialName = materialName;
		this.materialColor = materialColor;
		this.materialWeight = materialWeight;
		this.materialPrice = materialPrice;
		this.totalAmount = totalAmount;
		this.amountPaid = amountPaid;
		this.balanceAmount = balanceAmount;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	
	public String getGarmentName() {
		return garmentName;
	}

	public void setGarmentName(String garmentName) {
		this.garmentName = garmentName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialColor() {
		return materialColor;
	}

	public void setMaterialColor(String materialColor) {
		this.materialColor = materialColor;
	}

	public int getMaterialWeight() {
		return materialWeight;
	}

	public void setMaterialWeight(int materialWeight) {
		this.materialWeight = materialWeight;
	}

	public int getMaterialPrice() {
		return materialPrice;
	}

	public void setMaterialPrice(int materialPrice) {
		this.materialPrice = materialPrice;
	}
	
	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
}
