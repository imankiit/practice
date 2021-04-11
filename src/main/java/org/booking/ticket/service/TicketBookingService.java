package org.booking.ticket.service;

import java.util.List;

import org.booking.ticket.model.entity.City;
import org.booking.ticket.model.entity.Theatre;

public interface TicketBookingService {
	
	public List<City> getCities();
	
	public List<Theatre> getTheatres(String city);
	
	//public List<Movie> getMovies(String theatreName, String city);
	
	//public List<Show> getMovieShows(String theatreName, String city);
	
	public String bookSeats(String city, String theatreName, String showTime);
	
}
