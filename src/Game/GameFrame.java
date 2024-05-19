package Game;

import javax.imageio.ImageIO;
import javax.swing.*;

import Inventory.DeckTanaman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;
import Picture.*;

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
//ppp
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

        JPanel tesPanelDarat1 = new JPanel();
        tesPanelDarat1.setBounds(356, 120, 1044, 230);
        tesPanelDarat1.setOpaque(false);
        tesPanelDarat1.setBackground(Color.RED);
        tesPanelDarat1.setLayout(new GridLayout(2, 9, 0, 0));
        add(tesPanelDarat1);

        JPanel tesPanelAir = new JPanel();
        tesPanelAir.setBounds(356, 350, 1044, 230);
        tesPanelAir.setOpaque(false);
        tesPanelAir.setBackground(Color.BLUE);
        tesPanelAir.setLayout(new GridLayout(2, 9, 0, 0));
        add(tesPanelAir);

        JPanel tesPanelDarat2 = new JPanel();
        tesPanelDarat2.setBounds(356, 580, 1044, 230);
        tesPanelDarat2.setOpaque(false);
        tesPanelDarat2.setBackground(Color.RED);
        tesPanelDarat2.setLayout(new GridLayout(2, 9, 0, 0));
        add(tesPanelDarat2);


        JPanel tesPanelnonButton = new JPanel();
        tesPanelnonButton.setBounds(240, 120, 116, 1150);
        tesPanelnonButton.setOpaque(false);
        tesPanelnonButton.setBackground(Color.BLACK);
        tesPanelnonButton.setLayout(new GridLayout(9, 1, 0, 0));
        add(tesPanelnonButton);

    

   //cek satu plant di spawn trus dipindahin satu kotak ke kotak yang lain

        try {
            // BufferedImage originalImage1 = ImageIO.read(new
            // File("ImagePvZ/Plants/Bullet/Pea.png"));

            // Cara gunain Picture Factory
            ImageIcon originalImage1 = PictureFactory.getImageIcon(Picture.BULLET);

            Image scaledImage1 = originalImage1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon plantIcon1 = new ImageIcon(scaledImage1);

        //    buat di darat atas
            for(int z = 0;z < 2; z++){
                for(int i = 0;i < 9;i++){
                    JButton button = new JButton();
                    button.setBackground(Color.green);
                    button.setPreferredSize(new Dimension(103, 140));
                    button.setIcon(plantIcon1); // Menambahkan ikon gambar pada tombol
                    tesPanelDarat1.add(button, BorderLayout.WEST);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tesPanelDarat1.getComponent(5).setBackground(Color.RED);

        // buat di air
        // for(int z = 0;z < 2; z++){
        // for(int i = 0;i < 10;i++){
        // JButton button = new JButton();
        // button.setBackground(Color.blue);
        // button.setPreferredSize(new Dimension(103,140));

        // tesPanelAir.add(button,BorderLayout.WEST);
        // }
        // }

        try {
            BufferedImage originalImage2 = ImageIO.read(new File("ImagePvZ/Plants/Bullet/SlowPea.png"));
            Image scaledImage2 = originalImage2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon plantIcon2 = new ImageIcon(scaledImage2);
// <<<<<<< HEAD
        //    buat di darat atas
            for(int z = 0;z < 2; z++){
                for(int i = 0;i < 9;i++){
                    JButton button = new JButton();
                    button.setBackground(Color.blue);
                    button.setPreferredSize(new Dimension(103, 140));
                    button.setIcon(plantIcon2); // Menambahkan ikon gambar pada tombol
                    tesPanelAir.add(button, BorderLayout.WEST);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedImage originalImage3 = ImageIO.read(new File("ImagePvZ/Plants/PlantsImg/Snowpea.png"));
            Image scaledImage3 = originalImage3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon plantIcon3 = new ImageIcon(scaledImage3);
// <<<<<<< HEAD
        //    buat di darat atas
            for(int z = 0;z < 2; z++){
                for(int i = 0;i < 9;i++){
                    JButton button = new JButton();
                    button.setBackground(Color.green);
                    button.setPreferredSize(new Dimension(103, 140));
                    button.setIcon(plantIcon3); // Menambahkan ikon gambar pada tombol
                    tesPanelDarat2.add(button, BorderLayout.WEST);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0;i < 6;i++){
            JButton button = new JButton();
            button.setBackground(Color.BLACK);
            button.setPreferredSize(new Dimension(103,140));
            // button.setIcon(plantIcon4); // Menambahkan ikon gambar pada tombol   
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorder(null);  
            tesPanelnonButton.add(button,BorderLayout.WEST);
            }

        // TEST PANEL
        JPanel tesPanel = new JPanel();
        tesPanel.setBounds(233, 110, 1085, 130);
        tesPanel.setOpaque(false);
        tesPanel.setLayout(new GridLayout(1, 10, 4, 2));
        tesPanel.setBackground(Color.RED);
        add(tesPanel);
        // Button
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton();
            button.setOpaque(false);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setPreferredSize(new Dimension(110, 130));
            button.setBounds(233, 110, 108, 130);
            tesPanel.add(button);
        }

        // Menu Button
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
        SwingUtilities.invokeLater(() -> updateBackgroundImage());
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
    }
}