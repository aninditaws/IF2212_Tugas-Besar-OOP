package Plant;

import java.awt.*;

public class Jalapeno extends Plant {

      public Jalapeno() {
            super("Jalapeno", 100, 5000, 0, 125, 9, 20, null);
      }
      public Jalapeno(Point position) {
            super("Jalapeno", 100, 5000, 0, 125, 9, 20, position);
      }
}
