public class Sun {
    private static int totalSun = 0;

    public static int gettotalSun(){
        return totalSun;
    }

    public static void generateSun(){
        totalSun += 25;
    }

    public static void spendSun(int cost){
        if (totalSun >= cost) {
            totalSun -= cost;
        } else {
            System.out.println("Not enough sun to spend. Total sun available: " + totalSun);
        }
    }
}