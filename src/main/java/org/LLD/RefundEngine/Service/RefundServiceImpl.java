package org.LLD.RefundEngine.Service;

import lombok.Getter;
import lombok.extern.java.Log;
import org.LLD.BookingCancellation.Repository.BookingRepository;
import org.LLD.RefundEngine.Model.Booking;
import org.LLD.RefundEngine.Model.RefundRequest;
import org.LLD.RefundEngine.Model.RefundStatus;
import org.LLD.RefundEngine.Repository.RefundRepository;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Logger;

@Getter
public class RefundServiceImpl implements RefundService {

    private BookingRepository bookingRepository;
    private SupplierService supplierService;
    private RefundRepository refundRepository;
    private BlockingDeque<RefundRequest> refundRequestsProcessingQueue = new LinkedBlockingDeque<>();
    Logger logger = Logger.getLogger(RefundService.class.getName());

    public RefundServiceImpl(BookingRepository bookingRepository, SupplierService supplierService, RefundRepository refundRepository) {
        this.bookingRepository = bookingRepository;
        this.supplierService = supplierService;
        this.refundRepository = refundRepository;
    }

    @Override
    public RefundRequest refund(String refundId, Booking booking) {

        // Idempotency Check
        if (refundRepository.getRefunds().get(refundId) != null) {
            logger.info("Refund Already Processed");
            System.out.println("!!!");
            return new RefundRequest(refundId, new ArrayList<>(), RefundStatus.CANCELLED);
        }

        // Safe Check to Validate bookingId
        if (booking.getBookingId() == null) {
            return new RefundRequest(null, new ArrayList<>(), RefundStatus.CANCELLED);
        }

        RefundRequest refundRequest = new RefundRequest(booking.getBookingId(), new ArrayList<>(), RefundStatus.REQUESTED);

        // Adding Supplier Specific Check to validate extra
        if (!supplierService.supplierValidityCheckAPI(refundRequest)) {
            refundRequest.setRefundStatus(RefundStatus.CANCELLED);
            return refundRequest;
        }

        // Persist Refund Request in Ledger
        refundRepository.getRefunds().put(refundId, refundRequest);

        refundRequestsProcessingQueue.add(refundRequest);

        return refundRequest;
    }
}
