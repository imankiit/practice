package org.booking.ticket.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
public class Movie {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="movieSequence")
	@SequenceGenerator(name="movieSequence",sequenceName="movie_seq", allocationSize=1)
	@Column(name="MOVIE_ID")
	private Long movieId;
	
	@Column(name="MOVIE_NAME")
	private String movieName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
            name="MOVIE_SEAT",
            joinColumns = @JoinColumn( name="MOVIE_ID"),
            inverseJoinColumns = @JoinColumn( name="SEAT_ID")
    )
	private List<Seat> seats;
}
