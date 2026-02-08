package org.LLD.BookingCancellation.Service;

import org.LLD.BookingCancellation.Model.Booking;
import org.LLD.BookingCancellation.Repository.BookingRepository;

import java.time.Instant;
import java.util.List;

public class BookingService {

    public boolean isValidAndCancellable(BookingRepository bookingRepository, Booking booking) {
        List<Booking> bookings = bookingRepository.getBookings();
        Booking requestedBooking =  bookings.stream().filter(bookng -> bookng.getBookingId().equals(booking.getBookingId())).findAny().orElse(null);

        if (requestedBooking != null && Instant.now().isBefore(requestedBooking.getStartTime())) {
            return true;
        }

        return false;
    }
}
