package com.springdemo.hotelprenotation.Service;

import com.springdemo.hotelprenotation.Models.Hotel;
import com.springdemo.hotelprenotation.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel getAllHotelById(Long hotelId){
        return hotelRepository.findById(hotelId).orElse(null);
    }

    public Hotel createHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel (Long hotelId, Hotel hotelDetails){
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        if (hotel!=null){
            hotel.setName(hotelDetails.getName());
            hotel.setEmail(hotelDetails.getEmail());
            hotel.setPhoneNumber(hotelDetails.getPhoneNumber());
            hotel.setCountry(hotelDetails.getCountry());
            hotel.setCity(hotelDetails.getCity());
            hotel.setAddress(hotelDetails.getAddress());
            return hotelRepository.save(hotel);
        }
        return null;
    }

    public void deleteHotel(Long hotelId){
        hotelRepository.deleteById(hotelId);
    }
}
