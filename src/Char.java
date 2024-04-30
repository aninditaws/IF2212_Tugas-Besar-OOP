

public class Char {
      public String name;
      public int health;
      public int attack_damage;
      public int attack_speed;

public Char(String name, int health, int attack_damage, int attack_speed){
      this.name = name;
      this.health = health;
      this.attack_damage = attack_damage;
      this.attack_speed = attack_speed;
}

      public void setName(String nama){this.name=nama;}
      public String getName(){return this.name;}

      public void reduceHealth(int damage) {this.health-=damage;}
      public int getHealth() {return this.health;}

      public boolean isDead() {if (this.getHealth()<=0) return true; else return false;}
      public int getAttackDamage()  {return this.attack_damage;}
      public int getAttackSpeed() {return this.attack_speed;}

}
