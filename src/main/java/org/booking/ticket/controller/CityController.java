package org.booking.ticket.controller;

import java.util.List;

import org.booking.ticket.model.entity.City;
import org.booking.ticket.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<City>> findAll() {
		return ResponseEntity.ok(cityRepository.findAll());
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<City> save(@RequestBody City city) {
		return ResponseEntity.ok(cityRepository.save(city));
	}
   
}