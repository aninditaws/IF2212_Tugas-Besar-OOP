package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Picture.*;

public class WelcomingFrame extends JFrame{
    public WelcomingFrame(){
        // Game Title & State
        setTitle("Michael vs. Lalapan");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Screen Size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        
        // // Layered Pane
        // JLayeredPane layeredPane = new JLayeredPane();
        // layeredPane.setPreferredSize(screenSize);

        // Picture of Background
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.WELCOME);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,0,screenWidth,screenHeight);
        add(label);
        // layeredPane.add(label, Integer.valueOf(0));

        // 3 buttons: START, PLANTS LIST, ZOMBIES LIST
        JPanel buttonPanel = new JPanel();
        // buttonPanel.setOpaque(false);
        // buttonPanel.setLayout(new GridLayout(1,3,10,10));
        // buttonPanel.setBounds((screenWidth - 880)/2, screenHeight - 157, 692, 66);
        // layeredPane.add(buttonPanel, Integer.valueOf(1));

        // Start Button -- To Inventory
        JButton button = new JButton();
        button.setIcon(PictureFactory.getImageIcon(Picture.STARTBUTTON));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(440, 75);
        button.setMargin(new Insets(0,0,0,0));
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                InventoryFrame frame = new InventoryFrame();
                frame.setVisible(true);
                dispose();
            }
        });

        // PlantsList Button -- To Plants List
        // ZombiesList Button -- To Zombies List
        // Help Button -- To Help
        // Exit Button -- To Exit
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            WelcomingFrame frame = new WelcomingFrame();
            frame.setVisible(true);
        });
    }
}
