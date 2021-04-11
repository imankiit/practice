package org.booking.ticket.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingResponse {

	private String response;
	
	private List<Long> booked;
}
