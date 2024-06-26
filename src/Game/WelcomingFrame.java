package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Picture.*;
import Zombie.Zombie;

public class WelcomingFrame extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel buttonPanel;
    private JButton helpButton;
    private JButton exitButton;
    private JLabel label;
    private Dimension screenSize;

    public WelcomingFrame() {
        // Game Title & State
        setTitle("Michael vs. Lalapan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Screen Size
        // screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1240, 750);
        setLocationRelativeTo(null);
        // int 1240 = (int) screenSize.getWidth();
        // int 750 = (int) screenSize.getHeight();

        // Layered Pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1240, 750));

        // Picture of Background
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.WELCOME);
        Image image = imageIcon.getImage().getScaledInstance(1240, 750, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0, 0, 1240, 750);
        add(label);
        layeredPane.add(label, Integer.valueOf(0));

        // 3 buttons: START, PLANTS LIST, ZOMBIES LIST
        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBounds((1240 - 400) / 2, (750 - 100) / 2, 450, 300);
        layeredPane.add(buttonPanel, Integer.valueOf(1));

        // Start Button -- To Inventory
        JButton startButton = new JButton();
        startButton.setIcon(PictureFactory.getImageIcon(Picture.STARTBUTTON));
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorder(null);
        startButton.setSize(450, 100);
        startButton.setMargin(new Insets(0, 0, 0, 0));

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InventoryFrame frame = new InventoryFrame();
                frame.setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(startButton);

        // PlantsList Button -- To Plants List
        JButton plantsButton = new JButton();
        plantsButton.setIcon(PictureFactory.getImageIcon(Picture.PLANTSBUTTON));
        plantsButton.setOpaque(false);
        plantsButton.setContentAreaFilled(false);
        plantsButton.setBorder(null);
        plantsButton.setSize(450, 100);
        plantsButton.setMargin(new Insets(0, 0, 0, 0));

        plantsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlantsListFrame frame = new PlantsListFrame();
                frame.setVisible(true);
                dispose();
            }
        });

        buttonPanel.add(plantsButton);

        // ZombiesList Button -- To Zombies List
        JButton zombiesButton = new JButton();
        zombiesButton.setIcon(PictureFactory.getImageIcon(Picture.ZOMBIESBUTTON));
        zombiesButton.setOpaque(false);
        zombiesButton.setContentAreaFilled(false);
        zombiesButton.setBorder(null);
        zombiesButton.setSize(450, 100);
        zombiesButton.setMargin(new Insets(0, 0, 0, 0));

        zombiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // masukin page zombies
                ZombieListFrame frame = new ZombieListFrame();
                frame.setVisible(true);
                dispose();
            }
        });

        buttonPanel.add(zombiesButton);

        // Help Button -- To Help
        helpButton = new JButton();
        helpButton.setIcon(PictureFactory.getImageIcon(Picture.HELPBUTTON));
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorder(null);
        helpButton.setSize(250, 80);
        helpButton.setMargin(new Insets(0, 0, 0, 0));
        helpButton.setBounds(10, 10, 250, 80);

        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Help frame = new Help();
                frame.setVisible(true);
                dispose();
            }
        });
        layeredPane.add(helpButton, Integer.valueOf(1));

        // Exit Button -- To Exit
        exitButton = new JButton();
        exitButton.setIcon(PictureFactory.getImageIcon(Picture.EXITBUTTON));
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorder(null);
        exitButton.setSize(250, 80);
        exitButton.setMargin(new Insets(0, 0, 0, 0));
        exitButton.setBounds(1240 - 300, 750 - 95, 250, 80);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        layeredPane.add(exitButton, Integer.valueOf(1));

        // LayeredPane
        add(layeredPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            WelcomingFrame frame = new WelcomingFrame();
            frame.setVisible(true);
        });
    }
}
