package Plant;

public class Tallnut extends Plant{
      private boolean blocked;


      public Tallnut(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown) {
            super("Tall-nut", 2000, 0, 0, 125, 0, 20);
        }

      public boolean blocked(){
            return blocked;
      }

}
