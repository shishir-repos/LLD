package org.LLD.RefundEngine.Service;

import org.LLD.RefundEngine.Model.Booking;
import org.LLD.RefundEngine.Model.RefundRequest;

public interface RefundService {
    RefundRequest refund(String refundId, Booking booking);
}
