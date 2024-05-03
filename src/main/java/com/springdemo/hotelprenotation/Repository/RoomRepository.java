package com.springdemo.hotelprenotation.Repository;

import com.springdemo.hotelprenotation.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {


}
