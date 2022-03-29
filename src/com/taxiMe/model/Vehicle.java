package com.taxiMe.model;

public class Vehicle {
	private String vehicleNumber;
	private int noOfPasenger;
	private String type;
	private String address;
	private String ownerName;
	private String status;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vehicleNumber, int noOfPasenger, String type, String address, String ownerName,String status) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.noOfPasenger = noOfPasenger;
		this.type = type;
		this.address = address;
		this.ownerName = ownerName;
		this.status = status;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getNoOfPasenger() {
		return noOfPasenger;
	}

	public void setNoOfPasenger(int noOfPasenger) {
		this.noOfPasenger = noOfPasenger;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
