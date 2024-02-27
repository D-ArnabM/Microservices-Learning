package com.arnabbng.user.service.services.impl;

import com.arnabbng.user.service.entities.Hotel;
import com.arnabbng.user.service.entities.Rating;
import com.arnabbng.user.service.entities.User;
import com.arnabbng.user.service.exceptions.ResourceNotFoundException;
import com.arnabbng.user.service.external.services.HotelService;
import com.arnabbng.user.service.external.services.RatingService;
import com.arnabbng.user.service.repositories.UserRepository;
import com.arnabbng.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User saveUser(User user) {
        //Generating unique user Id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id is not found on server !!! : " + userId));

        List<Rating> ratings = ratingService.getAllRatingsByUserId(userId).getBody();
        for (Rating r:
                ratings) {
            Hotel hotel = hotelService.getHotelByHotelId(r.getHotelId());
            r.setHotel(hotel);
        }

        user.setRatings(ratings);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
