package org.booking.ticket.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "THEATER")
@Getter
@Setter
@NoArgsConstructor
public class Theatre implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="theaterSequence")
	@SequenceGenerator(name="theaterSequence",sequenceName="theater_seq", allocationSize=1)
	@Column(name = "THEATER_ID")
	private Long theaterId;
	
	@Column(name = "THEATER_NAME")
	private String name;
	
	@Column(name = "SEATS")
	private int totalSeats;
	
}
