package com.haldes.lld.coding.ratelimit;

import java.util.Map;

public class FixedWindowRateLimit implements RateLimit{
    private Integer maxToken;
    private long windowSizeInMillis;
    private Map<String,Integer> tokenBucket;
    private Map<String,Long> timeWindow;

    public FixedWindowRateLimit(Integer maxToken, Long windowSizeInMillis){
        this.maxToken = maxToken;
        this.windowSizeInMillis = windowSizeInMillis;

    }

    @Override
    public Boolean rateLimit(String clientId) {

        // If client is coming for the first time, Then initialize 
        tokenBucket.putIfAbsent(clientId, 0);
        timeWindow.putIfAbsent(clientId,System.currentTimeMillis());
        // When to replenish or reset the counter based on time window
        Long now = System.currentTimeMillis();
        Long lastWindowTime = timeWindow.get(clientId);
        if(now - lastWindowTime > windowSizeInMillis){
            timeWindow.put(clientId, now);
            tokenBucket.put(clientId,0);
        }

        // Fetch token for clientId
        Integer tokenCount = tokenBucket.get(clientId);
        // If current token is well under maxToken count then allow else restrict
        if(tokenCount < maxToken) {
            tokenCount++;
            tokenBucket.put(clientId,tokenCount);
            return false;
        }
        return true;
    }
}
