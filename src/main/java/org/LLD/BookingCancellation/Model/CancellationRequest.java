package org.LLD.BookingCancellation.Model;

public class CancellationRequest {
    private String bookingId;
    private String reason;
    private String requestedBy;

    public CancellationRequest(String bookingId, String reason, String requestedBy) {
        this.bookingId = bookingId;
        this.reason = reason;
        this.requestedBy = requestedBy;
    }
}
