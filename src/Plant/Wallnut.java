package Plant;

import java.awt.*;

public class Wallnut extends Plant{
  
    public Wallnut() {
        super("Wall nut", 1000, 0, 0, 50, 0, 20, null);
    }
    public Wallnut(Point position) {
        super("Wall nut", 1000, 0, 0, 50, 0, 20, position);
    }
}
