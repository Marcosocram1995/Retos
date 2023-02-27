package model.printer;

import java.util.concurrent.TimeUnit;

public class Waiter {
    private Waiter() {

    }

    public static void sleep(int seconds) {
        long millis = TimeUnit.SECONDS.toMillis(seconds);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
