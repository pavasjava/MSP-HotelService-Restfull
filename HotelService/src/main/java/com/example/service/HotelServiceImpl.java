package com.example.service;

import com.example.entity.Hotel;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {
        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(()->
                new ResourceNotFoundException("Hotel with given id Not Found !!"));
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->
                new ResourceNotFoundException("Hotel with given id Not Found !!"));
    }

    @Override
    public boolean removeHotel(String hotelId) {
        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(()->
                new ResourceNotFoundException("Hotel with given id Not Found !!"));
        hotelRepository.delete(hotel1);
        return false;
    }
}
