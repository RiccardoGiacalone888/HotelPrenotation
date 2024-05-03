package com.springdemo.hotelprenotation.Controller;

import com.springdemo.hotelprenotation.Models.Guest;
import com.springdemo.hotelprenotation.Models.Reservation;
import com.springdemo.hotelprenotation.Service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }


        @GetMapping("/{id}")
        public ResponseEntity<Guest> getGuestByID(@PathVariable Long id) {
            Guest guest = guestService.getGuestsById(id);
            if (guest != null) {
                return ResponseEntity.ok(guest);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/{id}/reservations")
        public ResponseEntity<List<Reservation>> getReservationsByGuestId(@PathVariable Long id) {
            List<Reservation> reservations = guestService.getReservationByGuest(id);
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
            Guest createdGuest = guestService.createGuest(guest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGuest);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guestDetails) {
            Guest updatedGuest = guestService.updateGuest(id, guestDetails);
            if (updatedGuest != null) {
                return ResponseEntity.ok(updatedGuest);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
            guestService.deleteGuest(id);
            return ResponseEntity.noContent().build();

        }
    }


