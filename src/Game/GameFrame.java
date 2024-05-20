package Game;

import javax.imageio.ImageIO;
import javax.swing.*;

import Inventory.DeckTanaman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.CookieHandler;
import java.awt.image.BufferedImage;
import Picture.*;

public class GameFrame extends JFrame {
    private GameManager gameManager;
    private JPanel mapPanel;
    private JLabel totalSunLabel;
    private JLayeredPane layeredPane;

    private Dimension screenSize;

    private JLabel backgroundLabel;
    private ImageIcon imageIcon;
    private int screenWidth;
    private int screenHeight;

    private DeckPanel deckPanel;
    private JButton selectedDeckButton;
    private DeckTanaman deckTanaman;

    // private static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); //buat
    // array bullet sama tanaman
    // private static ArrayList<Plant> plants = new ArrayList<Plant>();

    public GameFrame(GameManager gameManager, DeckPanel deckPanel) {
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
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.screenWidth = (int) screenSize.getWidth();
        this.screenHeight = (int) screenSize.getHeight();

        // LayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Background Map
        initializeBackgroundImage();

        // Deck Panel
        this.deckPanel = deckPanel;
        initializeDeckButtons();

        layeredPane.add(deckPanel, Integer.valueOf(1));

        // Map Panel
        initializeMapPanel();

        initializeMenuButton();
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

    public void initializeBackgroundImage() {
        imageIcon = PictureFactory.getImageIcon(Picture.GAMEDAY);
        Image image = imageIcon.getImage().getScaledInstance(this.screenWidth, this.screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
    }

    public void initializeDeckButtons() {
        for (Component component : deckPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addActionListener(e -> {
                    selectedDeckButton = button;
                });
            }
        }
    }

    // Put Plant to Map
    public void digButtonPLant(JButton plantBtn, JButton digBtn) {
        Point location = digBtn.getLocation();
        plantBtn.setLocation(location);
    }

    // Setter for totalSunLabel3
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

    // Method naro plant card di area
    public void setPlant(JButton plantCard, JButton plant) {
        Point location = plant.getLocation();
        plantCard.setLocation(location);
    }

    // Update game map every second
    public void updateRender() {
        gameManager.updateGameMap();
        System.out.println(gameManager.sun.getTotalSun());
        setTotalSun(gameManager.sun.getTotalSun());
        setMap();
    }

    public void initializeMapPanel() {
        mapPanel = new JPanel(new GridLayout(6, 9, 2, 2));
        mapPanel.setOpaque(false);
        mapPanel.setBounds(350, 120, 960, 810);
        layeredPane.add(mapPanel, Integer.valueOf(1));

        for (int i = 0; i < 6; i++) {
            for (int z = 0; z < 9; z++) {
                JButton button = new JButton();
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorder(null);
                button.setPreferredSize(new Dimension(103, 140));

                button.addActionListener(e -> {
                    if (selectedDeckButton != null) {
                        JButton newButton = new JButton(selectedDeckButton.getIcon());
                        newButton.setOpaque(false);
                        newButton.setContentAreaFilled(false);
                        newButton.setBorder(null);
                        newButton.setMargin(new Insets(0, 0, 0, 0));
                        // newButton.setBounds(button.getX(), button.getY(), 103, 140);
                        ((Container) e.getSource()).add(newButton);
                        ((Container) e.getSource()).revalidate();
                        ((Container) e.getSource()).repaint();
                    }
                    System.out.println("Clicked Button GETX: " + button.getX());
                    System.out.println("Clicked Button GETY: " + button.getY());
                });

                mapPanel.add(button);
            }
        }
    }

    // public JButton getAreaButton(int row, int column) {
    // // Calculate the index of the button based on the row and column
    // int index = row * 9 + column;

    // // Get the component at the calculated index
    // Component component = mapPanel.getComponent(index);

    // // Check if the component is a JButton
    // if (component instanceof JButton) {
    // return (JButton) component;
    // } else {
    // // If the component is not a JButton, return null
    // return null;
    // }
    // }

    public void initializeMenuButton() {
        JButton menuButton = new JButton();
        menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUBUTTON));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(null);
        menuButton.setMargin(new Insets(0, 0, 0, 0));
        menuButton.setBounds(screenSize.width - 240, screenSize.height - 850, 242, 95);
        menuButton.addActionListener(e -> {
            WelcomingFrame mainMenuFrame = new WelcomingFrame();
            mainMenuFrame.setVisible(true);
            dispose();
        });

        layeredPane.add(menuButton, Integer.valueOf(3));
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public void WaterConstraint() {

    }
}