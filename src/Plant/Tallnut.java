package Plant;

public class Tallnut extends Plant{
      private boolean blocked;


      public Tallnut() {
            super("Tall-nut", 2000, 0, 0, 125, 0, 20, "ImagePvZ/Plant/PlantzImg/Wallnut.png");
        }

      public boolean blocked(){
            return blocked;
      }

}
