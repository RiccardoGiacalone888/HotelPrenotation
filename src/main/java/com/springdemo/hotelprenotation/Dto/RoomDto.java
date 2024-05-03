package com.springdemo.hotelprenotation.Dto;

public class RoomDto {
    private String roomNumber;
    private String type;
    private double ratePerNight;

    public RoomDto() {
    }

    public RoomDto(String type, double ratePerNight) {
        this.type = type;
        this.ratePerNight = ratePerNight;
    }

    public RoomDto(String roomNumber, String type, double ratePerNight) {
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
}
