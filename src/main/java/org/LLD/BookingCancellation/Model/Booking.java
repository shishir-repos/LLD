package org.LLD.BookingCancellation.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class Booking {
    private String bookingId;
    ProductType productType;
    Instant bookingTime;
    Instant startTime;
    double totalAmount;
    BookingStatus status;

    public Booking(String bookingId, ProductType productType, Instant bookingTime, Instant startTime, double totalAmount, BookingStatus status) {
        this.bookingId = bookingId;
        this.productType = productType;
        this.bookingTime = bookingTime;
        this.startTime = startTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }
}
