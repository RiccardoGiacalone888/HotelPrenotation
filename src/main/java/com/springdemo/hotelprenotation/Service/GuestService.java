package com.springdemo.hotelprenotation.Service;

import com.springdemo.hotelprenotation.Models.Guest;
import com.springdemo.hotelprenotation.Models.Reservation;
import com.springdemo.hotelprenotation.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests(){
        return guestRepository.findAll();
    }

    public Guest getGuestsById(Long id){
        return guestRepository.findById(id).orElse(null);
    }

    public List<Reservation> getReservationByGuest(Long guestId){
        return guestRepository.findReservationsByGuestId(guestId);
    }

    public Guest createGuest(Guest guest){
        return guestRepository.save(guest);
    }

    public Guest updateGuest (Long id, Guest guestDetails){
        Guest guest = guestRepository.findById(id).orElse(null);
        if ((guest!= null)){
            guest.setName(guestDetails.getName());
            guest.setEmail(guestDetails.getEmail());
            guest.setPhoneNumber(guestDetails.getPhoneNumber());
            return guestRepository.save(guest);
        }
        return null;
    }

    public void deleteGuest(Long id){
        guestRepository.deleteById(id);
    }
}
