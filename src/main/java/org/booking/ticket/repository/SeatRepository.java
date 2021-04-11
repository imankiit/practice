package org.booking.ticket.repository;

import java.util.List;

import org.booking.ticket.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RepositoryRestResource
@Transactional
public interface SeatRepository extends JpaRepository<Seat, Long> {

	List<Seat> findBySeatIdIn(List<Long> seatId);
}
