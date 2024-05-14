package Game;

import javax.swing.*;

import java.awt.*;
import java.util.List;

public class GameFrame extends JFrame {
    private GameManager gameManager;
    private JPanel mapPanel;
    // private static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); //buat array bullet sama tanaman
    // private static ArrayList<Plant> plants = new ArrayList<Plant>();

    public GameFrame(GameManager gameManager) {
        setTitle("Michael vs. Lalapan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.gameManager = gameManager;

        mapPanel = new JPanel(new GridLayout(6, 9, 2, 2));
        initializeMap();

        add(mapPanel, BorderLayout.CENTER);
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
        gameManager.getGameMap().updateGameMap();
    }

    // public void draw(){
    //     for (int )
    // }
}
