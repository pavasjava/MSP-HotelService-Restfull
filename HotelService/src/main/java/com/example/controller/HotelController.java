package com.example.controller;

import com.example.entity.Hotel;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }
    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId,@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.createHotel(hotel));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
    }
    @DeleteMapping("/")
    public String deleteHotel(@PathVariable String hotelId){
        boolean delete = hotelService.removeHotel(hotelId);
        if (delete){
            return "Student "+hotelId+" delete successfully";
        }
        else {
            return "Student "+hotelId+" delete Unsuccessfully";
        }
    }
}
