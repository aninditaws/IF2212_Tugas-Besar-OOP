package Plant;

import java.awt.*;

public class Repeater extends Plant {

      public Repeater() {
            super("Repeater", 100, 25, 8, 200, -1, 10, null);
      }
      public Repeater(Point position) {
            super("Repeater", 100, 25, 8, 200, -1, 10, position);
      }      
}
