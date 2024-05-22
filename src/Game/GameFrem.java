package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameFrem extends JFrame {
    private Dimension screenSize;
    private JLayeredPane layeredPane;

    public GameFrem() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenSize = new Dimension(818, 840);
        setTitle("Plants vs Zombies");
        setSize(screenSize);
        setLayout(new BorderLayout());

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);
        layeredPane.setLayout(null); // Use null layout to control the positioning and size manually

        // Background map
        initializeBackground();

        add(layeredPane, BorderLayout.CENTER);
        pack(); // Adjust the JFrame to fit the preferred size of its components
    }

    public void initializeBackground() {
        try {
            BufferedImage image = ImageIO.read(new File("ImagePvZ/GameFrame/gameFrame.png"));
            Image scaledImage = image.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(imageIcon);
            label.setBounds(0, 0, screenSize.width, screenSize.height); // Set the label size to match the frame size

            layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrem frame = new GameFrem();
            frame.setVisible(true);
        });
    }
}
