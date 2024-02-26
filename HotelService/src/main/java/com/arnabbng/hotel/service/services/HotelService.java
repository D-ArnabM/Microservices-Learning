package com.arnabbng.hotel.service.services;

import com.arnabbng.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {
    //create
    Hotel create(Hotel hotel);
    //get all
    List<Hotel> getAll();
    //get by id
    Hotel getById(String id);
    //update
    Hotel update(Hotel hotel);
    //TODO:delete
}
