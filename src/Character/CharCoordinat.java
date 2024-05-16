package Character;

public class CharCoordinat {
      private int x, y;

      public CharCoordinat(){
        this.x = 0;
        this.y = 0;
      }
      
      public CharCoordinat(int x, int y){
            this.x = x;
            this.y = y;
      }

      //getter & setter

      public int getAbsis() {
            return x;
          }
      
          public int getOrdinat() {
            return y;
          }
      
          public void setAbsis(int x) {
            this.x = x;
          }
      
          public void setOrdinat(int y) {
            this.y = y;
          }
          //bergerak sejauh x dan y
          public void translate(int x, int y){
            this.x += x;
            this.y += y;
          }
          
          //jarak antara titik sekarang dengan BoardPoint argumen
          public double distance(CharCoordinat p) {
            return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
          }
        
        // Menghasilkan true jika posisi sama dengan CharCoordinat argumen
        public boolean equals(CharCoordinat p) {
          return this.x == p.x && this.y == p.y;
        }
        
          // Menuliskan titik ke layar dengan format "(x,y)"
          public void print() {
            System.out.println("(" + this.x + "," + this.y + ")");
          }
}
