package com.arnabbng.rating.service.controllers;

import com.arnabbng.rating.service.entities.Rating;
import com.arnabbng.rating.service.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    //create
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        Rating rating1 = ratingServices.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        List<Rating> rating1 = ratingServices.getAll();
        return ResponseEntity.ok(rating1);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String id){
        List<Rating> ratings = ratingServices.getRatingsByUserId(id);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String id){
        List<Rating> ratings = ratingServices.getRatingsByHotelId(id);
        return ResponseEntity.ok(ratings);
    }
}
