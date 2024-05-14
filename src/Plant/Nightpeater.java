package Plant;

public class Nightpeater extends Plant {
      private boolean isNight;

      public Nightpeater() {
            super("Nightpeater", 100, 25, 4, 60, -1, 10);
        }

      public boolean getIsNight(){
            return this.isNight;
      }
      
}
