package Zombie;

import java.awt.*;

public class ScreenDoorZombie extends Zombie {
    public ScreenDoorZombie(Point position) {
        super("Screen Door Zombie", 400, 100, 2, false, position);
    }

    // Zombie ini lebih kuat dan lebih sakit attacknya
}
