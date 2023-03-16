package com.example.demo.modelRes;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "home_stay")
@DynamicUpdate
public class HomeStay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "hotel_name", nullable = false)
	private String hotelName;
	private int ratings;
	private String place;
	private String state;
	private String amenities;
	private String meals;
	private int contact;
public HomeStay() {}
	
	public HomeStay(String hotelName, String place, String state,int ratings,String amenities,String meals,int contact) {
		this.hotelName = hotelName;
		this.place = place;
		this.state=state;
		this.ratings=ratings;
		this.amenities=amenities;
		this.meals=meals;
		this.contact=contact;
	}
	
	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMeals() {
		return meals;
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	

}
