package com.springdemo.hotelprenotation.Service;

import com.springdemo.hotelprenotation.Models.Reservation;
import com.springdemo.hotelprenotation.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservation (){
        return reservationRepository.findAll();
    }

    public Reservation getAllReservationById(Long reservationId){
        return reservationRepository.findById(reservationId).orElse(null);
    }

    public List<Reservation> getReservationByDataRange(Date startDate1, Date endDate1,
                                                       Date startDate2, Date endDate2)
    {
        return reservationRepository.findByCheckInDateBetweenAndCheckOutDateBetween
            (startDate1, endDate1, startDate2, endDate2);

    }

    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservation.setCheckInDate(reservationDetails.getCheckInDate());
            reservation.setCheckOutDate(reservationDetails.getCheckOutDate());
            reservation.setGuest(reservationDetails.getGuest());
            reservation.setRoom(reservationDetails.getRoom());
            double totalCost = reservationDetails.getTotalCost();
            reservation.setTotalCost(totalCost);
            return reservationRepository.save(reservation);
        }
        return null;
    }



    public void deleteReservation(Long reservationId){
        reservationRepository.deleteById(reservationId);
    }
}
