package in.spdev.scopes.api;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

public class InstanceTracker {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static int getYourInstanceTracked(){
        return atomicInteger.getAndIncrement();
    }
}
