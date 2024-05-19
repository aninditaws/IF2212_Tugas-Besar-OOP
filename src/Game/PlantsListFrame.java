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
    
    public PlantsListFrame(){
        // Game Title & State
        setTitle("Michael vs. Lalapan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Screen Size
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.width;
        int screenHeight = (int) screenSize.height;

        // Layered Pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Picture of Background
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.PLANTSLISTBG);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenWidth, screenHeight);
        add(label);
        layeredPane.add(label, Integer.valueOf(0));

        // 10 buttons: PLANTS LIST
        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(3, 4, 30, 0));
        buttonPanel.setBounds(95, 200, 825, 600);
        layeredPane.add(buttonPanel, Integer.valueOf(1));

        // Sunflower Button -- Show Sunflower Page
        JButton sunflowerButton = new JButton();
        sunflowerButton.setIcon(PictureFactory.getImageIcon(Picture.SUNFLOWERBUTTON));
        sunflowerButton.setOpaque(false);
        sunflowerButton.setContentAreaFilled(false);
        sunflowerButton.setBorder(null);
        sunflowerButton.setSize(750, 750);
        sunflowerButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(sunflowerButton);

        // Peashooter Button -- Show Peashooter Page
        JButton peashooterButton = new JButton();
        peashooterButton.setIcon(PictureFactory.getImageIcon(Picture.PEASHOOTERBUTTON));
        peashooterButton.setOpaque(false);
        peashooterButton.setContentAreaFilled(false);
        peashooterButton.setBorder(null);
        peashooterButton.setSize(750, 750);
        peashooterButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(peashooterButton);       

        // Repeater Button -- Show Repeater Page
        JButton repeaterButton = new JButton();
        repeaterButton.setIcon(PictureFactory.getImageIcon(Picture.REPEATERBUTTON));
        repeaterButton.setOpaque(false);
        repeaterButton.setContentAreaFilled(false);
        repeaterButton.setBorder(null);
        repeaterButton.setSize(750, 750);
        repeaterButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(repeaterButton);   

        // Lilipad Button -- Show Lilipad Page
        JButton lilypadButton = new JButton();
        lilypadButton.setIcon(PictureFactory.getImageIcon(Picture.LILYPADBUTTON));
        lilypadButton.setOpaque(false);
        lilypadButton.setContentAreaFilled(false);
        lilypadButton.setBorder(null);
        lilypadButton.setSize(750, 750);
        lilypadButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(lilypadButton);   

        // Tallnut Button -- Show Tallnut Page
        JButton tallnutButton = new JButton();
        tallnutButton.setIcon(PictureFactory.getImageIcon(Picture.TALLNUTBUTTON));
        tallnutButton.setOpaque(false);
        tallnutButton.setContentAreaFilled(false);
        tallnutButton.setBorder(null);
        tallnutButton.setSize(750, 750);
        tallnutButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(tallnutButton);         
        
        // Snow Pea Button -- Show Snow Pea Page
        JButton snowpeaButton = new JButton();
        snowpeaButton.setIcon(PictureFactory.getImageIcon(Picture.SNOWPEABUTTON));
        snowpeaButton.setOpaque(false);
        snowpeaButton.setContentAreaFilled(false);
        snowpeaButton.setBorder(null);
        snowpeaButton.setSize(750, 750);
        snowpeaButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(snowpeaButton);   

        // Wallnut Button -- Show Wallnut Page
        JButton wallnutButton = new JButton();
        wallnutButton.setIcon(PictureFactory.getImageIcon(Picture.WALLNUTBUTTON));
        wallnutButton.setOpaque(false);
        wallnutButton.setContentAreaFilled(false);
        wallnutButton.setBorder(null);
        wallnutButton.setSize(750, 750);
        wallnutButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(wallnutButton);   

        // Cherry Bomb Button -- Show Cherry Bomb Page
        JButton cherrybombButton = new JButton();
        cherrybombButton.setIcon(PictureFactory.getImageIcon(Picture.CHERRYBOMBBUTTON));
        cherrybombButton.setOpaque(false);
        cherrybombButton.setContentAreaFilled(false);
        cherrybombButton.setBorder(null);
        cherrybombButton.setSize(750, 750);
        cherrybombButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(cherrybombButton);   

        // Jalapeno Button -- Show Jalapeno Page
        JButton jalapenoButton = new JButton();
        jalapenoButton.setIcon(PictureFactory.getImageIcon(Picture.JALAPENOBUTTON));
        jalapenoButton.setOpaque(false);
        jalapenoButton.setContentAreaFilled(false);
        jalapenoButton.setBorder(null);
        jalapenoButton.setSize(750, 750);
        jalapenoButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(jalapenoButton);   

        // Squash Button -- Show Squash Page
        JButton squashButton = new JButton();
        squashButton.setIcon(PictureFactory.getImageIcon(Picture.SQUASHBUTTON));
        squashButton.setOpaque(false);
        squashButton.setContentAreaFilled(false);
        squashButton.setBorder(null);
        squashButton.setSize(750, 750);
        squashButton.setMargin(new Insets(0, 0, 0, 0));     
        buttonPanel.add(squashButton);   

        // LayeredPane
        add(layeredPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PlantsListFrame frame = new PlantsListFrame();
            frame.setVisible(true);
        });
    }
}
