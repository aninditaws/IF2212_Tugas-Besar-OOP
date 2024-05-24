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

import PlantFactory.PlantFactory;
import PlantFactory.PlantType;
import Subscriber.EventChannel;
import UI.DeckButton;
import Zombie.*;

public class GameFrem extends JFrame {
    private GameManager gameManager;
    private JPanel mapPanel;
    private boolean stopgame = false;
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

    private DeckButton[] deckButtons;

    private GameDrawingPanel drawingPanel;

    private final JButton[][] mapButtons = new JButton[6][11];

    private PlantType selectedPlant = null;
    private Integer indexSelectedPlant = null;

    private boolean isDigging = false;
    private JLabel flag;

    private JButton shovel;

    // private static ArrayList<Bullet> bullets = new ArrayList<Bullet>(); //buat
    // array bullet sama tanaman
    // private static ArrayList<Plant> plants = new ArrayList<Plant>();

    public GameFrem(GameManager gameManager, DeckPanel deckPanel) {
        // Game Title & State
        // Screen Size
        // screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize = new Dimension(1240, 750);
        this.screenWidth = (int) screenSize.getWidth();
        this.screenHeight = (int) screenSize.getHeight();

        setTitle("Michael vs. Lalapan");
        setSize(1240, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Layout
        setLayout(new BorderLayout());

        // Manager Game
        this.gameManager = gameManager;

        // LayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Background Map
        initializeBackgroundImage();

        // Deck Panel
        this.deckPanel = deckPanel;
        deckPanel.setPreferredSize(new Dimension(128, 500));
        deckPanel.setOpaque(false);
        deckPanel.setBackground(new Color(23, 122, 22, 0));
        deckPanel.setLayout(new GridLayout(6, 1, 15, 0));
        deckPanel.setBounds(30, 118, 128, 509); // Then set the bounds
        deckPanel.revalidate();
        deckPanel.repaint();

        // Set the background color for each component in the deckPanel
        Component[] components = deckPanel.getComponents();
        for (Component component : components) {
            component.setBackground(new Color(23, 122, 22, 0));
        }

        deckPanel.disableAllButtonFunctionality();
        deckButtons = new DeckButton[deckPanel.getDeckTanaman().getMaxDeckSize()];
        initializeDeckButtons();
        initializeDigButton();

        layeredPane.add(deckPanel, Integer.valueOf(1));

        // // Map Panel
        initializeMapPanel();
        initializeDrawingPanel();

        // Flag
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.FLAG);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        flag = new JLabel(new ImageIcon(image));
        flag.setBounds(0, 0, image.getWidth(flag), image.getHeight(flag));

        // Menu Button
        JButton menuButton = new JButton();
        menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUBUTTON));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(null);
        menuButton.setMargin(new Insets(0, 0, 0, 0));
        menuButton.setBounds(screenSize.width - 200, screenSize.height - 745, 140, 60);
        menuButton.addActionListener(e -> {
            gameManager.sun.resetSun();
            gameManager.stopTimer();
            gameManager.stopGame();
            stopgame = true;
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
        totalSunLabel.setBounds(100, 43, 100, 50);
        layeredPane.add(totalSunLabel, Integer.valueOf(2));

        // // Show Sun Label & Map
        add(layeredPane, BorderLayout.CENTER);

        // Update periodically
        Timer timer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRender();
            }
        });
        timer.start();
        stopgame = false;
    }

    public void initializeBackgroundImage() {
        imageIcon = PictureFactory.getImageIcon(Picture.GAMEDAY);
        Image image = imageIcon.getImage();

        // Calculate aspect ratio
        double imageAspectRatio = (double) image.getWidth(null) / image.getHeight(null);
        double screenAspectRatio = (double) screenWidth / screenHeight;

        int newWidth;
        int newHeight;

        // Scale image according to aspect ratio
        if (imageAspectRatio > screenAspectRatio) {
            newWidth = screenWidth;
            newHeight = (int) (screenWidth / imageAspectRatio);
        } else {
            newWidth = (int) (screenHeight * imageAspectRatio);
            newHeight = screenHeight;
        }

        // Scale the image to fit the screen size while maintaining aspect ratio
        Image scaledImage = image.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        backgroundLabel = new JLabel(imageIcon);

        // Center the image on the screen
        // backgroundLabel.setBounds((screenWidth - newWidth) / 2, (screenHeight -
        // newHeight) / 2, newWidth, newHeight);
        backgroundLabel.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        backgroundLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.setVerticalAlignment(JLabel.CENTER);

        layeredPane.add(backgroundLabel, Integer.valueOf(0));
    }

    public void initializeDeckButtons() {
        int index = 0;
        for (Component component : deckPanel.getComponents()) {
            if (component instanceof JButton) {
                DeckButton button = (DeckButton) component;
                deckButtons[index] = button;
                int finalIndex = index;
                button.addActionListener(e -> {
                    if (selectedPlant != null) {
                        if (indexSelectedPlant == finalIndex) {
                            selectedPlant = null;
                            indexSelectedPlant = null;
                            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                        } else {
                            deckButtons[indexSelectedPlant].setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                            indexSelectedPlant = finalIndex;
                            selectedPlant = new PlantFactory()
                                    .getPlantType(deckPanel.getDeckTanaman().getArrayDeck().get(indexSelectedPlant));
                            System.out.println(String.format("Selected deck index %d plant type %s", indexSelectedPlant,
                                    selectedPlant.toString()));
                            button.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                        }
                    } else if (!isDigging) {
                        indexSelectedPlant = finalIndex;
                        selectedPlant = new PlantFactory()
                                .getPlantType(deckPanel.getDeckTanaman().getArrayDeck().get(indexSelectedPlant));
                        System.out.println(String.format("Selected deck index %d plant type %s", indexSelectedPlant,
                                selectedPlant.toString()));
                        button.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    }
                });
            }
            index += 1;
        }
    }

    public void initializeDigButton() {
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.DIGBUTTON);
        Image image = imageIcon.getImage().getScaledInstance(82, 82, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        shovel = new JButton(imageIcon);
        layeredPane.add(shovel, Integer.valueOf(1));
        shovel.setOpaque(false);
        shovel.setContentAreaFilled(false);
        shovel.setBorder(null);
        shovel.setBounds((int) (screenWidth * 0.15), (int) (screenHeight * 0.03), 82,
                82);
        shovel.addActionListener(e -> {
            if (selectedPlant == null) {
                isDigging = !isDigging;
                if (isDigging) {
                    shovel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    shovel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                }
            }
        });

    }

    // Put Plant to Map

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

    // Update game map every second
    public void updateRender() {
        // System.out.println(gameManager.sun.getTotalSun());
        setTotalSun(gameManager.sun.getTotalSun());
        updateGameDeckCooldown();
        setMap();
        renderGameMap();
        renderFlag();
        // Check win/lose
        if (stopgame) return;
        int condition = gameManager.checkEndCondition();
        if (condition == 0) {
            // lose
            System.out.println("GAME END! YOU LOSE");
            ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.LOSEGAME);
            Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
            JLabel loseimage = new JLabel(new ImageIcon(image));
            loseimage.setBounds(0, 0, image.getWidth(loseimage), image.getHeight(loseimage));
            layeredPane.add(loseimage, Integer.valueOf(3));
            gameManager.stopTimer();

            JButton loseButton = new JButton();
            loseButton.setIcon(PictureFactory.getImageIcon(Picture.LOSE));
            loseButton.setOpaque(false);
            loseButton.setContentAreaFilled(false);
            loseButton.setBorder(null);
            loseButton.setSize(530, 75);
            loseButton.setLocation((1240 - 650) / 2,635);
            loseButton.setMargin(new Insets(0, 0, 0, 0));

            loseButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    WelcomingFrame frame = new WelcomingFrame();
                    frame.setVisible(true);
                    dispose();
                }
            });

        } else if (condition == 2) {
            // win
            System.out.println("CONGRATULATIONS! YOU WIN");
            ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.WINGAME);
            Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
            JLabel winimage = new JLabel(new ImageIcon(image));
            winimage.setBounds(0, 0, image.getWidth(winimage), image.getHeight(winimage));
            layeredPane.add(winimage, Integer.valueOf(3));
            gameManager.stopTimer();

            JButton winButton = new JButton();
            winButton.setIcon(PictureFactory.getImageIcon(Picture.WIN));
            winButton.setOpaque(false);
            winButton.setContentAreaFilled(false);
            winButton.setBorder(null);
            winButton.setSize(530, 75);
            winButton.setLocation((1240 - 650) / 2,635);
            winButton.setMargin(new Insets(0, 0, 0, 0));

            winButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    WelcomingFrame frame = new WelcomingFrame();
                    frame.setVisible(true);
                    dispose();
                }
            });

        }
        repaint();
    }

    public void initializeMapPanel() {
        mapPanel = new JPanel(new GridLayout(6, 11, 0, 0));
        mapPanel.setOpaque(false);
        mapPanel.setBackground(new Color(255, 255, 255, 255));
        mapPanel.setBounds((int) (screenWidth * 0.174), (int) (screenHeight * 0.15), 1000, 612);

        layeredPane.add(mapPanel, Integer.valueOf(1));

        for (int i = 0; i < 6; i++) {
            for (int z = 0; z < 11; z++) {
                JButton button = new JButton();
                // button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                // Bisa diganti jadi false untuk menghilangkan border
                button.setBorderPainted(false);
                // button.setRolloverEnabled(false);
                // button.setFocusable(false);
                button.setPreferredSize(new Dimension(70, 70));
                int row = i;
                int col = z;
                PlantFactory plantFactory = new PlantFactory();
                button.addActionListener(e -> {
                    if (isDigging) {
                        if (!gameManager.getGameMap().getEntities(row, col).isEmpty() && gameManager.getGameMap().getEntities(row, col).get(gameManager.getGameMap().getEntities(row, col).size() - 1) instanceof Plant) {
                            gameManager.getGameMap().removeEntity(row, col,
                                    gameManager.getGameMap().getEntities(row, col).size() - 1);
                            isDigging = !isDigging;
                            if (isDigging) {
                                shovel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                            } else {
                                shovel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                            }
                        }
                    }
                    if (selectedPlant != null) {
                        boolean isOnCooldown = deckPanel.getDeckTanaman().isOnCooldown(indexSelectedPlant);
                        if (!isOnCooldown) {
                            System.out.println(String.format("Planting at row %d col %d", row, col));
                            Plant plant = plantFactory.CreatePlant(selectedPlant, new Point(col, row));
                            boolean success = gameManager.addPlant(plant, row, col);
                            if (success) {
                                // Berhasil menanam, set selected plant nya null dan mulai cooldown, logic
                                // mengurangi sun ada di gameManager
                                plant.bePlanted();
                                deckPanel.getDeckTanaman().usePlant(indexSelectedPlant);
                                deckButtons[indexSelectedPlant]
                                        .setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                                selectedPlant = null;
                                indexSelectedPlant = null;
                            }
                        }
                    }
                });
                mapPanel.add(button);
                mapButtons[i][z] = button;
            }
        }
    }

    public void initializeDrawingPanel() {
        drawingPanel = new GameDrawingPanel(gameManager);
        // drawingPanel.setBounds((int) (screenWidth * 0.2), (int) (screenHeight *
        // 0.15), (int) (screenWidth * 0.75),
        // (int) (screenHeight * 0.75));
        drawingPanel.setBounds((int) (screenWidth * 0.174), (int) (screenHeight * 0.15), 1000, 612);
        layeredPane.add(drawingPanel, Integer.valueOf(1)); // Add the drawing panel below the buttons
    }

    public void renderGameMap() {
        drawingPanel.repaint();
    }

    public void renderFlag() {
        if (gameManager.isFlag()) {
            ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.FLAG);
            Image image = imageIcon.getImage().getScaledInstance((int) (screenWidth * 0.5), (int) (screenHeight * 0.3),
                    Image.SCALE_SMOOTH);
            JLabel flag = new JLabel(new ImageIcon(image));
            flag.setBounds((int) (screenWidth * 0.3), (int) (screenHeight * 0.33), image.getWidth(flag),
                    image.getHeight(flag));
            layeredPane.add(flag, Integer.valueOf(5));
        } else {
            if (layeredPane.getComponentCountInLayer(5) != 0) {
                Component[] components = layeredPane.getComponentsInLayer(5);
                for (Component component : components) {
                    layeredPane.remove(component);
                }
                // Revalidate and repaint the layeredPane to reflect changes
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        }
    }

    public void updateGameDeckCooldown() {
        for (int i = 0; i < deckButtons.length; i++) {
            if (deckPanel.getDeckTanaman().cooldownList[i] > 0) {
                deckButtons[i].isCooldown = true;
            } else {
                deckButtons[i].isCooldown = false;
            }
            deckButtons[i].repaint();
        }
    }
}