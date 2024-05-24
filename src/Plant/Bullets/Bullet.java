package Plant.Bullets;

import java.awt.*;

import javax.swing.ImageIcon;

import Picture.Picture;
import Picture.PictureFactory;

public class Bullet {
    private Point position;
    private int speed;
    private int damage;

    public Bullet(Point position, int speed, int damage) {
        this.position = position;
        this.speed = speed;
        this.damage = damage;
    }

    public Point getPosition() {
        return position;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void updatePosition() {
        position.x += speed;
    }

    public boolean isOutOfBounds(int width) {
        return position.x > width;
    }

    public void draw(Graphics2D g2) {
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.BULLET);
        Image image = imageIcon.getImage();
        g2.drawImage(image, position.x, position.y, null);
        // System.out.println("Drawing bullet at: " + position.x + " " + position.y);
    }

    public Image getPeaPath() {

        return PictureFactory.getImageIcon(Picture.BULLET).getImage();

    }

    public Image getsnowPath() {

        return PictureFactory.getImageIcon(Picture.SLOWBULLET).getImage();

    }
}