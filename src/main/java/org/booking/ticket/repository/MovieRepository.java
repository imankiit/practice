package org.booking.ticket.repository;

import org.booking.ticket.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RepositoryRestResource
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
