import Subscriber.EventChannel;

import java.util.Date;

public class GameManager {
    public static Thread timerThread;
    private static final EventChannel channel = EventChannel.getInstance();

    private static int gameTick = 0;
    public static void startTimer() {
        // Membuat sebuah thread yang akan menjalankan updateGameTick setiap 1 detik (1000 milliseconds)
        timerThread = new Thread(() -> {
            try {
                while (true) {
                    updateGameTick();
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

    public static void updateGameTick() {
        System.out.println(new Date());
        gameTick += 1;
        gameTick = gameTick % 200;
        channel.publishUpdate(gameTick);
    }
}
