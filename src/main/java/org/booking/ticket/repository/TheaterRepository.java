package org.booking.ticket.repository;

import org.booking.ticket.model.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface TheaterRepository extends JpaRepository<Theatre, Long> {

}
