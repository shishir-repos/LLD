package org.LLD.BookingCancellation.Strategy;

import org.LLD.BookingCancellation.Model.Booking;
import org.LLD.BookingCancellation.Model.CancellationResult;
import org.LLD.BookingCancellation.Model.ProductType;

import java.time.Instant;

public interface CancellationStrategy {
    CancellationResult calculatePenalty(Booking booking);
}
