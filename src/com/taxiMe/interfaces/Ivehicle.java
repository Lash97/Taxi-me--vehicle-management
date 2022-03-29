package com.taxiMe.interfaces;

import java.util.ArrayList;

import com.taxiMe.model.Vehicle;

public interface Ivehicle {
	
	public ArrayList<Vehicle> getVehicleList();
	public Vehicle getVehicle(String id);
	public ArrayList<Vehicle> getVehicleByStatus(String status);
	public boolean addvehicle(Vehicle vehicle);
	public boolean updateVehicle (Vehicle vehicle);
	public boolean deleteVehicle(String id);
	public void changeVehicleStatus(String status,String id);
	
}
