package com.tech;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public class TrackingNumberGenerator {

    private static final AtomicLong counter = new AtomicLong(0);

    public static String generate() {
        // Use the current epoch second to ensure uniqueness across time and different instances
        long timestamp = Instant.now().getEpochSecond();

        // Combine the timestamp with a unique, in-memory counter to ensure uniqueness
        // within the same second and on the same instance
        long combined = (timestamp << 20) | counter.getAndIncrement();

        // Encode the combined number using Base62 to get a compact, alphanumeric string
        return Base62.encode(combined);
    }
}