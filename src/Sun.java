public class Sun {
    private int totalSun;
    private static Sun instance;

    private Sun() {
        totalSun = 0;
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

    public void generateSun() {
        totalSun += 25;
    }

    public void spendSun(int cost) throws Exception {
        if (totalSun >= cost) {
            totalSun -= cost;
        } else {
            throw new Exception("Not enough sun to spend");
        }
    }
}
