package com.taxiMe.model;

public class Accident {
	private int id;
	private String vehicleId;
	private String location;
	private String date;
	private String time;
	private String vehicleType;
	private String drivername;
	
	public Accident() {
		super();
	}

	public Accident(int id, String vehicleId, String location, String date, String time, String vehicleType,
			String drivername) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.location = location;
		this.date = date;
		this.time = time;
		this.vehicleType = vehicleType;
		this.drivername = drivername;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
