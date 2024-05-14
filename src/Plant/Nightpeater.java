package Plant;

public class Nightpeater extends Plant {
      private boolean isNight;

      public Nightpeater(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown) {
            super("Nightpeater", 100, 25, 4, 60, -1, 10);
        }

      public boolean getIsNight(){
            return this.isNight;
      }
      
}
