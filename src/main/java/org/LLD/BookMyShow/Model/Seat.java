package org.LLD.BookMyShow.Model;

import org.LLD.BookMyShow.Enum.SeatType;

public class Seat {
    String id;
    SeatType seatType;
    double price;
    boolean isBooked = false;

    public Seat(String id, SeatType seatType, double price) {
        this.id = id;
        this.seatType = seatType;
        this.price = price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
