package Game;
import Picture.PictureFactory;
import PlantFactory.PlantFactory;
import Zombie.*;
import Plant.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

import static Picture.Picture.*;

public class GameDrawingPanel extends JPanel {
    private GameManager gameManager;

    public GameDrawingPanel(GameManager gameManager) {
        this.gameManager = gameManager;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameMap<Object> gameMap = gameManager.getGameMap();
        int cellWidth = getWidth() / gameMap.getColumn();
        int cellHeight = getHeight() / gameMap.getRow();

        for (int row = 0; row < gameMap.getRow(); row++) {
            for (int col = 0; col < gameMap.getColumn(); col++) {
                List<Object> entities = gameMap.getEntities(row, col);
                for (Object entity : entities) {
                    if (entity instanceof Zombie zombie) {
                        ImageIcon imageIcon = getZombieImage(zombie);
                        Image image = imageIcon.getImage();
                        int x = (int) (col * cellWidth);
                        int y = (int) (row * cellHeight);
                        g.drawImage(image, x, y, cellWidth, cellHeight, null);
                    } else if (entity instanceof Plant plant) {
                        ImageIcon imageIcon = getPlantImage(plant);
                        Image image = imageIcon.getImage();
                        int x = (int) (col * cellWidth + 0.25 * cellWidth);
                        int y = (int) (row * cellHeight + 0.15 * cellHeight);
                        if (entity instanceof Lilypad) {
                            y += (int) (0.2 * cellHeight);
                        }
                        g.drawImage(image, x, y, (int) (cellWidth * 0.6), (int) (cellHeight * 0.6), null);
                    }
                }
            }
        }
    }

    private ImageIcon getZombieImage(Zombie zombie) {
        ImageIcon imageiconreturn;
        switch (zombie.name) {
            case "Normal Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(NORMALZOMBIECARD).getImage());
                break;
            case "Conehead Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(CONEHEADZOMBIECARD).getImage());
                break;
            case "Pole Vaulting Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(POLEVAULTINGZOMBIECARD).getImage());
                break;
            case "Buckethead Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(BUCKETHEADZOMBIECARD).getImage());
                break;
            case "Ducky Tube Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(DUCKYTUBEZOMBIECARD).getImage());
                break;
            case "Dolphin Rider Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(DOLPHINERIDERZOMBIECARD).getImage());
                break;
            case "Football Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(FOOTBALLZOMBIECARD).getImage());
                break;
            case "Gargantuar":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(GARGANTUARZOMBIECARD).getImage());
                break;
            case "Imp Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(IMPZOMBIECARD).getImage());
                break;
            case "Screen Door Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(SCREENDOORZOMBIECARD).getImage());
                break;
            default:
                System.out.println(String.format("Default case! %s", zombie.name));
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(NORMALZOMBIECARD).getImage());
                break;

        }
        return imageiconreturn;
    }

    private ImageIcon getPlantImage(Plant plant) {
        ImageIcon imageiconreturn;
        PlantFactory plantFactory = new PlantFactory();
        switch (plantFactory.getPlantType(plant)) {
            case SUNFLOWERTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(SUNFLOWER).getImage());
                break;
            case CHERRYBOMBTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(CHERRYBOMB).getImage());
                break;
            case JALAPENOTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(JALAPENO).getImage());
                break;
            case LILYPADTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(LILY_PAD).getImage());
                break;
            case PEASHOOTERTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(PEASHOOTER).getImage());
                break;
            case REPEATERTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(REPEATER).getImage());
                break;
            case SNOWPEATYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(SNOWPEA).getImage());
                break;
            case SQUASHTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(SQUASH).getImage());
                break;
            case TALLNUTTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(TALLNUT).getImage());
                break;
            case WALLNUTTYPE:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(WALLNUT).getImage());
                break;
            default:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(SUNFLOWER).getImage());
                break;
        }
        return imageiconreturn;
    }
}