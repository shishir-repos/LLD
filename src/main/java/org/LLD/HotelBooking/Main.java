package org.LLD.HotelBooking;

import org.LLD.HotelBooking.Enum.RoomType;
import org.LLD.HotelBooking.Model.Booking;
import org.LLD.HotelBooking.Model.Room;
import org.LLD.HotelBooking.Reception.BookingManager;
import org.LLD.HotelBooking.Strategy.BasicPricingStrategy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BookingManager manager = BookingManager.getInstance(new BasicPricingStrategy());
        manager.addRooms(new Room("D1", RoomType.DELUXE, 500));
        manager.addRooms(new Room("S1", RoomType.STANDARD, 450));

        Booking booking = manager.
                bookRoom("B1",
                        new Room("D1", RoomType.DELUXE, 500),
                        LocalDate.of(2026, 1, 29),
                        LocalDate.of(2026, 1, 30));

        System.out.println("Room booked as: " + booking);

        manager.
                bookRoom("B1",
                        new Room("D1", RoomType.DELUXE, 500),
                        LocalDate.of(2026, 1, 29),
                        LocalDate.of(2026, 1, 30));

    }
}
