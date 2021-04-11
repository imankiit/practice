package org.booking.ticket.service;

import java.util.List;

import org.booking.ticket.model.Movie;
import org.booking.ticket.model.Show;
import org.booking.ticket.model.Theatre;
import org.booking.ticket.model.entity.City;

public class TicketBookingServiceImpl implements TicketBookingService  {
	

	@Override
	public List<City> getCities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Theatre> getTheatres(String city) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Movie> getMovies(String theatreName, String city) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Show> getMovieShows(String theatreName, String city) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String bookSeats(String city, String theatreName, String showTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
