package org.booking.ticket.model.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
            name="THEATER_MOVIE",
            joinColumns = @JoinColumn( name="THEATER_ID"),
            inverseJoinColumns = @JoinColumn( name="MOVIE_ID")
    )
	@JsonIgnore
	private List<Movie> movies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
	
}
