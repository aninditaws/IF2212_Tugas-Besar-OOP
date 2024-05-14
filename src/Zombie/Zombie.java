package Zombie;

import Character.Character;
import Exception.IllegalMoveException;

import java.awt.*;

public class Zombie extends Character {

    public Point position;
    public boolean is_aquatic;
    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(name, health, attack_damage, attack_speed);
        this.is_aquatic = is_aquatic;
    }

    public void move(int x, int y) throws IllegalMoveException {
        int finalX = (position.x + x);
        int finalY = (position.y + y);
        if (finalX > 11 || finalX < 0 || finalY > 6 || finalY < 0) {
            throw new IllegalMoveException("Illegal move!");
        }
        if (is_aquatic && (finalY < 2 || finalY > 4) ) {
            throw new IllegalMoveException("Illegal move!");
        }
        if (!is_aquatic && (finalY > 1 && finalY < 4)) {
            throw new IllegalMoveException("Illegal move!");
        }
        position.x = finalX;
        position.y = finalY;
    }

    @Override
    public void update(int gameTick) {
        super.update(gameTick);

    }
}
