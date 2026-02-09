package org.LLD.RefundEngine.Util;

import org.LLD.RefundEngine.Model.Booking;
import org.LLD.RefundEngine.Model.PaymentTransaction;
import org.LLD.RefundEngine.Model.RefundRequest;
import org.LLD.RefundEngine.Model.RefundTransaction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RefundCalculator {

    Logger logger = Logger.getLogger(RefundCalculator.class.getName());

    public void calculate(Booking booking, RefundRequest refundRequest) {
        List<PaymentTransaction> paymentTransactions = booking.getPaymentTransactions();
        List<RefundTransaction> refundTransactions = new ArrayList<>();

        Instant now = Instant.now();
        long hours = ChronoUnit.HOURS.between(now, booking.getBookingTime());

        double refundPercent = hours > 24 ? 0.07 : 1;

        paymentTransactions.forEach(paymentTransaction -> {
            BigDecimal refundAmount = BigDecimal.valueOf(refundPercent).multiply(paymentTransaction.getAmount());
            refundTransactions.add(new RefundTransaction(paymentTransaction.getPaymentMethod(), refundAmount));
        });

        logger.info("Calculated Refund Collection Size: " + refundTransactions.size());

        refundRequest.getRefunds().addAll(refundTransactions);
    }

}
