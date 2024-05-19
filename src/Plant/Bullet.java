package Plant;

import Character.CharCoordinat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import Zombie.*;
import Plant.Plant;

import Character.CharCoordinat;

public class Bullet extends Element {
      private int power;
      int x, y;
      public String img;
      BufferedImage png;
      public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();

      public Bullet(int power, CharCoordinat i){
            super(i);
            this.power = power;
          
      }

      // public Bullet(int power ){
            
      //       this.power = power;
      //       initialize();

      // }


      public void attack(){

      }


      public void drawBullet(Graphics2D g2){
            // cek zombie ada ato ngga
            try {
                  png  = ImageIO.read(new File(img));
            } catch (Exception e) {

            }
            g2.drawImage(png, CharCoordinat.getAbsis(), CharCoordinat.getOrdinat(), null);
      };

      public void check_hit(){
            //ngesek klo x dan y nya si zombie dan bullet itu sama maka ngasih damage
            if (x <= Zombie.getX() && x + 115 >= Zombie.getX() && y == Zombie.getY()){
                  getAttacked(power);
            }
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
