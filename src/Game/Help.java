package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Picture.Picture;
import Picture.PictureFactory;

public class Help extends JFrame {
    private JLayeredPane layeredPane;
    private JButton menuButton;
    private JLabel label;
    private Dimension screenSize;

    public Help() {
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
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.HELP);
        Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenWidth, screenHeight);
        add(label);
        layeredPane.add(label, Integer.valueOf(0));

        // Menu Button -- To Welcome
        JButton menuButton = new JButton();
        menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUBUTTON));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(null);
        menuButton.setSize(450, 100);
        menuButton.setMargin(new Insets(0, 0, 0, 0));
        menuButton.setBounds(screenWidth - 430, screenHeight - 150, 450, 100);

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WelcomingFrame frame = new WelcomingFrame();
                frame.setVisible(true);
                dispose();
            }
        }); layeredPane.add(menuButton, Integer.valueOf(1));

        add(layeredPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Help frame = new Help();
            frame.setVisible(true);
        });
    }
}
