import Plant.Sunflower;
import Subscriber.EventChannel;

import java.util.Date;

public class Main {

    public static Thread timerThread;
    private static final EventChannel channel = EventChannel.instance;

    public static void main(String[] args) {
        // Contoh penggunaan, subscribe ke channel untuk semua entitas yang butuh update
        // Subscribe dilakukan di setiap kelas yang butuh update (cek kelas Sunflower untuk contoh)
        // Subscrive dilakukan dengan memanggil subscrive ke singleton instance dari eventchannel
        Sunflower sunflower = new Sunflower();
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
        System.out.println(new Date());
        channel.publishUpdate();
    }


}
