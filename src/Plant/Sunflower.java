package Plant;

import Subscriber.EventChannel;
import Sun.Sun;

public class Sunflower extends Plant {

    private int doUpdate = 0;
      public Sunflower() {
            super("Sunflower", 100, 0, 0, 50, 0, 10, "ImagePvZ/Plant/PlantzImg/Sunflower.png");
          EventChannel.getInstance().subscribe(this);
        }

    @Override
    public void update(int gameTick) {
//        System.out.println("mencoba update sunflower");
//        System.out.println(doUpdate);
        doUpdate += 1;
        if (doUpdate == 2) {
            doUpdate = 0;
            System.out.println("berhasil update");
            generateSun();
        }
    }

    public void generateSun() {
          Sun.getInstance().generateSun();
      }
}
