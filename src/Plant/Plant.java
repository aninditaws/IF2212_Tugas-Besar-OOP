package Plant;
import Character.Character;

public class Plant extends Character {
      /*ATRIBUT*/
      private int cost; 
      private int range;  
      private int cooldown;

      /* NOTES */
      // attack_speed = tanaman meyerang dalam x detik
      // range = satuannya dalam tile. 0 artinya ga nyerang. -1 artinya bisa menyerang sepanjang jalur
      // cooldown = satuannya pake
      /*KONSTRUKTOR*/

      public Plant(String name, int health, int attack_damage, int attack_speed,int cost, int range, int cooldown) {
            super(name, health, attack_damage, attack_speed);
            this.cost = cost;
            this.range = range;
            this.cooldown = cooldown;
      }

      /*GETTER & SETTER*/      

      public int getCost(){
            return this.cost;
      }

      public int getCooldownTime(){
            return this.cooldown;
      }

      public int getRange(){
            return this.range;
      }

      public void spawnPlant(){

      };

      public void takeDamage(){
            reduceHealth(attack_damage);
            if (isDead()) {
                  die(); // Hapus plant dari permainan
              }
      };

      public void rangeZombie();
      
      
      public void shoot(){
            System.out.println("Has been shot");
      }

      public void draw(); //buat ngedraw 

      public void die(){
            if (isDead()){
                  System.out.println("Plant has been dead");
            }
      }
}
