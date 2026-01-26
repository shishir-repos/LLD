package org.LLD.BookMyShow;

import org.LLD.BookMyShow.Enum.SeatType;
import org.LLD.BookMyShow.Model.*;
import org.LLD.BookMyShow.Service.BookingManager;
import org.LLD.BookMyShow.Strategy.StandardPricing;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Movie batman = new Movie("B1", "Dark Knight", 2);
        Show show = new Show("S1", batman, System.currentTimeMillis());

        show.getSeats().put("A1", new Seat("A1", SeatType.SILVER, 300));
        show.getSeats().put("A2", new Seat("A2", SeatType.SILVER, 300));
        show.getSeats().put("S1", new Seat("S1", SeatType.PLATINUM, 1200));

        List<String> requestedSeats = List.of("A1", "A2", "S1");

        BookingManager bookingManager = BookingManager.getInstance(new StandardPricing());


        Thread thread = new Thread(() -> {
            Booking booking = bookingManager.createBooking(new User(), show, requestedSeats);
            if (booking != null) {
                System.out.println("Booking Confirmed for Seats: "+requestedSeats);
                System.out.println("Total Price: "+booking.getTotalAmount());
            }
        });
        Thread thread1 = new Thread(() -> {
            Booking booking = bookingManager.createBooking(new User(), show, requestedSeats);
            if (booking != null) {
                System.out.println("Booking Confirmed for Seats: "+requestedSeats);
                System.out.println("Total Price: "+booking.getTotalAmount());
            }
        });
        thread.start();
        thread1.start();
        thread.join();
    }
}
