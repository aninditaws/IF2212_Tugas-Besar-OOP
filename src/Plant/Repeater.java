package Plant;

import java.awt.*;

import Game.GameMap;
import Plant.Bullets.Bullet;
import java.util.List;
import java.util.ArrayList;

public class Repeater extends Plant {
      private long lastShotTime;
      private int doShoot = 2;

      public Repeater() {
            super("Repeater", 100, 25, 8, 200, -1, 10, null);
      }

      public Repeater(Point position) {
            super("Repeater", 100, 25, 8, 200, -1, 10, position);
      }

      @Override
      public void attack(GameMap<Object> gameMap) {
            super.attack(gameMap);
            doShoot -= 1;
            System.out.println("Shoot?");
            System.out.println(doShoot);
            if (doShoot == 1) {
                  System.out.println("Shooting a repeater bullet from position: " + position);
                  gameMap.addEntity(new Bullet(new Point(position.x + 1, position.y), attack_damage, false), position.y, position.x + 1);
            }
            if (doShoot == 0) {
                  doShoot = cooldown;
                  System.out.println("Shooting a repeater bullet from position: " + position);
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
//
//      @Override
//      public List<Bullet> getBullets() {
//            return bullets;
//      }
}
