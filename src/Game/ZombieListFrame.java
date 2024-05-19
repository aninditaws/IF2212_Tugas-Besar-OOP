package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Picture.*;

public class ZombieListFrame extends JFrame{
    private JLayeredPane layeredPane;
    private JPanel buttonPanel;
    private JLabel label;
    private Dimension screenSize;
    private JPanel menuPanel;
    private JButton menuButton;
    private JButton plantsListButton;
    private JButton currentVisibleCard;

    public ZombieListFrame(){
        // Game Title & State
        setTitle("Michael vs. Lalapan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Screen Size and scaling factor
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double scaleFactor = Math.min(screenSize.getWidth() / 1280, screenSize.getHeight() / 720);
        int screenWidth = (int) (1280 * scaleFactor);
        int screenHeight = (int) (720 * scaleFactor);
        
        // Set fixed size based on scale
        setLayout(new BorderLayout());
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        // Layered Pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(screenWidth, screenHeight));

        // Picture of Background
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.ZOMBIESLISTBG);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        label = new JLabel(new ImageIcon(image));
        label.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(label, Integer.valueOf(0));

        // 10 buttons: ZOMBIES LIST
        buttonPanel = new JPanel(new GridLayout(3, 4, 31, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(70, 150, 825, 600);
        layeredPane.add(buttonPanel, Integer.valueOf(1));

        // Normal Zombie Button -- Show Normal Zombie Page
        JButton normalZombieButton = new JButton();
        normalZombieButton.setIcon(PictureFactory.getImageIcon(Picture.NORMALZOMBIEBUTTON));
        normalZombieButton.setOpaque(false);
        normalZombieButton.setContentAreaFilled(false);
        normalZombieButton.setBorder(null);
        normalZombieButton.setSize(775, 775);
        normalZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        normalZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton normalZombieCard = new JButton();
                normalZombieCard.setIcon(PictureFactory.getImageIcon(Picture.NORMALZOMBIELIST));
                showCard(normalZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(normalZombieButton);

        // Conehead Zombie Button -- Show Conehead Zombie Page
        JButton coneheadZombieButton = new JButton();
        coneheadZombieButton.setIcon(PictureFactory.getImageIcon(Picture.CONEHEADZOMBIEBUTTON));
        coneheadZombieButton.setOpaque(false);
        coneheadZombieButton.setContentAreaFilled(false);
        coneheadZombieButton.setBorder(null);
        coneheadZombieButton.setSize(775, 775);
        coneheadZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        coneheadZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton coneheadZombieCard = new JButton();
                coneheadZombieCard.setIcon(PictureFactory.getImageIcon(Picture.CONEHEADZOMBIELIST));
                showCard(coneheadZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(coneheadZombieButton);

        // Buckethead Zombie Button -- Show Buckethead Zombie Page
        JButton bucketheadZombieButton = new JButton();
        bucketheadZombieButton.setIcon(PictureFactory.getImageIcon(Picture.BUCKETHEADZOMBIEBUTTON));
        bucketheadZombieButton.setOpaque(false);
        bucketheadZombieButton.setContentAreaFilled(false);
        bucketheadZombieButton.setBorder(null);
        bucketheadZombieButton.setSize(775, 775);
        bucketheadZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        bucketheadZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton bucketheadZombieCard = new JButton();
                bucketheadZombieCard.setIcon(PictureFactory.getImageIcon(Picture.BUCKETHEADZOMBIELIST));
                showCard(bucketheadZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(bucketheadZombieButton);

        // Screendoor Zombie Button -- Show Screendoor Zombie Page
        JButton screendoorZombieButton = new JButton();
        screendoorZombieButton.setIcon(PictureFactory.getImageIcon(Picture.SCREENDOORZOMBIEBUTTON));
        screendoorZombieButton.setOpaque(false);
        screendoorZombieButton.setContentAreaFilled(false);
        screendoorZombieButton.setBorder(null);
        screendoorZombieButton.setSize(775, 775);
        screendoorZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        screendoorZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton screendoorZombieCard = new JButton();
                screendoorZombieCard.setIcon(PictureFactory.getImageIcon(Picture.SCREENDOORZOMBIELIST));
                showCard(screendoorZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(screendoorZombieButton);

        // Football Zombie Button -- Show Football Zombie Page
        JButton footballZombieButton = new JButton();
        footballZombieButton.setIcon(PictureFactory.getImageIcon(Picture.FOOTBALLZOMBIEBUTTON));
        footballZombieButton.setOpaque(false);
        footballZombieButton.setContentAreaFilled(false);
        footballZombieButton.setBorder(null);
        footballZombieButton.setSize(775, 775);
        footballZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        footballZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton footballZombieCard = new JButton();
                footballZombieCard.setIcon(PictureFactory.getImageIcon(Picture.FOOTBALLZOMBIELIST));
                showCard(footballZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(footballZombieButton);

        // Polevaulting Zombie Button -- Show Polevaulting Zombie Page
        JButton polevaultingZombieButton = new JButton();
        polevaultingZombieButton.setIcon(PictureFactory.getImageIcon(Picture.POLEVAULTINGZOMBIEBUTTON));
        polevaultingZombieButton.setOpaque(false);
        polevaultingZombieButton.setContentAreaFilled(false);
        polevaultingZombieButton.setBorder(null);
        polevaultingZombieButton.setSize(775, 775);
        polevaultingZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        polevaultingZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton polevaultingZombieCard = new JButton();
                polevaultingZombieCard.setIcon(PictureFactory.getImageIcon(Picture.POLEVAULTINGZOMBIELIST));
                showCard(polevaultingZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(polevaultingZombieButton);

        // Duckytube Zombie Button -- Show Duckytube Zombie Page
        JButton duckytubeZombieButton = new JButton();
        duckytubeZombieButton.setIcon(PictureFactory.getImageIcon(Picture.DUCKYTUBEZOMBIEBUTTON));
        duckytubeZombieButton.setOpaque(false);
        duckytubeZombieButton.setContentAreaFilled(false);
        duckytubeZombieButton.setBorder(null);
        duckytubeZombieButton.setSize(775, 775);
        duckytubeZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        duckytubeZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton duckytubeZombieCard = new JButton();
                duckytubeZombieCard.setIcon(PictureFactory.getImageIcon(Picture.DUCKYTUBEZOMBIELIST));
                showCard(duckytubeZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(duckytubeZombieButton);

        // Dolphinerider Zombie Button -- Show Dolphinerider Zombie Page
        JButton dolphineriderZombieButton = new JButton();
        dolphineriderZombieButton.setIcon(PictureFactory.getImageIcon(Picture.DOLPHINERIDERZOMBIEBUTTON));
        dolphineriderZombieButton.setOpaque(false);
        dolphineriderZombieButton.setContentAreaFilled(false);
        dolphineriderZombieButton.setBorder(null);
        dolphineriderZombieButton.setSize(775, 775);
        dolphineriderZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        dolphineriderZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton dolphineriderZombieCard = new JButton();
                dolphineriderZombieCard.setIcon(PictureFactory.getImageIcon(Picture.DOLPHINERIDERZOMBIELIST));
                showCard(dolphineriderZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(dolphineriderZombieButton);

        // Newspaper Zombie Button -- Show Newspaper Zombie Page
        JButton newspaperZombieButton = new JButton();
        newspaperZombieButton.setIcon(PictureFactory.getImageIcon(Picture.NEWSPAPERZOMBIEBUTTON));
        newspaperZombieButton.setOpaque(false);
        newspaperZombieButton.setContentAreaFilled(false);
        newspaperZombieButton.setBorder(null);
        newspaperZombieButton.setSize(775, 775);
        newspaperZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        newspaperZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton newspaperZombieCard = new JButton();
                newspaperZombieCard.setIcon(PictureFactory.getImageIcon(Picture.NEWSPAPERZOMBIELIST));
                showCard(newspaperZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(newspaperZombieButton);

        // Imp Zombie Button -- Show Imp Zombie Page
        JButton impZombieButton = new JButton();
        impZombieButton.setIcon(PictureFactory.getImageIcon(Picture.IMPZOMBIEBUTTON));
        impZombieButton.setOpaque(false);
        impZombieButton.setContentAreaFilled(false);
        impZombieButton.setBorder(null);
        impZombieButton.setSize(775, 775);
        impZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        impZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton impZombieCard = new JButton();
                impZombieCard.setIcon(PictureFactory.getImageIcon(Picture.IMPZOMBIELIST));
                showCard(impZombieCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(impZombieButton);

        // 2 buttons: Menu, Plants List
        menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new GridLayout(1, 2, 0, 0));
        menuPanel.setBounds((screenWidth - 650) / 2, 750, 650, 70);
        layeredPane.add(menuPanel, Integer.valueOf(1));

        // Menu Button -- To Welcome
        menuButton = new JButton();
        menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUBACKBUTTON));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(null);
        menuButton.setMargin(new Insets(0, 0, 0, 0));

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WelcomingFrame frame = new WelcomingFrame();
                frame.setVisible(true);
                dispose();
            }
        }); menuPanel.add(menuButton);        
       
        // Plants List Button -- To Plants List
        plantsListButton = new JButton();
        plantsListButton.setIcon(PictureFactory.getImageIcon(Picture.PLANTLISTSBUTTON));
        plantsListButton.setOpaque(false);
        plantsListButton.setContentAreaFilled(false);
        plantsListButton.setBorder(null);
        plantsListButton.setMargin(new Insets(0, 0, 0, 0));
        
        plantsListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlantsListFrame frame = new PlantsListFrame();
                frame.setVisible(true);
                dispose();
            }
        }); menuPanel.add(plantsListButton);   

        // LayeredPane
        add(layeredPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    private void showCard(JButton newCard, int x, int y, int width, int height) {
        if (currentVisibleCard != null) {
            layeredPane.remove(currentVisibleCard);
        }
        newCard.setOpaque(false);
        newCard.setContentAreaFilled(false);
        newCard.setBorderPainted(false);
        newCard.setBounds(x, y, width, height);
        layeredPane.add(newCard, Integer.valueOf(2));
        currentVisibleCard = newCard;
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ZombieListFrame frame = new ZombieListFrame();
            frame.setVisible(true);
        });
    }
}
