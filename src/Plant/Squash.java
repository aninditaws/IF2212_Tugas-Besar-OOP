package Plant;

import Game.GameMap;
import Zombie.Zombie;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class Squash extends Plant {

      public Squash() {
            super("Squash", 100, 5000, 0, 50, 1, 20, null);
      }
      public Squash(Point position) {
            super("Squash", 100, 5000, 0, 50, 1, 20, position);
      }

      @Override
      public void attack(GameMap<Object> gameMap) {
            super.attack(gameMap);
            List<Object> nextColZombies = gameMap.getEntities(position.y, (Math.min(position.x + 1, 10))).stream().filter(entity -> entity instanceof Zombie).collect(Collectors.toList());
            nextColZombies.forEach(zombie -> {
                  ((Zombie) zombie).reduceHealth(attack_damage);
                  System.out.println(String.format("Squash attacks %s", ((Zombie) zombie).name));
                  dead = true;
            });
      }
}
