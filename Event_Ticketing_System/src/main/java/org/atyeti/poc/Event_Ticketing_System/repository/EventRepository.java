package org.atyeti.poc.Event_Ticketing_System.repository;
import org.atyeti.poc.Event_Ticketing_System.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event, String> {

}