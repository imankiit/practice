package org.booking.ticket.controller;

import org.booking.ticket.model.BookingRequest;
import org.booking.ticket.model.BookingResponse;
import org.booking.ticket.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@PostMapping("/book")
	public ResponseEntity<BookingResponse> book(@RequestBody BookingRequest bookingRequest) {
		return ResponseEntity.ok(bookingService.bookSeats(bookingRequest));
	}
}
