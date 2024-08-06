package com.user.service;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.external.service.HotelService;
import com.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    private Logger log = LoggerFactory.getLogger(UserService.class);
    //Create User
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }
    //get User by Id
    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with given id is not found on server !! "+userId)
        );
        //Fetching rating of the above user form rating service
        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        log.info("{}",forObject);
        List<Rating> ratings = Arrays.stream(forObject).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
            //Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //log.info("response status code: {}",forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
    //get All User
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    //update User
    @Override
    public User udateUser(String userId, User user) {
        User userById = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with given id is not found on server !! "+userId)
        );
        return userRepository.save(userById);
    }
    //Remove user
//    @Override
//    public boolean removeUser(String userId) {
//        userRepository.deleteById(userId);
//        return false;
//    }
}
