package com.arnabbng.rating.service.services;

import com.arnabbng.rating.service.entities.Rating;

import java.util.List;

public interface RatingServices {
    //create
    Rating create(Rating rating);
    //get all
    List<Rating> getAll();
    //get all by user Id
    List <Rating> getRatingsByUserId(String userId);
    //get all by hotel
    List<Rating> getRatingsByHotelId(String hotelId);
}
