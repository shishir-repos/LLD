package org.LLD.NotificationService.Util;


import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;


public class SimpleRateLimiter {


    private final ConcurrentHashMap<String, Instant>  lastSent =
            new ConcurrentHashMap<>();


    public synchronized boolean allow(String userId) {
        Instant now = Instant.now();
        Instant last = lastSent.get(userId);


        long intervals = 1;
        if (last == null || now.minusSeconds(intervals).isAfter(last)) {
            lastSent.put(userId, now);
            return true;
        } else {
            return false;
        }
    }
}

