package Plant;


import javax.swing.ImageIcon;

import Character.CharCoordinat;

public class Bullet extends Element {
      private int power;

      public Bullet(int power, CharCoordinat i){
            super(i);
            this.power = power;

            

      }

      public Bullet(int power, int x, int y){
            super(x, y);
            this.power = power;
            initialize();

      }

      // public void initialize() {
	// 	ImageIcon imageIcon =  ImageFactory.createImage(Image.PEASHOOTER_BULLET);
	// 	setImageIcon(imageIcon);

	// }



      public int getPower(){
            return power;
      }

      public void setPower(int power){
            this.power = power;
          }

      // public void update();

      // public void move();





      
}
