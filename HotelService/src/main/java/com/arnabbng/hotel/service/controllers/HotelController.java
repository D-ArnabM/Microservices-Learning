package com.arnabbng.hotel.service.controllers;

import com.arnabbng.hotel.service.entities.Hotel;
import com.arnabbng.hotel.service.services.HotelService;
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

    //create
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok(hotels);
    }
    //get by Id
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id){
        Hotel hotel1 = hotelService.getById(id);
        return ResponseEntity.ok(hotel1);
    }
    //update
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.ok("Hotel Updated Successfully with the Id : "+hotel.getId());
    }
}
