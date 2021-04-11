package org.booking.ticket.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

	private String title;
	private String description;
	private int durationInMins;
	private String language;
	private Date releaseDate;

	private List<Show> shows;
}
