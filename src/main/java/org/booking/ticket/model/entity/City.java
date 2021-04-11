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
@Table(name = "CITY")
@Getter
@Setter
@NoArgsConstructor
public class City implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="citySequence")
	@SequenceGenerator(name="citySequence",sequenceName="city_seq", allocationSize=1)
	@Column(name = "CITY_ID")
	private Long cityId;
	
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
            name="CITY_THEATRE",
            joinColumns = @JoinColumn( name="CITY_ID"),
            inverseJoinColumns = @JoinColumn( name="THEATER_ID")
    )
	@JsonIgnore
	private List<Theatre> theater;

}
