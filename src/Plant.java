public class Plant {
      // ATRIBUTE
      private String name;
      private int cost;
      private int health;
      private int attack_damage;
      private int attack_speed;   
      private int range;  
      private Stopwatch cooldown;

      /* NOTES */
      // attack_speed = tanaman meyerang dalam x detik
      // range = satuannya dalam tile. 0 artinya ga nyerang. -1 artinya bisa menyerang sepanjang jalur
      // cooldown = satuannya pake

/*KONSTRUKTOR*/
      public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, Stopwatch  cooldown) {
            this.name = name;
            this.cost = cost;
            this.health = health;
            this.attack_damage = attack_damage;
            this.attack_speed = attack_speed;
            this.range = range;
            this.cooldown = cooldown;
      }
      /*GETTER & SETTER*/      
      public void setName(String nama){this.name=nama;}
      public String getName(){return this.name;}

      // public void setCost(int harga)  {this.cost=harga;} 
      public int getCost() {return this.cost;}

      public void reduceHealth(int damage) {this.health-=damage;}
      public int getHealth() {return this.health;}

      public boolean isDead() {if (this.getHealth()<=0) return true; else return false;}

      public int getAttackDamage()  {return this.attack_damage;}

      public Stopwatch getCooldownTime() {return this.cooldown;}

      public int getAttackSpeed() {return this.attack_speed;}

      public int getRange(){return this.range;}
}
