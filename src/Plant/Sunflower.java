package Plant;

import Subscriber.EventChannel;
import Sun.Sun;

public class Sunflower extends Plant {

    private int doUpdate = 0;
      public Sunflower(int x, int y) {
            super("Sunflower", 100, 0, 0, 50, 0, 10, x, y);
          EventChannel.getInstance().subscribe(this);
        }

    @Override
    public void update(int gameTick) {
//        System.out.println("mencoba update sunflower");
//        System.out.println(doUpdate);
        if (doUpdate % 3 == 0) {
            doUpdate += 1;
            System.out.println("berhasil update");
            generateSun();
        }
    }

    public void generateSun() {
          Sun.getInstance().generateSun();
      }
}
