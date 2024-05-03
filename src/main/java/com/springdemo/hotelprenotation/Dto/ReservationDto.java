package com.springdemo.hotelprenotation.Dto;

import java.util.Date;

public class ReservationDto {
    private Long id;
    private Date checkInDate;
    private Date checkOutDate;
    private GuestDto guest;
    private RoomDto room;
    private double totalCost;

    public ReservationDto() {
    }

    public ReservationDto(Date checkInDate, Date checkOutDate,
                          GuestDto guest, RoomDto room, double totalCost) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.room = room;
        this.totalCost = totalCost;
    }

    public ReservationDto(Long id, Date checkInDate, Date checkOutDate,
                          GuestDto guest, RoomDto room, double totalCost) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guest = guest;
        this.room = room;
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public GuestDto getGuest() {
        return guest;
    }

    public void setGuest(GuestDto guest) {
        this.guest = guest;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
