package Plant.Bullets;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;

import Game.GameMap;
import Picture.Picture;
import Picture.PictureFactory;
import Character.Character;
import Subscriber.EventChannel;
import Zombie.Zombie;

public class Bullet extends Character {

    public boolean slow = false;

    public Bullet(Point position, int damage, boolean slow) {
        super("Bullet", 100, damage, 0);
        this.position = position;
        this.slow = slow;
        EventChannel.getInstance().subscribe(this);
    }

    public Point getPosition() {
        return position;
    }

    public int getDamage() {
        return attack_damage;
    }

//    public int getSpeed() {
//        return speed;
//    }

    public void move() {
        int finalX = (position.x + 1);
        if (finalX > 10 || finalX < 0) {
            dead = true;
        } else {
            System.out.println(String.format("Bullet moved from %d, %d to %d, %d", position.x, position.y, finalX, position.y));
            position.x = finalX;
        }
    }

    public void attack(GameMap<Object> gameMap) {
        List<Object> zombies = gameMap.getEntities(position.y, position.x).stream().filter(entity -> entity instanceof Zombie).collect(Collectors.toList());
        if (!zombies.isEmpty()) {
            ((Zombie) zombies.get(0)).getAttacked(attack_damage);
            if (slow) {
                ((Zombie) zombies.get(0)).getSlowed();
            }
            dead = true;
        }
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

    @Override
    public void update(int gameTick) {
        super.update(gameTick);
        move();
    }
}