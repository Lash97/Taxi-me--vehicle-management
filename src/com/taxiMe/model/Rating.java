package com.taxiMe.model;

public class Rating {
	private int id;
	private int userid;
	private int rating;
	private String description;
	public Rating() {
		super();
	}
	public Rating(int id, int userid, int rating, String description) {
		super();
		this.id = id;
		this.userid = userid;
		this.rating = rating;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
