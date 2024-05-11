package Plant;

public class Defender extends Plant {
      

      public Defender(String name, int health, int attack_damage, int attack_speed,int cost, int range, int cooldown){
            attack_damage = 0;
            attack_speed = 0;
            range = 0;
            super(name, health,cost,range,cooldown);
      };
}
