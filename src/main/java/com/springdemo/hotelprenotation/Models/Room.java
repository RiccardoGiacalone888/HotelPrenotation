package com.springdemo.hotelprenotation.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "rate_per_night")
    private double ratePerNight;

    public Room() {
    }

    public Room(String type, double ratePerNight) {
        this.type = type;
        this.ratePerNight = ratePerNight;
    }

    public Room(String roomNumber, String type, double ratePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.ratePerNight = ratePerNight;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRatePerNight() {
        return ratePerNight;
    }

    public void setRatePerNight(double ratePerNight) {
        this.ratePerNight = ratePerNight;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", ratePerNight=" + ratePerNight +
                '}';
    }
}
