package Plant;

public class Repeater extends Plant {
    
      private boolean isNight;

      public Repeater() {
            super("Repeater", 100, 25, 8, 200, -1, 10, "ImagePvZ/Plant/PlantzImg/Repeater.png");
        }

      public boolean getIsNight(){
            return this.isNight;
      }
      
}
