package org.LLD.BookingCancellation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CancellationResult {
    String bookingId;
    double penalty;
    double refundAmount;
    CancellationStatus status;
}
