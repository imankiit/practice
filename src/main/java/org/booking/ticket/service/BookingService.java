package org.booking.ticket.service;

import org.booking.ticket.model.BookingRequest;
import org.booking.ticket.model.BookingResponse;

public interface BookingService {
	 
	public BookingResponse bookSeats(BookingRequest bookingRequest);
	
}
