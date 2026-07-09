package io.java_core.day6_applicationEvent_resourceLoading.eventListener;

import io.java_core.day6_applicationEvent_resourceLoading.event.BookCheckedOutEvent;
import io.java_core.day6_applicationEvent_resourceLoading.event.LowStockEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsEventListener {

    @EventListener
    public void lowStockEventListener(LowStockEvent lowStockEvent) {
        System.out.println(">>> Low Stock Event Listener is executing...");
        System.out.println(lowStockEvent);
        System.out.println(">>> Low Stock Event Listener is done...");
    }

    @EventListener
    @Async
    public void bookCheckedOutEventListener(BookCheckedOutEvent bookCheckedOutEvent) {
        System.out.println(">>> Book Checked Out Event Listener is executing for the second time...");
        System.out.println(bookCheckedOutEvent);
        System.out.println(">>> Book Checked Out Event Listener is done for the second time... ");
    }
}
