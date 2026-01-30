package org.LLD.HotelBooking.Reception;

import lombok.Getter;
import org.LLD.HotelBooking.Enum.RoomStatus;
import org.LLD.HotelBooking.Enum.RoomType;
import org.LLD.HotelBooking.Model.Booking;
import org.LLD.HotelBooking.Model.Room;
import org.LLD.HotelBooking.Strategy.PricingStrategy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BookingManager {

    private static BookingManager instance;
    private PricingStrategy pricingStrategy;
    private List<Room> rooms;
    private List<Booking> bookings = new ArrayList<>();

    private BookingManager(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public static BookingManager getInstance(PricingStrategy pricingStrategy) {
        if (instance == null) {
            instance = new BookingManager(pricingStrategy);
        }
        return instance;
    }

    public synchronized Booking bookRoom(String id, Room room, LocalDate startDate, LocalDate endDate) {

        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomStatus() != (room.getRoomStatus()) && startDate.isBefore(booking.getEndDate()) && endDate.isAfter(booking.getStartDate())) {
                throw new RuntimeException("No Rooms Available!");
            }
        }

        long nights = ChronoUnit.DAYS.between(startDate, endDate);
        double amount = pricingStrategy.calculatePrice(room, nights);
        Booking booking = new Booking(id, room, startDate, endDate, amount);
        booking.getRoom().setRoomStatus(RoomStatus.BOOKED);
        bookings.add(booking);
        return booking;
    }

    public void addRooms(Room room) {
        if (rooms == null || rooms.isEmpty()) {
            rooms = new ArrayList<>();
        }
        rooms.add(room);
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
}
