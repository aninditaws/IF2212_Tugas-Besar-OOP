package Plant;

import java.awt.*;

public class SnowPea extends Plant{
      
      
      public SnowPea() {
            super("Snow pea", 100, 25, 4, 175, -1, 10, null);
      }
      public SnowPea(Point position) {
            super("Snow pea", 100, 25, 4, 175, -1, 10, position);
      }
}

