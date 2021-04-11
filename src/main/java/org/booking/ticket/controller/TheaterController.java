package org.booking.ticket.controller;

import java.util.List;

import org.booking.ticket.model.entity.City;
import org.booking.ticket.model.entity.Theatre;
import org.booking.ticket.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping(value = "/{cityId}")
	public ResponseEntity<List<Theatre>> findAllByCityId(@PathVariable("cityId") Long cityId) {
		City city = cityRepository.findById(cityId).orElseThrow(()-> new RuntimeException("City not found"));
		return ResponseEntity.ok(city.getTheater());
	}
}
