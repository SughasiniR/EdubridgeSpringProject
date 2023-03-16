package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.modelRes.HomeStay;
import com.example.demo.repository.HotelRepo;
import com.example.demo.serverRes.HotelServer;
@Service
public class HotelServiceImpl implements HotelServer{
	HotelRepo hotelRepo;

	public HotelServiceImpl(HotelRepo hotelRepo) {
		this.hotelRepo = hotelRepo;
	}

	public HomeStay saveHotel(HomeStay hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public List<HomeStay> getHotelFromDb() {
		return hotelRepo.findAll();
	}

	@Override//5
	public HomeStay getHotelById(int hotelId) {
		Optional<HomeStay> hotel = hotelRepo.findById(hotelId);
		if(hotel.isPresent()) {
			return hotel.get();
		}
		else {
			return null;
		}
	}

	@Override
	public HomeStay updateHotelDetails(HomeStay newVal, int hotelId) {
		Optional<HomeStay> hotel = hotelRepo.findById(hotelId);
		if(hotel.isPresent()) {
			HomeStay existingHotel = hotel.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingHotel.setHotelName(newVal.getHotelName());
			existingHotel.setPlace(newVal.getPlace());
			existingHotel.setState(newVal.getState());
			existingHotel.setRatings(newVal.getRatings());
			existingHotel.setAmenities(newVal.getAmenities());
			existingHotel.setMeals(newVal.getMeals());
			existingHotel.setContact(newVal.getContact());
			hotelRepo.save(existingHotel);
			return existingHotel;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteHotelpById(int hotelId) {
		Optional<HomeStay> hotel = hotelRepo.findById(hotelId);
		if(hotel.isPresent()) {
			hotelRepo.deleteById(hotelId);
		}	
	}

}
