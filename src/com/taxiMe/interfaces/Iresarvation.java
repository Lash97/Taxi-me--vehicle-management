package com.taxiMe.interfaces;

import java.util.ArrayList;

import com.taxiMe.model.Resarvation;
  

public interface Iresarvation {
	public ArrayList<Resarvation> getResarvationList();
	public Resarvation getResarvation(int id); 
	public ArrayList<Resarvation> getResarvationByUserId(int userId);
	public ArrayList<Resarvation> getResarvationByStatus(String status);
	public ArrayList<Resarvation> getResarvationByVehicle(String id);
	public boolean addResarvation(Resarvation resarvation);
	public boolean updateResarvation (Resarvation resarvation);
	public boolean deleteResarvation(int id);
	public boolean clangeResarvationStatus(int id ,String status);
}
