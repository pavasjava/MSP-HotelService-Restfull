package com.example.service;

import com.example.entity.Rating;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.RatingRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepository.save(rating);
    }

//    @Override
//    public Rating updateRating(String ratingId, Rating rating) {
//        Rating rating1 = ratingRepository.findById(ratingId).orElseThrow(()->
//                new ResourceNotFoundException("User with given id is not found on server !! "+ratingId));
//        return ratingRepository.save(rating1);
//    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }
    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
