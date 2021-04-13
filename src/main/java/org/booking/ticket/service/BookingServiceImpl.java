package org.booking.ticket.service;

import java.util.stream.Collectors;

import org.booking.ticket.model.BookingRequest;
import org.booking.ticket.model.BookingResponse;
import org.booking.ticket.model.entity.Seat;
import org.booking.ticket.repository.MovieRepository;
import org.booking.ticket.repository.SeatRepository;
import org.booking.ticket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookingServiceImpl implements BookingService  {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	private enum BOOKING_STATUS {Y, N};

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public BookingResponse bookSeats(BookingRequest bookingRequest) {
		BookingResponse bookingResponse = new BookingResponse();
		
		theaterRepository.findById(bookingRequest.getTheaterId()).orElseThrow(()-> new RuntimeException("Theater Not Found"));
		movieRepository.findById(bookingRequest.getMovieId()).orElseThrow(()-> new RuntimeException("Movie Not Found"));
		
		try {
			for(Seat s: bookingRequest.getSeats()) {
				s = seatRepository
						.findBySeatIdAndBookedAndVersion(s.getSeatId(), BOOKING_STATUS.N.name(), s.getVersion())
						.orElseThrow(()-> new RuntimeException("Seat already booked"));
				s.setBookedBy(bookingRequest.getUserId());
				s.setBooked(BOOKING_STATUS.Y.name());
			}
			
			seatRepository.saveAll(bookingRequest.getSeats());
			bookingResponse.setResponse("seats booked");
			bookingResponse.setBooked(bookingRequest.getSeats().stream().map(Seat::getSeatId).collect(Collectors.toList()));
			
		} catch(Exception e) {
			log.error("Unable to book seats", e);
			bookingResponse.setResponse(e.getMessage());
		}
		
		return bookingResponse;
	}

}
