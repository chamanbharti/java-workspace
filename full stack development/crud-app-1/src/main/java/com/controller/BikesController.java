package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.model.Bike;
import com.model.Product;
import com.repository.BikeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping
	public List<Bike> list() {
		List<Bike> bikes = bikeRepository.findAll();
		return bikes;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		bikeRepository.save(bike);
	}

	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id) {
		return bikeRepository.getOne(id);
	}
	
	@PutMapping
	public Bike updateBike(@RequestBody Bike bike) {
		return bikeRepository.save(bike);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteBike(@PathVariable(value = "id") Long id) {
		bikeRepository.deleteById(id);
		return true;
	}

}
