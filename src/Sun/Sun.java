package Sun;

import Subscriber.EventChannel;
import Subscriber.Subscriber;

public final class Sun implements Subscriber {
    private int totalSun;
    private static Sun instance;

    private int randomGeneratedInterval = 0;
    private int doUpdate = 0;

    private Sun() {
        totalSun = 25;
        EventChannel.getInstance().subscribe(this);
        generateRandomInterval();
    }

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }

    public int getTotalSun() {
        return totalSun;
    }

    public synchronized void generateSun() {
        totalSun += 25;
    }

    public synchronized void spendSun(int cost) throws Exception {
        if (totalSun >= cost) {
            totalSun -= cost;
        } else {
            throw new Exception("Not enough sun to spend");
        }
    }

    public void generateRandomInterval() {
        int max = 10;
        int min = 5;
        randomGeneratedInterval = (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void update(int gameTick) {
        // Memberikan sun dalam jangka waktu yang random pada PAGI HARI (0 - 100)
        doUpdate += 1;
        if (doUpdate == randomGeneratedInterval) {
            doUpdate = 0;
            generateRandomInterval();
            if (gameTick < 100) {
                generateSun();
                System.out.println("Generated sun");
            }
        }
    }
}
