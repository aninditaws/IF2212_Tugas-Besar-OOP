package Plant;

import java.awt.*;

import Plant.Bullets.Bullet;
import java.util.List;
import java.util.ArrayList;

public class SnowPea extends Plant {
      private List<Bullet> bullets;
      private long lastShotTime;

      public SnowPea() {
            super("Snow pea", 100, 25, 4, 175, -1, 10, null);
      }

      public SnowPea(Point position) {
            super("Snow pea", 100, 25, 4, 175, -1, 10, position);
            this.bullets = new ArrayList<>();
      }

      @Override
      public void shoot() {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShotTime >= cooldown * 1000) {
                  System.out.println("Shooting a bullet from position: " + position);
                  bullets.add(new Bullet(new Point(position.x + 1, position.y), 1, attack_damage));
                  lastShotTime = currentTime;
            }

      }

      @Override
      public void updateBullets() {
            for (Bullet bullet : bullets) {
                  bullet.updatePosition();
            }
            bullets.removeIf(bullet -> bullet.isOutOfBounds(11));
      }

      @Override
      public List<Bullet> getBullets() {
            return bullets;
      }
}
