package org.LLD.BookingCancellation.Model;

import lombok.Getter;

@Getter
public class CancellationPolicyRule {
    private int[] hoursBeforeBooking;
    private double penaltyPercentage;

    public CancellationPolicyRule(int[] hoursBeforeBooking, double penaltyPercentage) {
        this.hoursBeforeBooking = hoursBeforeBooking;
        this.penaltyPercentage = penaltyPercentage;
    }
}
