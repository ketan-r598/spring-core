package io.java_core.day6_applicationEvent_resourceLoading.eventListener;

import io.java_core.day6_applicationEvent_resourceLoading.event.BookCheckedOutEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BookCheckedOutEventListener implements ApplicationListener<BookCheckedOutEvent> {
    @Override
    public void onApplicationEvent(BookCheckedOutEvent event) {
        System.out.println(" >>> BookCheckedOutEventListener is executed...");
        System.out.println(event);
        System.out.println(" >>> BookCheckedOutEventListener is completed...");
    }
}
