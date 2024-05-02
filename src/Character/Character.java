package Character;

public class Character {
      public String name;
      public int health;
      public int attack_damage;
      public int attack_speed;
      public boolean dead;

public Character(String name, int health, int attack_damage, int attack_speed)
{
      this.name = name;
      this.health = Math.max (0, health); //memastikan health is not negative
      this.attack_damage = Math.max(0, attack_damage); //memastikan attack_speed is not negative
      this.attack_speed = Math.max(0, attack_speed); //memastikan attack_speed is not negative

}

      public void setName(String nama){
            this.name=nama;
      }
      public String getName(){
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
      public int getAttackDamage(){
            return this.attack_damage;
      }

      public void setAttackSpeed(int attack_speed){
            this.attack_speed = Math.max(0,attack_speed);
      }
      public int getAttackSpeed(){
            return this.attack_speed;
      }

      public void reduceHealth(int damage){
            this.health-=damage;
      }
      public boolean isDead(){
            if (this.getHealth()<=0){
                  return true; 
            } else {
                  return false;
            }
      }

}
