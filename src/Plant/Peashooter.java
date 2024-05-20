package Plant;

import java.awt.*;

public class Peashooter extends Plant {

      public Peashooter() {
            super("Peashooter", 100, 25, 4, 100, -1, 10, null);
      }
      public Peashooter(Point position) {
            super("Peashooter", 100, 25, 4, 100, -1, 10, position);
      }
}