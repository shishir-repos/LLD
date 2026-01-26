package org.LLD.BookMyShow.Model;

import org.LLD.BookMyShow.Enum.BookingStatus;

import java.util.List;
import java.util.UUID;

public class Booking {
    String id;
    User user;
    Show show;
    List<Seat> seats;
    double totalAmount;
    BookingStatus status = BookingStatus.PENDING;

    public Booking(User u, Show s, List<Seat> seats, double amount) {
        this.id = "BKM-" + UUID.randomUUID().toString();
        this.user = u; this.show = s; this.seats = seats; this.totalAmount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
