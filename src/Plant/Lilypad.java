package Plant;

public class Lilypad extends Plant {
      private boolean planted;      

      public Lilypad(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown) {
            super(name, health, attack_damage, attack_speed, cost, range, cooldown);
        }

      public boolean getPlanted(){
            return this.planted;
      }  
}
