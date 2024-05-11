package Plant;

public class Tallnut extends Plant{
      private boolean blocked;


      public Tallnut(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown) {
            super(name, health, attack_damage, attack_speed, cost, range, cooldown);
            this.name = name;
            this.health = health;
            this.attack_damage = attack_damage;
            this.attack_speed = attack_speed;
        }

      public String getName(){
            return name;
      }
      public void setName(String name) {
            this.name = name;
        }
    
      public int getHealth() {
            return health;
        }
    
      public int getAttackDamage() {
            return attack_damage;
        }
    
      public int getAttackSpeed() {
            return attack_speed;
        }

      public boolean blocked(){
            return blocked;
      }

}
