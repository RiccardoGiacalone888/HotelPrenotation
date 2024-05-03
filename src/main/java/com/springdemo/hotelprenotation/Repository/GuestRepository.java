package com.springdemo.hotelprenotation.Repository;

import com.springdemo.hotelprenotation.Models.Guest;
import com.springdemo.hotelprenotation.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Reservation> findReservationsByGuestId(Long guestId);

}
