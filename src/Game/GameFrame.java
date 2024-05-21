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

    private GameDrawingPanel drawingPanel;

    private final JButton[][] mapButtons = new JButton[6][11];

    private PlantType selectedPlant = null;
    private int indexSelectedPlant;

    private boolean isDigging = false;

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
        initializeDrawingPanel();

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
        Timer timer = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRender();
            }
        });
        timer.start();
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
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        backgroundLabel = new JLabel(imageIcon);

        // Center the image on the screen
        backgroundLabel.setBounds((screenWidth - newWidth) / 2, (screenHeight - newHeight) / 2, newWidth, newHeight);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
    }

    public void initializeDeckButtons() {
        int index = 0;
        for (Component component : deckPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                int finalIndex = index;
                button.addActionListener(e -> {
                    if (!isDigging) {
                        indexSelectedPlant = finalIndex;
                        selectedPlant = new PlantFactory().getPlantType(deckPanel.getDeckTanaman().getArrayDeck().get(indexSelectedPlant));
                        System.out.println(String.format("Selected deck index %d plant type %s", indexSelectedPlant, selectedPlant.toString()));
                    }
                });
            }
            index += 1;
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
        shovel.setBounds((int)(screenWidth * 0.15), (int)(screenHeight * 0.03), (int)(screenWidth * 0.1), (int)(screenHeight * 0.1));
        shovel.addActionListener(e -> {
            if (selectedPlant == null) {
                isDigging = !isDigging;
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
        gameManager.updateGameMap();
//        System.out.println(gameManager.sun.getTotalSun());
        setTotalSun(gameManager.sun.getTotalSun());
        setMap();
        renderGameMap();
        repaint();
    }

    public void initializeMapPanel() {
        mapPanel = new JPanel(new GridLayout(6, 11, 2, 2));
        mapPanel.setOpaque(false);
        mapPanel.setBounds((int)(screenWidth * 0.2), (int)(screenHeight * 0.15), (int)(screenWidth * 0.75), (int)(screenHeight * 0.75));
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
                button.setPreferredSize(new Dimension((int)(screenWidth * 0.075), (int)(screenHeight * 0.075)));
                int row = i;
                int col = z;
                PlantFactory plantFactory = new PlantFactory();
                button.addActionListener(e -> {
                    if (isDigging) {
                        if (gameManager.getGameMap().getEntities(row, col).size() > 0) {
                            gameManager.getGameMap().removeEntity(row, col, 0);
                            isDigging = !isDigging;
                        }
                    }
                    if (selectedPlant != null) {
                        System.out.println(String.format("Planting at row %d col %d", row, col));
                        boolean success = gameManager.addPlant(plantFactory.CreatePlant(selectedPlant, new Point(col, row)), row, col);
                        if (success) {
                            // Berhasil menanam, set selected plant nya null dan mulai cooldown, logic mengurangi sun ada di gameManager
                            // TODO: cooldown refresh
                            selectedPlant = null;
                        }
                        Container parent = (Container) e.getSource();
                        System.out.println(parent.getComponents());
//                        JButton newButton = new JButton(selectedDeckButton.getIcon());
//                        newButton.setOpaque(false);
//                        newButton.setContentAreaFilled(false);
//                        newButton.setBorder(null);
//                        newButton.setMargin(new Insets(0, 0, 0, 0));

//                        // Iterate through the grid to find the clicked button's position
//                        int row = -1;
//                        int column = -1;
//                        Component[] components = mapPanel.getComponents();
//                        for (int k = 0; k < components.length; k++) {
//                            if (components[k] == button) {
//                                row = k / 11; // Assuming 11 columns in the grid
//                                column = k % 11;
//                                break;
//                            }
//                        }

                        // Calculate the position based on the row and column indices
//                        int x = col * button.getWidth();
//                        int y = row * button.getHeight();
//
//                        // Set the bounds of the new button
//                        newButton.setBounds(x, y, button.getWidth(), button.getHeight());
//
//                        parent.add(newButton);
//                        parent.repaint();
                    }
                });
                mapPanel.add(button);
                mapButtons[i][z] = button;
            }
        }
    }

    public void initializeDrawingPanel() {
        drawingPanel = new GameDrawingPanel(gameManager);
        drawingPanel.setBounds((int)(screenWidth * 0.2), (int)(screenHeight * 0.15), (int)(screenWidth * 0.75), (int)(screenHeight * 0.75));
        layeredPane.add(drawingPanel, Integer.valueOf(1)); // Add the drawing panel below the buttons
    }

    public void renderGameMap() {
        drawingPanel.repaint();
    }
}