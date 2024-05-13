package Plant;

public class Lilypad extends Plant {
      private boolean planted;      

      public Lilypad(String name, int health, int attack_damage, int attack_speed, int cost, int range, int cooldown) {
            super(name, health, attack_damage, attack_speed, cost, range, cooldown);
        }

      public boolean getPlanted(){
            return this.planted;
      }  

      public void is_it_planted(Plant plant) {
            if (!planted && plant instanceof Lilypad) { // Jika lilypad belum terpasang tanaman dan yang akan ditanam adalah lilypad
                System.out.println(plant.getName() + " ditanam di " + this.getName() + "pada baris dan kolom"); // Menanam tanaman di atas lilypad
                planted = true; // Menandakan bahwa lilypad sudah terpasang tanaman
            } else {
                System.out.println("Cannot plant " + plant.getName() + " on " + this.getName() + ", only Lilypad allowed."); // Jika lilypad sudah terpasang tanaman atau yang akan ditanam bukan lilypad
            }
        }

      public void removePlant() {
            if (planted) { // Jika lilypad sudah terpasang tanaman
                System.out.println("Plant removed from " + this.getName()); // Mencopot tanaman dari lilypad
                planted = false; // Menandakan bahwa lilypad sudah tidak terpasang tanaman lagi
            } else {
                System.out.println("No plant to remove from " + this.getName()); // Jika lilypad belum terpasang tanaman
            }
        }
}
