package org.booking.ticket.controller;

import java.util.List;

import org.booking.ticket.model.entity.Movie;
import org.booking.ticket.model.entity.Theatre;
import org.booking.ticket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private TheaterRepository theaterRepository;
	
	@GetMapping(value = "/{movieId}")
	public ResponseEntity<List<Movie>> findAllByCityId(@PathVariable("movieId") Long movieId) {
		Theatre theatre = theaterRepository.findById(movieId).orElseThrow(()-> new RuntimeException("Movie not found"));
		return ResponseEntity.ok(theatre.getMovies());
	}
}
