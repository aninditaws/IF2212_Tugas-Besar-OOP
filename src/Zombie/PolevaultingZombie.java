package Zombie;

import java.awt.*;
import java.util.stream.Collectors;

import Game.GameMap;
import Plant.Plant;
import Plant.Tallnut;
import Character.Character;

public class PolevaultingZombie extends Zombie {

    private boolean canJump = true;

    public PolevaultingZombie(Point position) {
        super("Pole Vaulting Zombie", 175, 100, 1, false, position);
    }

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
