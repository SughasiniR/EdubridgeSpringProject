package com.example.demo.controllerRes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelRes.HomeStay;
import com.example.demo.service.HotelServiceImpl;

@RestController
public class HotelController {
public HotelServiceImpl hotelServer;
		
	public HotelController(HotelServiceImpl hotelServer) {
		this.hotelServer = hotelServer;
	}

	@PostMapping("/saveHotel")
	public ResponseEntity<HomeStay> saveHotel(@RequestBody HomeStay hotel){
		return new ResponseEntity<HomeStay>(hotelServer.saveHotel(hotel), HttpStatus.CREATED);
	}
		
	@PutMapping("/updateHotel/{hotelId}")
	public ResponseEntity<HomeStay> updateHotelById(@PathVariable("hotelId") int id,
			@RequestBody HomeStay hotel){
		return new ResponseEntity<HomeStay>(hotelServer.updateHotelDetails(hotel, id), HttpStatus.OK);		
	}
	
	@GetMapping("/readAllHotel")
	public List<HomeStay> getAllHotel(){
		return hotelServer.getHotelFromDb();
	}
	
	//localhost:8080
	@GetMapping("/readHotel/{id}")
	public ResponseEntity<HomeStay>  getHotelById(@PathVariable("id")  int hotelId){
		return new ResponseEntity<HomeStay>(hotelServer.getHotelById(hotelId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteHotel/{id}")
	public ResponseEntity<String> deleteHotelById(@PathVariable("id")  int hotelId){
		hotelServer.deleteHotelpById(hotelId);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}

	
}
