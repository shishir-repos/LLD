package org.LLD.HotelBooking.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Booking {
    private String bookingId;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private double amount;
}
