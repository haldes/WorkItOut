package com.haldes.lld.coding.ratelimit;

public interface RateLimit {
    Boolean rateLimit(String clientId);
}
