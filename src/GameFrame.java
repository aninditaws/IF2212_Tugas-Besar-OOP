import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameFrame extends JFrame {
    private GameMap<Area> gameMap; // Gunakan GameMap dengan tipe Area
    private JPanel mapPanel;

    public GameFrame() {
        setTitle("Michael vs. Lalapan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameMap = new GameMap<>(9, 6); // Initialize dengan lebar dan tinggi
        mapPanel = new JPanel(new GridLayout(6, 9, 2, 2));
        initializeMap();

        add(mapPanel, BorderLayout.CENTER);
    }

    private void initializeMap() {
        for (int i = 0; i < gameMap.getRow(); i++) {
            for (int j = 0; j < gameMap.getColumn(); j++) {
                List<Area> areas = gameMap.getEntities(i, j);
                JPanel areaPanel = new JPanel();
                areaPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                if (!areas.isEmpty()) {
                    areaPanel.setBackground(getColorForAreaType(areas.get(0).getType()));
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
                return Color.BLUE;
            case ZOMBIE_SPAWN:
                return Color.GRAY;
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });
    }
}
