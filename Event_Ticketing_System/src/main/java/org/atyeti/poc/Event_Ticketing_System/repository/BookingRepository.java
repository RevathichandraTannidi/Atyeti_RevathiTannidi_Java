package org.atyeti.poc.Event_Ticketing_System.repository;
import org.atyeti.poc.Event_Ticketing_System.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

}
