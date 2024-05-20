package Plant;

import java.awt.*;

public class CherryBomb extends Plant{

      public CherryBomb() {
            super("Cherrybomb", 100, 5000, 0, 150, 12, 25, null);
      }
      public CherryBomb(Point position) {
            super("Cherrybomb", 100, 5000, 0, 150, 12, 25, position);
      }
}