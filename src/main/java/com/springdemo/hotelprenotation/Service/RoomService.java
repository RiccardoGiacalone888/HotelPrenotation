package com.springdemo.hotelprenotation.Service;

import com.springdemo.hotelprenotation.Models.Room;
import com.springdemo.hotelprenotation.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(String roomNumber) {
        return roomRepository.findById(roomNumber).orElse(null);
    }

    public List<Room> getAvailableRooms(Date checkInDate, Date checkOutDate) {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(String roomNumber, Room roomDetails) {
        Room room = roomRepository.findById(roomNumber).orElse(null);
        if (room != null) {
            room.setType(roomDetails.getType());
            room.setRatePerNight(roomDetails.getRatePerNight());
            return roomRepository.save(room);
        }
        return null;
    }

    public void deleteRoom(String roomNumber) {
        roomRepository.deleteById(roomNumber);
    }
}
