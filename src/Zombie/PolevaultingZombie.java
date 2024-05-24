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

//    public void jump(){
//        if (canJump==true && Plant.name == "Tallnut" ) {
//            // Dapat melakukan lompatan, zombie nembus tanaman di depannya
//            // gameMap.moveEntity(position.getX(),position.getY(), (position.getX() + 1), (position.getY() + 1));
//            System.out.println(String.format("Pole Vault zombie jumped to %d from %d, %d to %d.", position.getX(), (position.getX() + 1), position.getY(), (position.getY() + 1)));
//
//        }
//    }
    // minimal code nya dipikirin dulu deh, jangan asal! ini apaan Plant.name?? itu static class

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
