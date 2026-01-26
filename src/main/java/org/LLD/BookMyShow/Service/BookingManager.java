package org.LLD.BookMyShow.Service;

import org.LLD.BookMyShow.Model.Booking;
import org.LLD.BookMyShow.Model.Seat;
import org.LLD.BookMyShow.Model.Show;
import org.LLD.BookMyShow.Model.User;
import org.LLD.BookMyShow.Strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private static BookingManager instance;
    private final PricingStrategy pricingStrategy;

    private BookingManager(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public static synchronized BookingManager getInstance(PricingStrategy pricingStrategy) {
        if (instance == null) {
            instance = new BookingManager(pricingStrategy);
        }
        return instance;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public synchronized Booking createBooking(User user, Show show, List<String> requestedSeats) {
        List<Seat> selectedSeats = new ArrayList<>();

        for (String seatId: requestedSeats) {
            Seat seat = show.getSeats().get(seatId);
            if (seat == null || seat.isBooked()) {
                throw new RuntimeException("Requested Seats Already Booked!");
            }
            selectedSeats.add(seat);
        }

        selectedSeats.forEach(seat -> seat.setBooked(true));

        double price = pricingStrategy.calculate(selectedSeats);
        return new Booking(user, show, selectedSeats, price);
    }
}
