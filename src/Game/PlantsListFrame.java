package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Picture.*;

public class PlantsListFrame extends JFrame{
    private JLayeredPane layeredPane;
    private JPanel buttonPanel;
    private JLabel label;
    private Dimension screenSize;
    private JPanel menuPanel;
    private JButton menuButton;
    private JButton zombiesListButton;
    private JButton currentVisibleCard;
    
    public PlantsListFrame(){
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
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.PLANTSLISTBG);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        label = new JLabel(new ImageIcon(image));
        label.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(label, Integer.valueOf(0));

        // 10 buttons: PLANTS LIST
        buttonPanel = new JPanel(new GridLayout(3, 4, 31, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(70, 150, 825, 600);
        layeredPane.add(buttonPanel, Integer.valueOf(1));

        // Sunflower Button -- Show Sunflower Page
        JButton sunflowerButton = new JButton();
        sunflowerButton.setIcon(PictureFactory.getImageIcon(Picture.SUNFLOWERBUTTON));
        sunflowerButton.setOpaque(false);
        sunflowerButton.setContentAreaFilled(false);
        sunflowerButton.setBorder(null);
        sunflowerButton.setSize(750, 750);
        sunflowerButton.setMargin(new Insets(0, 0, 0, 0));    
        
        sunflowerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton sunflowerCard = new JButton();
                sunflowerCard.setIcon(PictureFactory.getImageIcon(Picture.SUNFLOWERLIST));
                showCard(sunflowerCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(sunflowerButton);

        // Peashooter Button -- Show Peashooter Page
        JButton peashooterButton = new JButton();
        peashooterButton.setIcon(PictureFactory.getImageIcon(Picture.PEASHOOTERBUTTON));
        peashooterButton.setOpaque(false);
        peashooterButton.setContentAreaFilled(false);
        peashooterButton.setBorder(null);
        peashooterButton.setSize(750, 750);
        peashooterButton.setMargin(new Insets(0, 0, 0, 0));     
        
        peashooterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton peashooterCard = new JButton();
                peashooterCard.setIcon(PictureFactory.getImageIcon(Picture.PEASHOOTERLIST));
                showCard(peashooterCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(peashooterButton);       

        // Repeater Button -- Show Repeater Page
        JButton repeaterButton = new JButton();
        repeaterButton.setIcon(PictureFactory.getImageIcon(Picture.REPEATERBUTTON));
        repeaterButton.setOpaque(false);
        repeaterButton.setContentAreaFilled(false);
        repeaterButton.setBorder(null);
        repeaterButton.setSize(750, 750);
        repeaterButton.setMargin(new Insets(0, 0, 0, 0));  
        
        repeaterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton repeaterCard = new JButton();
                repeaterCard.setIcon(PictureFactory.getImageIcon(Picture.REPEATERLIST));
                showCard(repeaterCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(repeaterButton);   

        // Lilipad Button -- Show Lilipad Page
        JButton lilypadButton = new JButton();
        lilypadButton.setIcon(PictureFactory.getImageIcon(Picture.LILYPADBUTTON));
        lilypadButton.setOpaque(false);
        lilypadButton.setContentAreaFilled(false);
        lilypadButton.setBorder(null);
        lilypadButton.setSize(750, 750);
        lilypadButton.setMargin(new Insets(0, 0, 0, 0));     
        
        lilypadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton lilypadCard = new JButton();
                lilypadCard.setIcon(PictureFactory.getImageIcon(Picture.LILIPADLIST));
                showCard(lilypadCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(lilypadButton);   

        // Tallnut Button -- Show Tallnut Page
        JButton tallnutButton = new JButton();
        tallnutButton.setIcon(PictureFactory.getImageIcon(Picture.TALLNUTBUTTON));
        tallnutButton.setOpaque(false);
        tallnutButton.setContentAreaFilled(false);
        tallnutButton.setBorder(null);
        tallnutButton.setSize(750, 750);
        tallnutButton.setMargin(new Insets(0, 0, 0, 0));   

        tallnutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton tallnutCard = new JButton();
                tallnutCard.setIcon(PictureFactory.getImageIcon(Picture.TALLNUTLIST));
                showCard(tallnutCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(tallnutButton);         
        
        // Snow Pea Button -- Show Snow Pea Page
        JButton snowpeaButton = new JButton();
        snowpeaButton.setIcon(PictureFactory.getImageIcon(Picture.SNOWPEABUTTON));
        snowpeaButton.setOpaque(false);
        snowpeaButton.setContentAreaFilled(false);
        snowpeaButton.setBorder(null);
        snowpeaButton.setSize(750, 750);
        snowpeaButton.setMargin(new Insets(0, 0, 0, 0));     
        
        snowpeaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton snowpeaCard = new JButton();
                snowpeaCard.setIcon(PictureFactory.getImageIcon(Picture.SNOWPEALIST));
                showCard(snowpeaCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(snowpeaButton);   

        // Wallnut Button -- Show Wallnut Page
        JButton wallnutButton = new JButton();
        wallnutButton.setIcon(PictureFactory.getImageIcon(Picture.WALLNUTBUTTON));
        wallnutButton.setOpaque(false);
        wallnutButton.setContentAreaFilled(false);
        wallnutButton.setBorder(null);
        wallnutButton.setSize(750, 750);
        wallnutButton.setMargin(new Insets(0, 0, 0, 0));     
        
        wallnutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton wallnutCard = new JButton();
                wallnutCard.setIcon(PictureFactory.getImageIcon(Picture.WALLNUTLIST));
                showCard(wallnutCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(wallnutButton);   

        // Cherry Bomb Button -- Show Cherry Bomb Page
        JButton cherrybombButton = new JButton();
        cherrybombButton.setIcon(PictureFactory.getImageIcon(Picture.CHERRYBOMBBUTTON));
        cherrybombButton.setOpaque(false);
        cherrybombButton.setContentAreaFilled(false);
        cherrybombButton.setBorder(null);
        cherrybombButton.setSize(750, 750);
        cherrybombButton.setMargin(new Insets(0, 0, 0, 0));     
        
        cherrybombButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton cherrybombCard = new JButton();
                cherrybombCard.setIcon(PictureFactory.getImageIcon(Picture.CHERRYBOMBLIST));
                showCard(cherrybombCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(cherrybombButton);   

        // Jalapeno Button -- Show Jalapeno Page
        JButton jalapenoButton = new JButton();
        jalapenoButton.setIcon(PictureFactory.getImageIcon(Picture.JALAPENOBUTTON));
        jalapenoButton.setOpaque(false);
        jalapenoButton.setContentAreaFilled(false);
        jalapenoButton.setBorder(null);
        jalapenoButton.setSize(750, 750);
        jalapenoButton.setMargin(new Insets(0, 0, 0, 0));     
        
        jalapenoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton jalapenoCard = new JButton();
                jalapenoCard.setIcon(PictureFactory.getImageIcon(Picture.JALAPENOLIST));
                showCard(jalapenoCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(jalapenoButton);   

        // Squash Button -- Show Squash Page
        JButton squashButton = new JButton();
        squashButton.setIcon(PictureFactory.getImageIcon(Picture.SQUASHBUTTON));
        squashButton.setOpaque(false);
        squashButton.setContentAreaFilled(false);
        squashButton.setBorder(null);
        squashButton.setSize(750, 750);
        squashButton.setMargin(new Insets(0, 0, 0, 0));     
        
        squashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton squashCard = new JButton();
                squashCard.setIcon(PictureFactory.getImageIcon(Picture.SQUASHLIST));
                showCard(squashCard, 950, 75, 500, 700);
            }
        }); buttonPanel.add(squashButton);   

        // 2 buttons: Menu, Zombies List
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
       
        // Zombies List Button -- To Zombies List
        zombiesListButton = new JButton();
        zombiesListButton.setIcon(PictureFactory.getImageIcon(Picture.ZOMBIELISTSBUTTON));
        zombiesListButton.setOpaque(false);
        zombiesListButton.setContentAreaFilled(false);
        zombiesListButton.setBorder(null);
        zombiesListButton.setMargin(new Insets(0, 0, 0, 0));
        
        zombiesListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ZombieListFrame frame = new ZombieListFrame();
                frame.setVisible(true);
                dispose();
            }
        }); menuPanel.add(zombiesListButton);   

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
            PlantsListFrame frame = new PlantsListFrame();
            frame.setVisible(true);
        });
    }
}
