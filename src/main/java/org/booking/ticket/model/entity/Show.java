package org.booking.ticket.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Show {
	private int showId;
	private Date startTime;
	private Date endTime;
	private Theatre playedAt;
	private Movie movie;
}
