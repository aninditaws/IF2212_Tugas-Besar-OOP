package Plant;

import Character.Character;
import Game.GameMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import Plant.Bullets.Bullet;
import java.util.List;
import java.util.ArrayList;

public class Plant extends Character {
      /* ATRIBUT */
      public int cost;
      public int range;
      public int cooldown;
      protected String file;
      protected BufferedImage image;
      public int x, y;

      private long lastShotTime;
      private List<Bullet> bullets;
      /* NOTES */
      // attack_speed = tanaman meyerang dalam x detik
      // range = satuannya dalam tile. 0 artinya ga nyerang. -1 artinya bisa menyerang
      // sepanjang jalur
      // cooldown = satuannya pake
      /* KONSTRUKTOR */

      public Plant(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown,
                  Point position) {

            super(name, health, attack_damage, attack_speed);
            this.cost = cost;
            this.range = range;
            this.cooldown = cooldown;
            this.position = position;
            this.file = getImagePath();
            this.lastShotTime = System.currentTimeMillis();
            this.bullets = new ArrayList<>();

      }

      /* GETTER & SETTER */

      public int getCost() {
            return this.cost;
      }

      public int getCooldownTime() {
            return this.cooldown;
      }

      public int getRange() {
            return this.range;
      }

      public void spawnPlant() {

      };

      public void takeDamage() {
            reduceHealth(attack_damage);
            if (isDead()) {
                  die(); // Hapus plant dari permainan
            }
      };

      // public void rangeZombie() {};
      public void shoot() {

      }

      public void updateBullets() {

      }

      public List<Bullet> getBullets() {
            return bullets;
      }

      public void draw(Graphics2D g2) {
            try {
                  image = ImageIO.read(new File(file));
            } catch (Exception e) {
                  e.printStackTrace();
            }
            g2.drawImage(image, position.x, position.y, null); // Example size
      }

      public void die() {
            if (isDead()) {
                  System.out.println("Plant has been dead");
            }
      }

      // getImagePath
      public String getImagePath() {
            return file;
      }

      public void attack(GameMap<Object> gameMap) {
            // Diturunkan ke setiap plant class, nanti jadi logicnya
      }

      public void bePlanted() {
      }
}
