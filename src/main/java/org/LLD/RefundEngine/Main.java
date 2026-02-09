package org.LLD.RefundEngine;

import org.LLD.BookingCancellation.Repository.BookingRepository;
import org.LLD.RefundEngine.Model.Booking;
import org.LLD.RefundEngine.Model.PaymentMethod;
import org.LLD.RefundEngine.Model.PaymentTransaction;
import org.LLD.RefundEngine.Model.RefundRequest;
import org.LLD.RefundEngine.Repository.RefundRepository;
import org.LLD.RefundEngine.Service.RefundProcessorService;
import org.LLD.RefundEngine.Service.RefundServiceImpl;
import org.LLD.RefundEngine.Service.SupplierService;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        BookingRepository bookingRepository = new BookingRepository();
        SupplierService supplierService = new SupplierService();
        RefundRepository refundRepository = RefundRepository.getInstance();

        RefundServiceImpl refundService = new RefundServiceImpl(bookingRepository, supplierService, refundRepository);
        RefundProcessorService processorService = new RefundProcessorService(refundService);

        RefundRequest refundRequest = refundService.refund(
                "123", new Booking("125",
                        Instant.now(),
                        List.of(
                                new PaymentTransaction("1", PaymentMethod.CARD, BigDecimal.valueOf(700)),
                                new PaymentTransaction("2", PaymentMethod.UPI, BigDecimal.valueOf(300))
                        )
                ));

        RefundRequest refundRequest2 = refundService.refund(
                "123", new Booking("125",
                        Instant.now(),
                        List.of(
                                new PaymentTransaction("1", PaymentMethod.CARD, BigDecimal.valueOf(700)),
                                new PaymentTransaction("2", PaymentMethod.UPI, BigDecimal.valueOf(300))
                        )
                ));

        System.out.println(refundRequest.toString());
        System.out.println(refundRequest2.toString());

        new Thread(processorService).start();
    }

}
