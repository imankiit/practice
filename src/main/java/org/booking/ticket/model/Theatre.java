package org.booking.ticket.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theatre {
	private String name;
	  private int totalSeats;
	  private List<Show> shows;
}
