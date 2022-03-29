package com.taxiMe.interfaces;

import java.util.ArrayList;

import com.taxiMe.model.Accident;
 

public interface Iaccident {
	public ArrayList<Accident> getAccidentList();
	public ArrayList<Accident> getAccidentByVehicleId(String id);
	public Accident getAccident(int id);
	public boolean addAccident(Accident accident);
	public boolean updateAccident (Accident accident);
	public boolean deleteAccident(int id);
}
