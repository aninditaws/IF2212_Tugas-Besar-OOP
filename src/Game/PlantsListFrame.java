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
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Layered Pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Picture of Background
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.WELCOME);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenWidth, screenHeight);
        add(label);
        layeredPane.add(label, Integer.valueOf(0));

    }
}
