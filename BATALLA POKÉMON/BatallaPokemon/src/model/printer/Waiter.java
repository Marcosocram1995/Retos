package model.printer;

import java.util.concurrent.TimeUnit;

public class Waiter {

    private static final int LONG_WAIT = 3;
    private static final int SHORT_WAIT = 1;

    private Waiter() {

    }

    public static void shortWait() {
        sleep(SHORT_WAIT);
    }

    public static void longWait() {
        sleep(LONG_WAIT);
    }

    private static void sleep(int seconds) {
        long millis = TimeUnit.SECONDS.toMillis(seconds);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
