package org.LLD.BookingCancellation.Service;

import java.util.logging.Logger;

public class RefundService {

    Logger logger = Logger.getLogger(RefundService.class.getName());

    public void refund() {
        logger.info("Requesting Refund...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Request for refund added to the Queue.");
    }
}
