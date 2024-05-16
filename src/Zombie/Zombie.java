package Zombie;

import Character.Character;
import Exception.IllegalMoveException;
import Subscriber.EventChannel;

import java.awt.*;

public class Zombie extends Character {

    private static int id = 0;
    public int zombieId = 0;

    public Point position;
    public boolean is_aquatic;
    private int doUpdate = 0;
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
        if (finalX > 11 || finalX < 0 || finalY > 6 || finalY < 0) {
            throw new IllegalMoveException("Illegal move!");
        }
        if (is_aquatic && (finalY < 2 || finalY > 4) ) {
            throw new IllegalMoveException("Illegal move!");
        }
        if (!is_aquatic && (finalY > 1 && finalY < 4)) {
            throw new IllegalMoveException("Illegal move!");
        }
        System.out.println(String.format("Zombie %d moved from %d, %d to %d, %d", zombieId, position.x, position.y, finalX, finalY));
        position.x = finalX;
        position.y = finalY;
    }

    @Override
    public void update(int gameTick) {
        super.update(gameTick);
        doUpdate += 1;
        if (doUpdate == 5) {
            doUpdate = 0;
            try {
                move(-1, 0);
            } catch (IllegalMoveException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
