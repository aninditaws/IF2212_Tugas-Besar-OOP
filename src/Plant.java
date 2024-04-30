public class Plant extends Char {
      /*ATRIBUT*/
      private int cost; 
      private int range;  
      private Stopwatch cooldown;

      /* NOTES */
      // attack_speed = tanaman meyerang dalam x detik
      // range = satuannya dalam tile. 0 artinya ga nyerang. -1 artinya bisa menyerang sepanjang jalur
      // cooldown = satuannya pake

      /*KONSTRUKTOR*/
      public Plant(String name, int health, int attack_damage, int attack_speed,int cost, int range, Stopwatch cooldown) {
            super(name, health, attack_damage, attack_speed);
            this.cost = cost;
            this.range = range;
            this.cooldown = cooldown;
      }

      /*GETTER & SETTER*/      


      // public void setCost(int harga)  {this.cost=harga;} 
      public int getCost() {return this.cost;}


      public Stopwatch getCooldownTime() {return this.cooldown;}


      public int getRange(){return this.range;}


      /* METHOD */
      public void shoot(){}

}
