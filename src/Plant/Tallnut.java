package Plant;

public class Tallnut extends Plant{
      private boolean blocked;


      public Tallnut(int x, int y) {
            super("Tall-nut", 2000, 0, 0, 125, 0, 20, x, y);
        }

      public boolean blocked(){
            return blocked;
      }

}
