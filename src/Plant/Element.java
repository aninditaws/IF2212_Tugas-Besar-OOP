package Plant;

import javax.swing.ImageIcon;

import Character.CharCoordinat;

public abstract class Element {
      private CharCoordinat origin;
      private ImageIcon elmtIcon;

      public Element(CharCoordinat origin){
            this.origin = origin;
      }

      public Element(int x, int y){
            CharCoordinat point = new CharCoordinat(x,y);
            this.origin = point;
            
        }

      public CharCoordinat getOrigin(){
	      CharCoordinat o = new CharCoordinat(0,0);
	      o.setAbsis(origin.getAbsis());
	      o.setOrdinat(origin.getOrdinat());
            return o;
    }

       public void setOrigin(CharCoordinat CharCoordinat){
            origin.setAbsis(CharCoordinat.getAbsis());
            origin.setOrdinat(CharCoordinat.getOrdinat());
  }
}
