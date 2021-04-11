package org.booking.ticket.service;

import java.util.List;
import java.util.Map;
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

@Service
public class BookingServiceImpl implements BookingService  {
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	private enum BOOKING_STATUS {Y, N};

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
	public BookingResponse bookSeats(BookingRequest bookingRequest) {
		BookingResponse bookingResponse = new BookingResponse();
		
		// validation
		theaterRepository.findById(bookingRequest.getTheaterId()).orElseThrow(()-> new RuntimeException("Theater Not Found"));
		movieRepository.findById(bookingRequest.getMovieId()).orElseThrow(()-> new RuntimeException("Movie Not Found"));
		
		List<Seat> seats = seatRepository.findBySeatIdIn(bookingRequest.getSeats().stream().map(Seat::getSeatId).collect(Collectors.toList()));		
		if(seats.size() == bookingRequest.getSeats().size()) throw new RuntimeException("Bad Request");
	
		Map<Long, Seat> seatIdMapFromDB = seats.stream().collect(Collectors.toMap(Seat::getSeatId, seat -> seat));
		
		boolean isBookingEligible = true;
		Seat seatDB = null;
		for(Seat seat: bookingRequest.getSeats()) {
			seatDB = seatIdMapFromDB.get(seat.getSeatId());
			if(seat.getVersion() !=  seatDB.getVersion() || seatDB.getBooked().equalsIgnoreCase(BOOKING_STATUS.Y.name())) {
				isBookingEligible = false;
				break;
			}
		}
		
		// booking
		if(isBookingEligible) {
			seats.forEach(seat->{
				seat.setBookedBy(bookingRequest.getUserId());
				seat.setBooked(BOOKING_STATUS.Y.name());
			});
			List<Long> seatsBooked = seatRepository.saveAll(seats).stream().map(Seat::getSeatId).collect(Collectors.toList());
			bookingResponse.setBooked(seatsBooked);
			bookingResponse.setResponse("seats booked");
		} else
			bookingResponse.setResponse("Seats already booked; Please refersh and try again");
		
		return bookingResponse;
	}

}
