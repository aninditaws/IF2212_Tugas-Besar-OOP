package Plant;

import java.awt.*;

public class Tallnut extends Plant{
      private boolean blocked;

      public Tallnut() {
            super("Tall-nut", 2000, 0, 0, 125, 0, 20, null);
      }
      public Tallnut(Point position) {
            super("Tall-nut", 2000, 0, 0, 125, 0, 20, position);
      }

      public boolean blocked(){
            return blocked;
      }

}
