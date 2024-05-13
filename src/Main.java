import Plant.Sunflower;
import Subscriber.EventChannel;

import java.util.Date;

public class Main {

    public static Thread timerThread;
    public static Sunflower sunflower;
    private static final EventChannel channel = new EventChannel();

    public static void main(String[] args) {
        // Contoh penggunaan, subscribe ke channel untuk semua entitas yang butuh update
        sunflower = new Sunflower();
        channel.subscribe(sunflower);
        startTimer();
    }

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
        // Masukkan seluruh fungsi yang membutuhkan update sesuai waktu kesini
        System.out.println(new Date());

        channel.publishUpdate();
    }


}
