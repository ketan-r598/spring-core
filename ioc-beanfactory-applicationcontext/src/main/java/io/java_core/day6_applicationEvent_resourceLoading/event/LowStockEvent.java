package io.java_core.day6_applicationEvent_resourceLoading.event;

import org.springframework.context.ApplicationEvent;

public class LowStockEvent extends ApplicationEvent {
    private final String userEmail;
    private final int stocks;

    public LowStockEvent(Object source, String userEmail, int stocks) {
        super(source);
        this.userEmail = userEmail;
        this.stocks = stocks;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getStocks() {
        return stocks;
    }

    @Override
    public String toString() {
        return "LowStockEvent{" +
                "userEmail='" + userEmail + '\'' +
                ", stocks=" + stocks +
                '}';
    }
}
