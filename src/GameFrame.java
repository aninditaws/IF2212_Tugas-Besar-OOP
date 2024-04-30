import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GameMap gameMap;
    private JPanel mapPanel;

    public GameFrame() {
        setTitle("Michael vs. Lalapan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameMap = new GameMap();
        mapPanel = new JPanel(new GridLayout(6, 9, 2, 2));
        initializeMap();
        
        add(mapPanel, BorderLayout.CENTER);
    }

    private void initializeMap() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                Area area = gameMap.getArea(i, j);
                JPanel AreaPanel = new JPanel();
                AreaPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                AreaPanel.setBackground(getColorForAreaType(area.getType()));
                mapPanel.add(AreaPanel);
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
