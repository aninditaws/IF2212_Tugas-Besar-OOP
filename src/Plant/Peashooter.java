package Plant;

import java.awt.*;

import Game.GameMap;
import Plant.Bullets.Bullet;
import java.util.List;
import java.util.ArrayList;

public class Peashooter extends Plant {
      private long lastShotTime;

      private int doShoot = 1;

      public Peashooter() {
            super("Peashooter", 100, 25, 4, 100, -1, 10, null);
      }

      public Peashooter(Point position) {
            super("Peashooter", 100, 25, 4, 100, -1, 10, position);
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
                  gameMap.addEntity(new Bullet(new Point(position.x + 1, position.y), attack_damage, false), position.y, position.x + 1);
            }
      }

//      @Override
//      public void updateBullets() {
//            for (Bullet bullet : bullets) {
//                  bullet.updatePosition();
//            }
//            bullets.removeIf(bullet -> bullet.isOutOfBounds(11));
//      }

//      @Override
//      public List<Bullet> getBullets() {
//            return bullets;
//      }

}