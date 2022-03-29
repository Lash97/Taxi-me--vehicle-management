package com.taxiMe.interfaces;

import java.util.ArrayList;

import com.taxiMe.model.Rating;

public interface Irating {
	public ArrayList<Rating> getRatingList();
	public ArrayList<Rating> getRatingLByStar(int star);
	public Rating getRating(int id);
	public boolean addRating(Rating rating);
	public boolean updateRating (Rating rating);
	public boolean deleteRating(int id);
	
}
