package Zombie;

import Zombie.Zombie;

import java.awt.*;

public class ImpZombie extends Zombie {
    public ImpZombie(Point position) {
        super("Imp Zombie", 100, 1000, 1, false, position);
    }
}