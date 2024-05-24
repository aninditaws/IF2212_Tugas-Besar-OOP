package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Picture.Picture;
import Picture.PictureFactory;

public class Help extends JFrame {
    private JLayeredPane layeredPane;
    private JButton menuButton, backButton, nextButton;
    private JLabel label;
    private Dimension screenSize;
    private int currentPage = 1;
    private static final int totalPages = 4;

    public Help() {
        // Game Title & State
        setTitle("Michael vs. Lalapan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // Screen Size
        setSize(1240, 750);
        setLocationRelativeTo(null);
        // int screenWidth = (int) screenSize.getWidth();
        // int screenHeight = (int) screenSize.getHeight();

        // Layered Pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1240, 750));
        add(layeredPane, BorderLayout.CENTER);

        // Buttons & Page
        setupButtons();
        updatePage();
    }

    private void setupButtons() {
        backButton = new JButton();
        backButton.setIcon(PictureFactory.getImageIcon(Picture.BACKHELPBUTTON));
        backButton.setContentAreaFilled(false);
        backButton.setSize(110,110);
        backButton.setLocation(30, 600);
        backButton.addActionListener(e -> navigatePages(-1));

        nextButton = new JButton();
        nextButton.setIcon(PictureFactory.getImageIcon(Picture.NEXTHELPBUTTON));
        nextButton.setContentAreaFilled(false);
        nextButton.setSize(110,110);
        nextButton.setLocation(1100, 600);
        nextButton.addActionListener(e -> navigatePages(1));

        menuButton = new JButton();
        menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUHELPBUTTON));
        menuButton.setContentAreaFilled(false);
        menuButton.setSize(250,70);
        menuButton.setLocation(30,30);
        menuButton.addActionListener(e -> returnToMenu());

        layeredPane.add(backButton, Integer.valueOf(2));
        layeredPane.add(nextButton, Integer.valueOf(2));
        layeredPane.add(menuButton, Integer.valueOf(2));
    }

    private void navigatePages(int direction) {
        currentPage += direction;
        updatePage();
    }

    private void updatePage() {
        backButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(currentPage < totalPages);
        updateBackground();
    }

    private void updateBackground() {
        ImageIcon imageIcon = new ImageIcon("ImagePvZ/GameFrame/Help " + currentPage + ".png");
        Image image = imageIcon.getImage().getScaledInstance(1240, 750, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        if (label != null) {
            layeredPane.remove(label);
        }

        label = new JLabel(imageIcon);
        label.setBounds(0, 0, 1240, 750);
        layeredPane.add(label, Integer.valueOf(1));
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    
    private void returnToMenu() {
        WelcomingFrame frame = new WelcomingFrame();
        frame.setVisible(true);
        dispose();
    }
    //     // Picture of Background
    //     ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.HELP);
    //     Image image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
    //     imageIcon = new ImageIcon(image);
    //     label = new JLabel(imageIcon);
    //     label.setBounds(0, 0, screenWidth, screenHeight);
    //     add(label);
    //     layeredPane.add(label, Integer.valueOf(0));

    //     // Menu Button -- To Welcome
    //     menuButton = new JButton();
    //     menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUBACKBUTTON));
    //     menuButton.setOpaque(false);
    //     menuButton.setContentAreaFilled(false);
    //     menuButton.setBorder(null);
    //     menuButton.setSize(450, 100);
    //     menuButton.setMargin(new Insets(0, 0, 0, 0));
    //     menuButton.setBounds(screenWidth - 430, screenHeight - 150, 450, 100);

    //     menuButton.addActionListener(new ActionListener() {
    //         public void actionPerformed(ActionEvent e) {
    //             WelcomingFrame frame = new WelcomingFrame();
    //             frame.setVisible(true);
    //             dispose();
    //         }
    //     }); layeredPane.add(menuButton, Integer.valueOf(1));

    //     add(layeredPane, BorderLayout.CENTER);
    //     pack();
    //     setVisible(true);
    // }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Help frame = new Help();
            frame.setVisible(true);
        });
    }
}
