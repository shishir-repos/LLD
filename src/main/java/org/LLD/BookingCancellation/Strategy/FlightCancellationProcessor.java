package org.LLD.BookingCancellation.Strategy;

import org.LLD.BookingCancellation.Model.*;
import org.LLD.BookingCancellation.Repository.CancellationPolicyRepo;
import org.LLD.BookingCancellation.Service.CancellationPolicyUpdateService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FlightCancellationProcessor implements CancellationStrategy {

    @Override
    public CancellationResult calculatePenalty(Booking booking) {
        CancellationPolicyRepo cancellationPolicyRepo = CancellationPolicyRepo.getInstance();
        List<CancellationPolicyRule> cancellationPolicyRules = cancellationPolicyRepo.getCancellationPolicyRules();

        Instant now = Instant.now();
        long hours = ChronoUnit.HOURS.between(now, booking.getBookingTime());

        CancellationPolicyRule qualifiedRule =
                cancellationPolicyRules.stream().filter(rule -> {
                    int[] range = rule.getHoursBeforeBooking();
                    return hours >= range[0] && hours <= range[1];
                }).findAny().orElse(null);

        double penalty = qualifiedRule != null ? qualifiedRule.getPenaltyPercentage() * booking.getTotalAmount() : 0.0;

        return new CancellationResult(booking.getBookingId(), penalty, booking.getTotalAmount() - penalty, CancellationStatus.REFUND_PENDING);
    }
}
