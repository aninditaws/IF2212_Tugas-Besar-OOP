package Game;

import javax.swing.*;
import java.awt.*;

public class GameGrid extends JFrame {
    private JLayeredPane layeredPane;
    private JLabel label;
    private ImageIcon imageIcon;
    Dimension screenSize;

    public GameGrid() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Declare size of screen
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Setup the layered pane to manage the background and other components
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Load and set the background image
        try {
            imageIcon = new ImageIcon("/ImagePvZ/GameFrame/gameFrame.png");
            Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            System.out.println(imageIcon);

            label = new JLabel(imageIcon);
            label.setBounds(0, 0, screenWidth, screenHeight);
            layeredPane.add(label, Integer.valueOf(0));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load background image.");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameGrid());
        GameGrid frame = new GameGrid();
        frame.setVisible(true);
    }
}