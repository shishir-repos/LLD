package org.LLD.RefundEngine.Service;

import org.LLD.RefundEngine.Model.RefundRequest;
import org.LLD.RefundEngine.Model.RefundStatus;

import java.util.concurrent.BlockingDeque;
import java.util.logging.Logger;

public class RefundProcessorService implements Runnable {

    private RefundServiceImpl RefundServiceImpl;

    Logger logger = Logger.getLogger(RefundProcessorService.class.getName());

    public RefundProcessorService(RefundServiceImpl RefundServiceImpl) {
        this.RefundServiceImpl = RefundServiceImpl;
    }


    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                RefundRequest refundRequest = RefundServiceImpl.getRefundRequestsProcessingQueue().take();
                refundRequest.setRefundStatus(RefundStatus.PROCESSING);
                logger.info("Started Processing Refund..." + refundRequest.getRefundId());
                Thread.sleep(3000);
                refundRequest.setRefundStatus(RefundStatus.SETTLED);
                logger.info("Settled Refund for ID: " + refundRequest.getRefundId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
