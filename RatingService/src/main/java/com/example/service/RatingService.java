package com.example.service;

import com.example.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
//    Rating updateRating(String ratingId,Rating rating);
    List<Rating> getAllRating();
    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByHotelId(String hotelId);
}
