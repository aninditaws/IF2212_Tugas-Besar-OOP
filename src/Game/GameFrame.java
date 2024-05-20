package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;

import Inventory.DeckTanaman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.CookieHandler;
import java.awt.image.BufferedImage;
import Picture.*;
import Character.Character;
import Plant.*;
import static Picture.Picture.*;

import Zombie.*;

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

    private final JButton[][] mapButtons = new JButton[6][11];

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
        initializeDigButton();

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

    public void initializeDigButton() {
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.DIGBUTTON);
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JButton shovel = new JButton(imageIcon);
        layeredPane.add(shovel, Integer.valueOf(1));
        shovel.setOpaque(false);
        shovel.setContentAreaFilled(false);
        shovel.setBorder(null);
        shovel.setBounds(50, 760, 100, 100);
        shovel.addActionListener(e -> {
            for (Component component : mapPanel.getComponents()) {
                if (component instanceof JButton) {
                    JButton button = (JButton) component;
                    button.addActionListener(e2 -> {
                        JButton clickedButton = (JButton) e2.getSource();
                        Container parent = clickedButton.getParent();
                        parent.remove(clickedButton);
                        parent.revalidate();
                        parent.repaint();
                    });
                }
            }
        });

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
        renderGameMap();
    }

    public void initializeMapPanel() {
        mapPanel = new JPanel(new GridLayout(6, 11, 2, 2));
        mapPanel.setOpaque(false);
        mapPanel.setBounds(350, 120, 960, 810);
        layeredPane.add(mapPanel, Integer.valueOf(1));

        for (int i = 0; i < 6; i++) {
            for (int z = 0; z < 11; z++) {
                JButton button = new JButton();
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                // Bisa diganti jadi false untuk menghilangkan border
                button.setBorderPainted(true);
                button.setRolloverEnabled(false);
                button.setFocusable(false);
                button.setPreferredSize(new Dimension(103, 140));

                button.addActionListener(e -> {
                    if (selectedDeckButton != null) {
                        Container parent = (Container) e.getSource();
                        System.out.println(parent);
                        JButton newButton = new JButton(selectedDeckButton.getIcon());
                        newButton.setOpaque(false);
                        newButton.setContentAreaFilled(false);
                        newButton.setBorder(null);
                        newButton.setMargin(new Insets(0, 0, 0, 0));

                        // Iterate through the grid to find the clicked button's position
                        int row = -1;
                        int column = -1;
                        Component[] components = mapPanel.getComponents();
                        for (int k = 0; k < components.length; k++) {
                            if (components[k] == button) {
                                row = k / 9; // Assuming 9 columns in the grid
                                column = k % 9;
                                break;
                            }
                        }

                        // Calculate the position based on the row and column indices
                        int x = column * button.getWidth();
                        int y = row * button.getHeight();

                        // Set the bounds of the new button
                        newButton.setBounds(x, y, button.getWidth(), button.getHeight());

                        parent.add(newButton);
                        parent.repaint();
                    }
                });

                mapPanel.add(button);
                mapButtons[i][z] = button;
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
                    } // Bisa menambahkan yang lain
                } else {
                    // button.setBackground(Color.green);
                    button.setIcon(null);
                }
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
            gameManager.stopTimer();
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