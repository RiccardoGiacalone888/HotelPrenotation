package com.springdemo.hotelprenotation.Repository;

import com.springdemo.hotelprenotation.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
