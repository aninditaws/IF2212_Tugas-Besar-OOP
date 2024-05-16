package Plant;

public class Nightpeater extends Plant {
      private boolean isNight;

      public Nightpeater(int x, int y) {
            super("Nightpeater", 100, 25, 4, 60, -1, 10, x, y);
        }

      public boolean getIsNight(){
            return this.isNight;
      }
      
}
