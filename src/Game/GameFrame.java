package Game;

import javax.imageio.ImageIO;
import Plant.*;
import java.util.List;
import java.util.ArrayList;

import Zombie.*;
import javax.swing.*;

import Inventory.DeckTanaman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.Objects;

import Picture.*;

import static Picture.Picture.*;

public class GameFrame extends JFrame {
    private GameManager gameManager;
    private JPanel mapPanel;
    private JLabel totalSunLabel;
    private JLayeredPane layeredPane;

    private JLabel backgroundLabel;
    private ImageIcon imageIcon;
    private int screenWidth;
    private int screenHeight;

    private DeckPanel deckPanel;
    private DeckTanaman deckTanaman;

    private final JButton[][] mapButtons = new JButton[6][9];

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
        this.deckPanel = deckPanel;
        System.out.println(deckPanel.getDeckTanaman().getArrayDeck());

        layeredPane.add(deckPanel, Integer.valueOf(1));

        // Map Panel

        initializeMapPanel();

        // new

        // Menu Button
        JButton menuButton = new JButton();
        menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUBUTTON));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(null);
        menuButton.setMargin(new Insets(0, 0, 0, 0));
        menuButton.setBounds(screenSize.width - 240, screenSize.height - 850, 242, 95);
        menuButton.addActionListener(e -> {
            gameManager.sun.resetSun();
            gameManager.stopTimer();
            // logic buat save atau kalau tidak, reset
            WelcomingFrame mainMenuFrame = new WelcomingFrame();
            mainMenuFrame.setVisible(true);
            dispose();
        });

        layeredPane.add(menuButton, Integer.valueOf(3));
        layeredPane.revalidate();
        layeredPane.repaint();

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

    // Put Plant to Map
    public void digButtonPLant(JButton plantBtn, JButton digBtn) {
        Point location = digBtn.getLocation();
        plantBtn.setLocation(location);
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
        SwingUtilities.invokeLater(this::updateBackgroundImage);
    }

    // Method naro plant card di area
    public void setPlant(JButton plantCard, JButton plant) {
        Point location = plant.getLocation();
        plantCard.setLocation(location);
    }

    // Method buat samain plant Card sama plantnya

    // Update game map every second
    public void updateRender() {
        gameManager.updateGameMap();
        System.out.println(gameManager.sun.getTotalSun());
        setTotalSun(gameManager.sun.getTotalSun());
        setMap();
        renderGameMap();
    }

    public void initializeMapPanel() {
        mapPanel = new JPanel(new GridLayout(6, 9, 2, 2));
        // mapPanel.setBackground(new Color(0, 0, 0, 0
        // mapPanel.setBackground(Color.BLACK);  
        mapPanel.setOpaque(false);
        mapPanel.setBounds(350, 350, 960, 810);
        mapPanel.setBounds((screenWidth - 800) / 2, 120, 1044, 810);
        layeredPane.add(mapPanel, Integer.valueOf(1));

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 9; col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(103, 140));
                button.setFocusPainted(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(true);
                button.setRolloverEnabled(false);
                button.setFocusable(false);
                button.setOpaque(false);
                mapPanel.add(button, BorderLayout.WEST);
                mapButtons[row][col] = button;
            }
        }

         

         
        // mapPanel.getComponent(18).setBackground(Color.red);
//            mapPanel.getComponent(35).setBackground(Color.red);
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
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(BUCKETHEADZOMBIE).getImage());
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
                // TODO: CHANGE TO GARGANTUAR
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(NEWSPAPERZOMBIECARD).getImage());
                break;
            case "Imp Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(IMPZOMBIECARD).getImage());
                break;
            case "Screen Door Zombie":
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(SCREENDOORZOMBIECARD).getImage());
                break;
            default:
                imageiconreturn = new ImageIcon(PictureFactory.getImageIcon(NORMALZOMBIECARD).getImage());
                break;

        }
        return imageiconreturn;

    }

    public void renderGameMap() {
        GameMap<Object> gameMap = gameManager.getGameMap();
        for (int row = 0; row < gameMap.getRow(); row++) {
            for (int col = 0; col < gameMap.getColumn(); col++) {
                List<Object> entities = gameMap.getEntities(row, col);
                JButton button = mapButtons[row][col];
                button.setIcon(null);
                if (!entities.isEmpty()) {
                    Object entity = entities.get(0);
                    if (entity instanceof Zombie zombie) {
                        ImageIcon imageIcon = getZombieImage(zombie);

                        Image image = imageIcon.getImage().getScaledInstance(button.getWidth(), button.getHeight(),
                                Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(image);
                        button.setIcon(imageIcon);
                    } else if (entity instanceof Plant plant) {
                        button.setBackground(Color.green);
                    } //
                    {
                        // button.setBackground(Color.green);
                        button.setIcon(null);
                    }
                }
            }
        }
    }
}