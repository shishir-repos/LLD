package org.LLD.BookingCancellation.Repository;

import lombok.Getter;
import org.LLD.BookingCancellation.Model.Booking;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookingRepository {
    List<Booking> bookings;

    public BookingRepository() {
        bookings = new ArrayList<>();
    }

}
