import Subscriber.EventChannel;

import java.util.Date;

public class GameManager {
    public static Thread timerThread;
    private static final EventChannel channel = EventChannel.getInstance();

    public static void startTimer() {
        // Membuat sebuah thread yang akan menjalankan updateGameTick setiap 1 detik (1000 milliseconds)
        timerThread = new Thread(() -> {
            try {
                int gameTick = 0;
                while (true) {
                    gameTick += 1;
                    gameTick = gameTick % 200;
                    updateGameTick(gameTick);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Game loop is interrupted!");
            }
        });

        // Membuat thread berjalan
        timerThread.start();
    }

    public static void stopTimer() {
        // Membuat thread berhenti
        timerThread.interrupt();
    }

    public static synchronized void updateGameTick(int gameTick) {
        System.out.println(new Date());
        channel.publishUpdate(gameTick);
    }
}
