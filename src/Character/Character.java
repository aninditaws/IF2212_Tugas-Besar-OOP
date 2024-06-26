package Character;

import Subscriber.Subscriber;

import java.awt.*;

abstract public class Character implements Subscriber {
      public String name;
      public int health;
      public int attack_damage;
      public int attack_speed;
      public boolean dead;

      public Point position;

      public Character(String name, int health, int attack_damage, int attack_speed) {
            this.name = name;
            this.health = Math.max(0, health); // memastikan health is not negative
            this.attack_damage = Math.max(0, attack_damage); // memastikan attack_speed is not negative
            this.attack_speed = Math.max(0, attack_speed); // memastikan attack_speed is not negative

      }

      public void setName(String nama) {
            this.name = nama;
      }

      public String getName() {
            return this.name;
      }

      public void setHealth(int health) {
            this.health = Math.max(0, health);
      }

      public int getHealth() {
            return this.health;
      }

      public void setAttackDamage(int attack_damage) {
            this.attack_damage = Math.max(0, attack_damage);
      }

      public int getAttackDamage() {
            return this.attack_damage;
      }

      public void setAttackSpeed(int attack_speed) {
            this.attack_speed = Math.max(0, attack_speed);
      }

      public int getAttackSpeed() {
            return this.attack_speed;
      }

      public void reduceHealth(int damage) {
            this.health -= damage;
            if (this.health < 0) {
                  dead = true;
            }
      }

      public boolean isDead() {
            return this.getHealth() <= 0;
      }

      public void attack(Character character) {
            character.reduceHealth(this.attack_damage);
      }

      @Override
      public void update(int gameTick) {
            // DO NOTHING
      }

}