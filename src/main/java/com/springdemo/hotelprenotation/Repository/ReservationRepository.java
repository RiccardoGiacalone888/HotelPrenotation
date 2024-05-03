package com.springdemo.hotelprenotation.Repository;

import com.springdemo.hotelprenotation.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByCheckInDateBetweenAndCheckOutDateBetween(Date startDate1, Date endDate1, Date startDate2, Date endDate2);
}
