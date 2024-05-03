package com.springdemo.hotelprenotation.Controller;

import com.springdemo.hotelprenotation.Models.Reservation;
import com.springdemo.hotelprenotation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getAllReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getAllReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dataRange")
    public List<Reservation> getReservationByDataRange
            (@RequestParam Date starterDate1,@RequestParam Date endDate1,
             @RequestParam Date starterDate2, @RequestParam Date endDate2){
        return reservationService.getReservationByDataRange(starterDate1,endDate1,starterDate2,endDate2);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation
            (@PathVariable Long id, @RequestBody Reservation updateReservation){
        Reservation updatedReservation = reservationService.updateReservation(id,updateReservation);
        if (updatedReservation!= null){
            return ResponseEntity.ok(updatedReservation);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation (@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
