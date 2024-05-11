package Plant;

public class Tallnut extends Plant{
      private boolean blocked;


      public Tallnut(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown) {
            super(name, health, attack_damage, attack_speed, cost, range, cooldown);
        }

      public boolean blocked(){
            return blocked;
      }

}
