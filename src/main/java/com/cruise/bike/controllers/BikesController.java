package com.cruise.bike.controllers;

import com.cruise.bike.Repository.BikeRepository;
import com.cruise.bike.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bikes")
public class BikesController {
    @Autowired
    private BikeRepository bikeRepository;
    private String id;

    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
        // return bikes;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike) {
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Optional<Bike> get(@PathVariable("id") long id) {
        return bikeRepository.findById(id);
    }
}


