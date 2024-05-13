package Plant;

public class Nightpeater extends Plant {
      private boolean isNight;

      public Nightpeater(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown) {
            super(name, health, attack_damage, attack_speed, cost, range, cooldown);
        }

      public boolean getIsNight(){
            return this.isNight;
      }
      
}
