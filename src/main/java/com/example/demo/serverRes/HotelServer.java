package com.example.demo.serverRes;

import java.util.List;

import com.example.demo.modelRes.HomeStay;

public interface HotelServer {
	
	HomeStay saveHotel(HomeStay hotel);
	List<HomeStay>  getHotelFromDb();
	HomeStay getHotelById(int hotelId);
	HomeStay updateHotelDetails(HomeStay hotel, int hotelId);
	void deleteHotelpById(int hotelId);

}
