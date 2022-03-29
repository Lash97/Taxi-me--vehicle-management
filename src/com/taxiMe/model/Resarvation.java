package com.taxiMe.model;

public class Resarvation {
	private int id;
	private int userId;
	private String VehicleId;
	private String pickupLocation;
	private String dropLocation;
	private String time;
	private String date;
	private String vehicleType;
	private String status;
	
	public Resarvation() {
		super();
	}
	public Resarvation(int id, int userId, String vehicleId, String pickupLocation, String dropLocation, String time,
			String date, String vehicleType,String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.VehicleId = vehicleId;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.time = time;
		this.date = date;
		this.vehicleType = vehicleType;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getVehicleId() {
		return VehicleId;
	}
	public void setVehicleId(String vehicleId) {
		VehicleId = vehicleId;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
