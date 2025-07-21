package org.atyeti.trafficManagement.repository;

import org.atyeti.trafficManagement.model.TrafficEvent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrafficEventRepository extends JpaRepository<TrafficEvent, Long> {

}
