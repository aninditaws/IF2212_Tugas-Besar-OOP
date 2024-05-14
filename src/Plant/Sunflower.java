package Plant;

import Subscriber.EventChannel;
import Sun.Sun;

public class Sunflower extends Plant {

      public Sunflower() {
            super("Sunflower", 100, 0, 0, 50, 0, 10);
          EventChannel.getInstance().subscribe(this);
        }

    @Override
    public void update(int gameTick) {
//        System.out.println("mencoba update sunflower");
//        System.out.println(doUpdate);
        if (gameTick % 3 == 0) {
            System.out.println("berhasil update");
            generateSun();
        }
    }

    public void generateSun() {
          Sun.getInstance().generateSun();
      }
}
