package org.booking.ticket.model.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CITY")
public class City implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="citySequence")
	@SequenceGenerator(name="citySequence",sequenceName="city_seq", allocationSize=1)
	@Column(name = "CITY_ID")
	private Long cityId;
	
	@NotNull
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@OneToMany
	@JoinTable(
            name="CITY_THEATRE_TABLE",
            joinColumns = @JoinColumn( name="CITY_ID"),
            inverseJoinColumns = @JoinColumn( name="THEATER_ID")
    )
	private List<Theatre> theater;

}
