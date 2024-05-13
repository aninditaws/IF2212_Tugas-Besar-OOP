import Plant.Sunflower;
import Sun.Sun;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static Thread timerThread;
    public static Sunflower sunflower;
    public static void main(String[] args) {
        sunflower = new Sunflower();

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

        sunflower.update();
    }

}
