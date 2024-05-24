package Zombie;

import java.awt.*;
import java.util.stream.Collectors;

import Game.GameMap;
import Plant.Plant;
import Plant.Tallnut;

public class PolevaultingZombie extends Zombie {

    private boolean canJump;

    public PolevaultingZombie(Point position) {
        super("Pole Vaulting Zombie", 175, 100, 1, false, position);
    }

    public void jump(){
        if (canJump==true && Plant.name == "Tallnut" ) {
            // Dapat melakukan lompatan, zombie nembus tanaman di depannya
            // gameMap.moveEntity(position.getX(),position.getY(), (position.getX() + 1), (position.getY() + 1));
            System.out.println(String.format("Pole Vault zombie jumped to %d from %d, %d to %d.", position.getX(), (position.getX() + 1), position.getY(), (position.getY() + 1)));

        }
    }

    public void setCanJump(boolean canJump){
        this.canJump = canJump;
    }
}
