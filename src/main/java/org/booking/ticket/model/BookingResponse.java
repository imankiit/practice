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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public List<Long> getBooked() {
		return booked;
	}

	public void setBooked(List<Long> booked) {
		this.booked = booked;
	}
	
	
}
