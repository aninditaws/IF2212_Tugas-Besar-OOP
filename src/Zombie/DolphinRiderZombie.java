package Zombie;

import Plant.Tallnut;

import java.awt.*;
import Character.Character;

public class DolphinRiderZombie extends Zombie {

    private boolean canJump = true;
    public DolphinRiderZombie(Point position) {
        super("Dolphin Rider Zombie", 175, 100, 1, true, position);
    }


    // Bisa jump/destroy tanaman

    @Override
    public void attack(Character character) {
        if (canJump) {
            if (!(character instanceof Tallnut)) {
                try {
                    move(-2, 0);
                    character.dead = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            canJump = false;
        }
    }
    public void setCanJump(boolean canJump){
        this.canJump = canJump;
    }
}
