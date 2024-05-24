package Plant;

import Game.GameMap;
import Zombie.Zombie;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Jalapeno extends Plant {

      public Jalapeno() {
            super("Jalapeno", 100, 5000, 0, 125, 9, 20, null);
      }
      public Jalapeno(Point position) {
            super("Jalapeno", 100, 5000, 0, 125, 9, 20, position);
      }

      @Override
      public void attack(GameMap<Object> gameMap) {
            super.attack(gameMap);
            java.util.List<Point> points = new ArrayList<>();
            for (int i = 0; i < 11; i++) {
                  points.add(new Point(i, position.y));
//                  System.out.println(String.format("add point %d, %d", i, position.y));
            }
            List<List<Object>> entitiesAttacked = gameMap.getEntitiesRange(points);
            entitiesAttacked.forEach(list -> {
                  list.forEach(entity -> {
                        if (entity instanceof Zombie) {
                              ((Zombie) entity).reduceHealth(attack_damage);
                              System.out.println(String.format("Jalapeno attacks %s", ((Zombie) entity).name));
                        }
                  });
            });
            dead = true;
      }
}
