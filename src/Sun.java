public class Sun{
    private int totalSun;

    public Sun(){
        totalSun = 0;
    }

    public int gettotalSun(){
        return totalSun;
    }

    public void generateSun(){
        totalSun += 25;
    }

    public void spendSun(int cost) throws Exception{
        if (totalSun >= cost) {
            totalSun -= cost;
        } else {
            throw new Exception("Not enough sun to spend");
        }
    }
}