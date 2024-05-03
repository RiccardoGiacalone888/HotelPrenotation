package com.springdemo.hotelprenotation.Controller;

import com.springdemo.hotelprenotation.Models.Hotel;
import com.springdemo.hotelprenotation.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotel(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> hetAllHotelById(@PathVariable Long id){
        Hotel hotel = hotelService.getAllHotelById(id);
        if (hotel!=null){
            return ResponseEntity.ok(hotel);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel createdHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel updateHotel){
        Hotel updatedHotel = hotelService.updateHotel(id,updateHotel);
        if (updatedHotel!=null){
            return ResponseEntity.ok(updatedHotel);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
