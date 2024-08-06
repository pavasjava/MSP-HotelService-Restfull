package com.example.repository;

import com.example.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {
    //Custom find method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
