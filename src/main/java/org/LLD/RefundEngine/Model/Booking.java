package org.LLD.RefundEngine.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class Booking {
    private String bookingId;
    private Instant bookingTime;
    List<PaymentTransaction> paymentTransactions; // contains breakup of payment modes
}
