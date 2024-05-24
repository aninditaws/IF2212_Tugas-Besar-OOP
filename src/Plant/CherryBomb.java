package Plant;

import Game.GameMap;
import Zombie.Zombie;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CherryBomb extends Plant{

      public CherryBomb() {
            super("Cherrybomb", 100, 5000, 0, 150, 12, 25, null);
      }
      public CherryBomb(Point position) {
            super("Cherrybomb", 100, 5000, 0, 150, 12, 25, position);
      }

      @Override
      public void attack(GameMap<Object> gameMap) {
            super.attack(gameMap);
            List<Point> points = new ArrayList<>();
            points.add(new Point(Math.min(position.x + 1, 10), position.y));
            points.add(new Point((Math.min(position.x + 1, 10)), Math.max(position.y - 1, 0)));
            points.add(new Point(position.x, Math.max(position.y - 1, 0)));
            points.add(new Point((Math.max(position.x - 1, 0)), Math.max(position.y - 1, 0)));
            points.add(new Point((Math.max(position.x - 1, 0)), position.y));
            points.add(new Point((Math.max(position.x - 1, 0)), Math.min(position.y + 1, 5)));
            points.add(new Point(position.x, Math.min(position.y + 1, 5)));
            points.add(new Point((Math.min(position.x + 1, 10)), Math.min(position.y + 1, 5)));
            List<List<Object>> entitiesAttacked = gameMap.getEntitiesRange(points);
            entitiesAttacked.forEach(list -> {
                  list.forEach(zombie -> {
                        ((Zombie) zombie).reduceHealth(attack_damage);
                        System.out.println(String.format("Cherrybomb attacks %s", ((Zombie) zombie).name));
                  });
            });
            dead = true;
      }
}