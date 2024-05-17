package Game;

import javax.swing.*;

import Inventory.DeckTanaman;
import Game.InventoryFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Picture.Picture;
import Picture.PictureFactory;

public class GameFrame extends JFrame {
    private GameManager gameManager;
    private JPanel mapPanel;
    private JLabel totalSunLabel;
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private ImageIcon imageIcon;
    private int screenWidth;
    private int screenHeight;

    // private static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); //buat
    // array bullet sama tanaman
    // private static ArrayList<Plant> plants = new ArrayList<Plant>();

    public GameFrame(GameManager gameManager) {
        // Game Title & State
        setTitle("Michael vs. Lalapan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Layout
        setLayout(new BorderLayout());

        // Manager Game
        this.gameManager = gameManager;

        // Screen Size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = (int) screenSize.getWidth();
        this.screenHeight = (int) screenSize.getHeight();

        // LayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Background Map
        imageIcon = PictureFactory.getImageIcon(Picture.GAMEDAY);
        Image image = imageIcon.getImage().getScaledInstance(this.screenWidth, this.screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        // Deck Panel

        // Map Panel
        mapPanel = new JPanel(new GridLayout(6, 9, 2, 2));
        mapPanel.setOpaque(false);
        mapPanel.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(mapPanel, Integer.valueOf(1));

        // Sun Label
        totalSunLabel = new JLabel(String.valueOf(gameManager.sun.getTotalSun()));
        totalSunLabel.setFont(new Font("Yanone Kaffeesatz", Font.BOLD, 30));
        totalSunLabel.setForeground(Color.WHITE);
        totalSunLabel.setBounds(135, 52, 100, 50);
        layeredPane.add(totalSunLabel, Integer.valueOf(2));

        // Show Sun Label & Map
        add(layeredPane, BorderLayout.CENTER);

        // Update periodically
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRender();
            }
        });
        timer.start();
    }

    // Setter for totalSunLabel
    public void setTotalSun(int totalSun) {
        SwingUtilities.invokeLater(() -> totalSunLabel.setText(String.valueOf(totalSun)));
    }

    // Update Map
    public void updateBackgroundImage() {
        if (gameManager.gameTick > 100) {
            imageIcon = PictureFactory.getImageIcon(Picture.GAMENIGHT);
        } else {
            imageIcon = PictureFactory.getImageIcon(Picture.GAMEDAY);
        }
        Image image = imageIcon.getImage().getScaledInstance(this.screenWidth, this.screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        backgroundLabel.setIcon(imageIcon);
        backgroundLabel.revalidate();
        backgroundLabel.repaint();
    }

    // Setter for Map
    public void setMap() {
        SwingUtilities.invokeLater(() -> updateBackgroundImage());
    }

    // Update game map every second
    public void updateRender() {
        gameManager.updateGameMap();
        System.out.println(gameManager.sun.getTotalSun());
        setTotalSun(gameManager.sun.getTotalSun());
        setMap();
    }
}