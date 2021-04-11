package org.booking.ticket.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MOVIE")
@Getter
@Setter
@NoArgsConstructor
public class Seat {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seatSequence")
	@SequenceGenerator(name="seatSequence",sequenceName="seat_seq", allocationSize=1)
	@Column(name="SEAT_ID")
	private Long seatId;
	
	@Column(name = "BOOKED")
	private String booked;
	
	@Column(name = "BOOKED_BY")
	private String bookedBy;
	
	@Column(name = "version")
	private int version;
	
	
	@PreUpdate
	public void setVersion() {
		this.version+=1;
	}
	
}
