package org.LLD.NotificationService.Service;

import org.LLD.NotificationService.Exception.NotificationMessageEmptyException;
import org.LLD.NotificationService.Model.Notification;
import org.LLD.NotificationService.Util.SimpleRateLimiter;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;


public class NotificationService {

    Logger logger = Logger.getLogger(NotificationService.class.getName());

    private final BlockingQueue<Notification> queue = new LinkedBlockingQueue<>(1000);


    private final ExecutorService consumerPool;
    private final ExecutorService senderPool;
    private final SimpleRateLimiter rateLimiter = new SimpleRateLimiter();
    private volatile boolean running = true;


    public NotificationService(int consumerThreadCount, int senderThreadCount) {
        consumerPool = Executors.newFixedThreadPool(consumerThreadCount);
        senderPool = Executors.newFixedThreadPool(senderThreadCount);
        startConsumers(consumerThreadCount);
    }


    public void submitNotification(Notification n) {
        if (n == null || n.getMessage().isEmpty()) {
            throw new NotificationMessageEmptyException();
        }
        logger.info("Raising " + n.getRecipient().getNotificationType() + " Notification Request for: " + n.getRecipient().getPrimaryRecipient());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        queue.offer(n);
    }


    public void startConsumers(int count) {
        for (int i = 0; i<count; i++) {
            consumerPool.submit(this::consumeLoop);
        }
    }


    private void consumeLoop() {
        while (running) {
            try {
                Notification n = queue.take();
                senderPool.submit(() -> processNotification(n));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("Turning Off the Consumer Thread!");
    }


    public void processNotification(Notification n) {
        String userId = n.getRecipient().getPrimaryRecipient();


        if (rateLimiter.allow(userId)) {
            try {
                n.send();
            } catch (Exception e) {
                retryOrDLQ(n);
            }
        } else {
            queue.offer(n);
        }
    }


    private void retryOrDLQ(Notification n) {
        System.out.println("Failed. Sending to DLQ: "
                + n.getRecipient());
    }


    public void shutdown() {
        running = false;
        consumerPool.shutdownNow();
        senderPool.shutdownNow();
    }
}

