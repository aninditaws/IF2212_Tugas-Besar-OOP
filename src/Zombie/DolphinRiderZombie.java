package Zombie;

import java.awt.*;

public class DolphinRiderZombie extends Zombie {
    private boolean canJump;

    public DolphinRiderZombie(Point position) {
        super("Dolphin Rider Zombie", 175, 100, 1, true, position);
    }


    // Bisa jump/destroy tanaman
    public void setCanJump(boolean canJump){
        this.canJump = canJump;
    }
}
