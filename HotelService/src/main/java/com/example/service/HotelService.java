package com.example.service;

import com.example.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(String hotelId,Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getHotelById(String hotelId);
    boolean removeHotel(String hotelId);
}
