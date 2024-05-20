package Zombie;

import Character.Character;
import Exception.IllegalMoveException;
import Subscriber.EventChannel;

import java.awt.*;
import java.util.ArrayList;

public class Zombie extends Character {

    private static int id = 0;
    public int zombieId = 0;
    public Point position;
    public boolean is_aquatic;
    private int doUpdate = 0;
    private boolean walk = true;
    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic, Point position) {
        super(name, health, attack_damage, attack_speed);
        this.is_aquatic = is_aquatic;
        this.position = new Point(position);
        EventChannel.getInstance().subscribe(this);
        this.zombieId = id;
        id += 1;
    }

    public void move(int x, int y) throws IllegalMoveException {
        int finalX = (position.x + x);
        int finalY = (position.y + y);
        if (finalX > 10 || finalX < 0 || finalY > 6 || finalY < 0) {
            throw new IllegalMoveException(String.format("Illegal move! want to move to %d, %d", finalX, finalY));
        }
        if (is_aquatic && (finalY < 2 || finalY > 4) ) {
            throw new IllegalMoveException(String.format("Illegal move! want to move to %d, %d", finalX, finalY));
        }
        if (!is_aquatic && (finalY > 1 && finalY < 4)) {
            throw new IllegalMoveException(String.format("Illegal move! want to move to %d, %d", finalX, finalY));
        }
        System.out.println(String.format("Zombie %d moved from %d, %d to %d, %d", zombieId, position.x, position.y, finalX, finalY));
        position.x = finalX;
        position.y = finalY;
        if (finalX == 0) walk = false;
    }

    @Override
    public void attack(Character character) {
        character.reduceHealth(attack_damage);
    }

    public void getAttacked(int attack_damage){
        reduceHealth(attack_damage);
    }

    @Override
    public void update(int gameTick) {
        super.update(gameTick);
        doUpdate += 1;
        if (doUpdate == 10) {
            doUpdate = 0;
            if (walk) {
                try {
                    move(-1, 0);
                } catch (IllegalMoveException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

public int getX() {
    return this.position.x;
}

public int getY(){
    return this.position.y;
}
}
