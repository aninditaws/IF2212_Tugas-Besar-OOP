package Plant;

import Subscriber.EventChannel;
import Sun.Sun;

public class Sunflower extends Plant {
      private int doUpdate;

      public Sunflower() {
            super("Sunflower", 100, 0, 0, 50, 0, 10);
            doUpdate = 0;
          EventChannel.instance.subscribe(this);
        }

    @Override
    public void update() {
//        System.out.println("mencoba update sunflower");
//        System.out.println(doUpdate);
        doUpdate += 1;
        if (doUpdate == 3) {
            System.out.println("berhasil update");
            generateSun();
            doUpdate = 0;
        }
    }

    public void generateSun() {
          Sun.getInstance().generateSun();
      }
}
