package Game;

import Subscriber.EventChannel;
import Zombie.Zombie;
import ZombieFactory.ZombieFactory;
import ZombieFactory.ZombieType;

import java.util.Date;
import java.util.Random;

public class GameManager {

    public int flag = 0;

    // Time Manager
    public Thread timerThread;
    private final EventChannel channel = EventChannel.getInstance();

    public void startTimer() {
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

    public void stopTimer() {
        // Membuat thread berhenti
        timerThread.interrupt();
    }

    public synchronized void updateGameTick(int gameTick) {
        System.out.println(new Date());
        channel.publishUpdate(gameTick);
        System.out.println(gameTick);
        if (gameTick == 50) {
            flag += 1;
            System.out.println("flag increased");
        }
    }

    // Map Manager

    private final GameMap<Object> gameMap = new GameMap<>(9, 6);


    public GameMap<Object> getGameMap() {
        return gameMap;
    }

    private void spawnZombie(int gameTick) {
        // Mekanisme buat cek zombie di setiap area map

        int max = 6; // Sejumlah tipe zombie
        int min = 1;
        int randomIndex = (int) ((Math.random() * (max - min)) + min);
        ZombieType[] zombieTypes = ZombieType.values();
        ZombieFactory zombieFactory = new ZombieFactory();

        for (int i = 0; i <= flag; i += 1) {
            boolean val = new Random().nextInt(3)==0;

            if (val) {
                zombieFactory.CreateZombie(zombieTypes[randomIndex]);
            }
        }
    }

    private int countZombies() {
        // TODO

        return 0;
    }
}
