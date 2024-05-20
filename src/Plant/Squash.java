package Plant;

import java.awt.*;

public class Squash extends Plant {

      public Squash() {
            super("Squash", 100, 5000, 0, 50, 1, 20, null);
      }
      public Squash(Point position) {
            super("Squash", 100, 5000, 0, 50, 1, 20, position);
      }
}
