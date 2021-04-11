package org.booking.ticket.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "THEATER")
public class Theatre {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="theaterSequence")
	@SequenceGenerator(name="theaterSequence",sequenceName="theater_seq", allocationSize=1)
	@Column(name = "THEATER_ID")
	private Long theaterId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SEATS")
	private int totalSeats;
}
