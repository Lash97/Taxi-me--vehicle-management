package com.taxiMe.interfaces;

import java.util.ArrayList;

import com.taxiMe.model.Maintaine;
  

public interface Imaintain {
	public ArrayList<Maintaine> getMaintaineList();
	public ArrayList<Maintaine> getMaintaineByVehicleId(String id);
	public Maintaine getMaintaine(int id);
	public boolean addMaintaine(Maintaine maintaine);
	public boolean updateMaintaine (Maintaine maintaine);
	public boolean deleteMaintaine(int id);
}
