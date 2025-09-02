package org.atyeti.car_rental_system.car.dao;

import org.atyeti.car_rental_system.car.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.atyeti.car_rental_system.car.entity.User;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface NotificationRepository  extends JpaRepository<Notification,Long> {
    List<Notification> findByUser(User user);


    @Query("SELECT n FROM Notification n ORDER BY n.createdAt DESC")
    List<Notification> findAllOrderedByDate();
}
