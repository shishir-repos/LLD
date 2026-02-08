package org.LLD.BookingCancellation.Service;

import org.LLD.BookingCancellation.Factory.CancellationProcessorFactory;
import org.LLD.BookingCancellation.Model.*;
import org.LLD.BookingCancellation.Repository.BookingRepository;
import org.LLD.BookingCancellation.Repository.CancellationPolicyRepo;
import org.LLD.BookingCancellation.Strategy.CancellationStrategy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class CancellationService {

    private BookingRepository bookingRepository;
    private CancellationPolicyRepo cancellationPolicyRepo;
    private RefundService refundService;
    private BookingService bookingService;
    Logger logger = Logger.getLogger(CancellationService.class.getName());

    private final ConcurrentHashMap<String, Object> bookingLocks = new ConcurrentHashMap<>();

    public CancellationService(BookingService bookingService, BookingRepository bookingRepository, CancellationPolicyRepo cancellationPolicyRepo, RefundService refundService) {
        this.bookingRepository = bookingRepository;
        this.cancellationPolicyRepo = cancellationPolicyRepo;
        this.refundService = refundService;
        this.bookingService = bookingService;
    }

    public synchronized CancellationResult cancel(Booking booking) throws InterruptedException {

        Object lock = this.getLock(booking.getBookingId());

        synchronized (lock) {
            logger.info("Requesting Cancellation for: " + booking.getBookingId() + " " + booking.getProductType());

            CancellationPolicyUpdateService cancellationPolicyUpdateService = CancellationPolicyUpdateService.getInstance(cancellationPolicyRepo);

            // Adding booking to repo
            // bookingRepository.getBookings().add(booking);

            Thread.sleep(1000);

            // Check if Valid Booking and Cancellable
            logger.info("Checking if Cancellation is valid: " + booking.getBookingId() + " " + booking.getProductType());
            if (!bookingService.isValidAndCancellable(bookingRepository, booking)) {
                return new CancellationResult(booking.getBookingId(), 0, 0, CancellationStatus.SETTLED);
            }

            Thread.sleep(1000);

            // Idempotency Logic
            logger.info("Checking if Cancellation is Unique: " + booking.getBookingId() + " " + booking.getProductType());
            if (booking.getStatus().equals(BookingStatus.CANCELLED)) {
                logger.info("Booking already cancelled!!!");
                return new CancellationResult(booking.getBookingId(), 0, 0, CancellationStatus.SETTLED);
            }

            Thread.sleep(1000);

            // Deciding Cancellation Strategy on Runtime
            logger.info("Deciding Cancellation Strategy on Runtime");
            CancellationStrategy cancellationStrategy = CancellationProcessorFactory.getCancellationStrategy(booking.getProductType());

            Thread.sleep(1000);

            // Populating Policy Rules for Refund Calculations
            logger.info("Hot Loading Cancellation Policies on Runtime");
            cancellationPolicyUpdateService.updateCancellationPolicies(cancellationPolicyRepo);

            Thread.sleep(1000);

            // Requesting Cancellation and Penalty Calculation
            logger.info("Calculating Penalty based on the Cancellation Policies");
            CancellationResult result = cancellationStrategy.calculatePenalty(booking);

            Thread.sleep(1000);

            refundService.refund();
            // Request payback flow to pay the refund amount
            // payback(result)
            // async task to log event to refund initiated (sends mail, adds refund request to queue)

            booking.setStatus(BookingStatus.CANCELLED);
            result.setStatus(CancellationStatus.SETTLED);

            logger.info("Cancellation Successful!");
            logger.info("Result: " + result);
            System.out.println("**************************************");
            return result;
        }
    }

    private Object getLock(String bookingId) {
        return bookingLocks.computeIfAbsent(bookingId, id -> new Object());
    }
}
