package Game;

import javax.swing.*;

import Picture.Picture;
import Picture.PictureFactory;

import java.awt.*;
import java.util.List;

public class GameFrame extends JFrame {
    private GameManager gameManager;
    private JPanel mapPanel;
    private JLabel totalSunLabel;
    private JLayeredPane layeredPane;
    // private static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); //buat
    // array bullet sama tanaman
    // private static ArrayList<Plant> plants = new ArrayList<Plant>();

    public GameFrame(GameManager gameManager) {
        // Game Title & State 
        setTitle("Michael vs. Lalapan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Manager Game
        this.gameManager = gameManager;

        // Screen Size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // LayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Map Panel
        mapPanel = new JPanel(new GridLayout(6, 9, 2, 2));
        mapPanel.setOpaque(false);
        mapPanel.setBounds(0, 0, screenWidth, screenHeight);;
        layeredPane.add(mapPanel, Integer.valueOf(1));

        // Background Map
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.GAMEDAY);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane .add(label, Integer.valueOf(0));

        // Menampilkan Sun
        totalSunLabel = new JLabel(String.valueOf(gameManager.sun.getTotalSun()));
        totalSunLabel.setFont(new Font("Yanone Kaffeesatz", Font.BOLD, 24));
        totalSunLabel.setForeground(Color.WHITE);
        totalSunLabel.setBounds(50, 50, 100, 50);
        layeredPane.add(totalSunLabel, Integer.valueOf(2));

        add(layeredPane, BorderLayout.CENTER); 
    }

    private void initializeMap() {
        for (int i = 0; i < gameManager.getGameMap().getRow(); i++) {
            for (int j = 0; j < gameManager.getGameMap().getColumn(); j++) {
                Area<Object> area = gameManager.getGameMap().getArea(i, j);
                JPanel areaPanel = new JPanel();
                areaPanel.setBorder(BorderFactory.createLineBorder(Color.black));

                if (area != null) {
                    areaPanel.setBackground(getColorForAreaType(area.getType()));

                    List<Object> entities = area.getEntities();
                    if (!entities.isEmpty()) {
                        JLabel entityLabel = new JLabel(String.valueOf(entities.size()));
                        areaPanel.add(entityLabel);
                    }
                } else {
                    areaPanel.setBackground(Color.WHITE);
                }

                mapPanel.add(areaPanel);
            }
        }
    }

    private Color getColorForAreaType(AreaType type) {
        switch (type) {
            case PROTECTED_AREA:
                return Color.RED;

            case PLANTABLE_AREA:
                return Color.GREEN;
            case WATER_AREA:
                return Color.CYAN;
            case ZOMBIE_SPAWN_GROUND:
                return Color.GRAY;
            case ZOMBIE_SPAWN_WATER:
                return Color.GRAY;
            default:
                return Color.WHITE;
        }
    }

    public void updateRender() {
        // Fungsi untuk update game map setiap detik saat game dijalankan
        gameManager.updateGameMap();
    }

    // public void draw(){
    // for (int )
    // }
}
