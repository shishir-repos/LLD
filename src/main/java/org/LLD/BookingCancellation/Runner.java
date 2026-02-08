package org.LLD.BookingCancellation;

import org.LLD.BookingCancellation.Model.Booking;
import org.LLD.BookingCancellation.Model.BookingStatus;
import org.LLD.BookingCancellation.Model.ProductType;
import org.LLD.BookingCancellation.Repository.BookingRepository;
import org.LLD.BookingCancellation.Repository.CancellationPolicyRepo;
import org.LLD.BookingCancellation.Service.BookingService;
import org.LLD.BookingCancellation.Service.CancellationService;
import org.LLD.BookingCancellation.Service.RefundService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Booking booking = new Booking("SHISH12", ProductType.FLIGHT, Instant.now(), LocalDateTime.now().plusDays(21).toInstant(ZoneOffset.UTC), 10000, BookingStatus.BOOKED);

        BookingRepository bookingRepository = new BookingRepository();
        bookingRepository.getBookings().add(booking);

        CancellationService service = new CancellationService(new BookingService(), bookingRepository, CancellationPolicyRepo.getInstance(), new RefundService());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i<3; i++) {
            executorService.submit(() -> service.cancel(booking));
        }
    }

}
