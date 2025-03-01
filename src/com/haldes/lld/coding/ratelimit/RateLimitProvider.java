package com.haldes.lld.coding.ratelimit;

public class RateLimitProvider {
    private RateLimitProvider instance;

    // Private constructor
    private RateLimitProvider(){
    };

    public RateLimitProvider getInstance(){
        if(instance == null){
            this.instance =  new RateLimitProvider();
        }
        return this.instance;
    }

    private void ping() {
        System.out.println("I am RateLimitProvider Instance");
    }
}
