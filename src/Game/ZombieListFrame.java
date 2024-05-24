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
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Screen Size and scaling factor
        // screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1240, 750);
        setLocationRelativeTo(null);
        // int 1240 = (int) screenSize.getWidth();
        // int 750 = (int) screenSize.getHeight();

        // Layered Pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1240, 750));

        // Picture of Background
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.ZOMBIESLISTBG);
        Image image = imageIcon.getImage().getScaledInstance(1240, 750, Image.SCALE_SMOOTH);
        label = new JLabel(new ImageIcon(image));
        label.setBounds(0, 0, 1240, 750);
        layeredPane.add(label, Integer.valueOf(0));

        // 10 buttons: ZOMBIES LIST
        buttonPanel = new JPanel(new GridLayout(3, 4, 31, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(60, 150, 675, 450);
        layeredPane.add(buttonPanel, Integer.valueOf(1));

        // Normal Zombie Button -- Show Normal Zombie Page
        JButton normalZombieButton = new JButton();
        normalZombieButton.setIcon(PictureFactory.getImageIcon(Picture.NORMALZOMBIEBUTTON));
        normalZombieButton.setOpaque(false);
        normalZombieButton.setContentAreaFilled(false);
        normalZombieButton.setBorder(null);
        normalZombieButton.setSize(550, 550);
        normalZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        normalZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton normalZombieCard = new JButton();
                normalZombieCard.setIcon(PictureFactory.getImageIcon(Picture.NORMALZOMBIELIST));
                showCard(normalZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(normalZombieButton);

        // Conehead Zombie Button -- Show Conehead Zombie Page
        JButton coneheadZombieButton = new JButton();
        coneheadZombieButton.setIcon(PictureFactory.getImageIcon(Picture.CONEHEADZOMBIEBUTTON));
        coneheadZombieButton.setOpaque(false);
        coneheadZombieButton.setContentAreaFilled(false);
        coneheadZombieButton.setBorder(null);
        coneheadZombieButton.setSize(550, 550);
        coneheadZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        coneheadZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton coneheadZombieCard = new JButton();
                coneheadZombieCard.setIcon(PictureFactory.getImageIcon(Picture.CONEHEADZOMBIELIST));
                showCard(coneheadZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(coneheadZombieButton);

        // Buckethead Zombie Button -- Show Buckethead Zombie Page
        JButton bucketheadZombieButton = new JButton();
        bucketheadZombieButton.setIcon(PictureFactory.getImageIcon(Picture.BUCKETHEADZOMBIEBUTTON));
        bucketheadZombieButton.setOpaque(false);
        bucketheadZombieButton.setContentAreaFilled(false);
        bucketheadZombieButton.setBorder(null);
        bucketheadZombieButton.setSize(550, 550);
        bucketheadZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        bucketheadZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton bucketheadZombieCard = new JButton();
                bucketheadZombieCard.setIcon(PictureFactory.getImageIcon(Picture.BUCKETHEADZOMBIELIST));
                showCard(bucketheadZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(bucketheadZombieButton);

        // Screendoor Zombie Button -- Show Screendoor Zombie Page
        JButton screendoorZombieButton = new JButton();
        screendoorZombieButton.setIcon(PictureFactory.getImageIcon(Picture.SCREENDOORZOMBIEBUTTON));
        screendoorZombieButton.setOpaque(false);
        screendoorZombieButton.setContentAreaFilled(false);
        screendoorZombieButton.setBorder(null);
        screendoorZombieButton.setSize(550, 550);
        screendoorZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        screendoorZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton screendoorZombieCard = new JButton();
                screendoorZombieCard.setIcon(PictureFactory.getImageIcon(Picture.SCREENDOORZOMBIELIST));
                showCard(screendoorZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(screendoorZombieButton);

        // Football Zombie Button -- Show Football Zombie Page
        JButton footballZombieButton = new JButton();
        footballZombieButton.setIcon(PictureFactory.getImageIcon(Picture.FOOTBALLZOMBIEBUTTON));
        footballZombieButton.setOpaque(false);
        footballZombieButton.setContentAreaFilled(false);
        footballZombieButton.setBorder(null);
        footballZombieButton.setSize(550, 550);
        footballZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        footballZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton footballZombieCard = new JButton();
                footballZombieCard.setIcon(PictureFactory.getImageIcon(Picture.FOOTBALLZOMBIELIST));
                showCard(footballZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(footballZombieButton);

        // Polevaulting Zombie Button -- Show Polevaulting Zombie Page
        JButton polevaultingZombieButton = new JButton();
        polevaultingZombieButton.setIcon(PictureFactory.getImageIcon(Picture.POLEVAULTINGZOMBIEBUTTON));
        polevaultingZombieButton.setOpaque(false);
        polevaultingZombieButton.setContentAreaFilled(false);
        polevaultingZombieButton.setBorder(null);
        polevaultingZombieButton.setSize(550, 550);
        polevaultingZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        polevaultingZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton polevaultingZombieCard = new JButton();
                polevaultingZombieCard.setIcon(PictureFactory.getImageIcon(Picture.POLEVAULTINGZOMBIELIST));
                showCard(polevaultingZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(polevaultingZombieButton);

        // Duckytube Zombie Button -- Show Duckytube Zombie Page
        JButton duckytubeZombieButton = new JButton();
        duckytubeZombieButton.setIcon(PictureFactory.getImageIcon(Picture.DUCKYTUBEZOMBIEBUTTON));
        duckytubeZombieButton.setOpaque(false);
        duckytubeZombieButton.setContentAreaFilled(false);
        duckytubeZombieButton.setBorder(null);
        duckytubeZombieButton.setSize(550, 550);
        duckytubeZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        duckytubeZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton duckytubeZombieCard = new JButton();
                duckytubeZombieCard.setIcon(PictureFactory.getImageIcon(Picture.DUCKYTUBEZOMBIELIST));
                showCard(duckytubeZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(duckytubeZombieButton);

        // Dolphinerider Zombie Button -- Show Dolphinerider Zombie Page
        JButton dolphineriderZombieButton = new JButton();
        dolphineriderZombieButton.setIcon(PictureFactory.getImageIcon(Picture.DOLPHINERIDERZOMBIEBUTTON));
        dolphineriderZombieButton.setOpaque(false);
        dolphineriderZombieButton.setContentAreaFilled(false);
        dolphineriderZombieButton.setBorder(null);
        dolphineriderZombieButton.setSize(550, 550);
        dolphineriderZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        dolphineriderZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton dolphineriderZombieCard = new JButton();
                dolphineriderZombieCard.setIcon(PictureFactory.getImageIcon(Picture.DOLPHINERIDERZOMBIELIST));
                showCard(dolphineriderZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(dolphineriderZombieButton);

        // Gargantuar Zombie Button -- Show Gargantuar Zombie Page
        JButton gargantuarZombieButton = new JButton();
        gargantuarZombieButton.setIcon(PictureFactory.getImageIcon(Picture.GARGANTUARZOMBIELIST));
        gargantuarZombieButton.setOpaque(false);
        gargantuarZombieButton.setContentAreaFilled(false);
        gargantuarZombieButton.setBorder(null);
        gargantuarZombieButton.setSize(550, 550);
        gargantuarZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        gargantuarZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton gargantuarZombieCard = new JButton();
                gargantuarZombieCard.setIcon(PictureFactory.getImageIcon(Picture.GARGANTUARZOMBIELIST));
                showCard(gargantuarZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(gargantuarZombieButton);

        // Imp Zombie Button -- Show Imp Zombie Page
        JButton impZombieButton = new JButton();
        impZombieButton.setIcon(PictureFactory.getImageIcon(Picture.IMPZOMBIEBUTTON));
        impZombieButton.setOpaque(false);
        impZombieButton.setContentAreaFilled(false);
        impZombieButton.setBorder(null);
        impZombieButton.setSize(550, 550);
        impZombieButton.setMargin(new Insets(0, 0, 0, 0));    
        
        impZombieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton impZombieCard = new JButton();
                impZombieCard.setIcon(PictureFactory.getImageIcon(Picture.IMPZOMBIELIST));
                showCard(impZombieCard, 710, 50, 500, 600);
            }
        }); buttonPanel.add(impZombieButton);

        // 2 buttons: Menu, Plants List
        menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new GridLayout(1, 2, 0, 0));
        menuPanel.setBounds((1240 - 650) / 2, 635, 650, 70);
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
