package Plant;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.io.File;
import Zombie.*;
import Plant.Plant;

import Character.CharCoordinat;

public class Bullet extends Element {
      public static int power;
      int x, y;
      public String img;
      BufferedImage png;

      public Bullet(int power, CharCoordinat i){
            super(i);
            this.power = power;
            initialize();

            

      }

      // public Bullet(int power ){
            
      //       this.power = power;
      //       initialize();

      // }

      public void initialize() {
		try {
                  png = ImageIO.read(new File(img));
            } catch (Exception e) {
                  // TODO: handle exception
            }
            //tambahan buat letakkin image sesuai grid buttonnya


	}

      public void attack(){

      }





      public int getPower(){
            return power;
      }

      public void setPower(int power){
            this.power = power;
          }

      // public void update();

      // public void move();


//actionperformed() dibuat 


      
}
