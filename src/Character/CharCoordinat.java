package Character;

public class CharCoordinat {
      private int x, y;

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

          // public translate()
}
