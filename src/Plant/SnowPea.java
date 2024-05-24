package Plant;

import java.awt.*;

import Game.GameMap;
import Plant.Bullets.Bullet;
import java.util.List;
import java.util.ArrayList;

public class SnowPea extends Plant {
      private List<Bullet> bullets;
      private long lastShotTime;
      private int doShoot = 1;


      public SnowPea() {
            super("Snow pea", 100, 25, 4, 175, -1, 10, null);
      }

      public SnowPea(Point position) {
            super("Snow pea", 100, 25, 4, 175, -1, 10, position);
            this.bullets = new ArrayList<>();
      }

      @Override
      public void attack(GameMap<Object> gameMap) {
            super.attack(gameMap);
            doShoot -= 1;
            System.out.println("Shoot?");
            System.out.println(doShoot);
            if (doShoot == 0) {
                  doShoot = cooldown;
                  System.out.println("Shooting a bullet from position: " + position);
                  gameMap.addEntity(new Bullet(new Point(position.x + 1, position.y), attack_damage, true), position.y, position.x + 1);
            }
      }

      @Override
      public List<Bullet> getBullets() {
            return bullets;
      }
}
