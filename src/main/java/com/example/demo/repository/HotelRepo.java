package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelRes.HomeStay;

@Repository
public interface HotelRepo extends JpaRepository<HomeStay, Integer>{

}
