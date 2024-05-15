package Game;

import javax.swing.*;
import javax.tools.Tool;

import Inventory.Inventory;
import Plant.*;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class InventoryFrame extends JFrame {
    public InventoryFrame() {

        // Attributes
        Inventory inventory = new Inventory();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Inventory Background
        ImageIcon inventoryIcon = createImageIcon("ImagePvZ/Inventory/Inventory.png");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        Image image = inventoryIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        inventoryIcon = new ImageIcon(image);
        JLabel label = new JLabel(inventoryIcon);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height;
        int labelX = (width - labelWidth) / 2;
        int labelY = (width - labelHeight) / 2;

        // first Plant Row Button
        JButton[] plantButtons1 = new JButton[5];
        String[] plantImages1 = {
                "ImagePvZ/Plants/PlantsCard/sunflowerCard.png",
                "ImagePvZ/Plants/PlantsCard/PeashooterCard.PNG",
                "ImagePvZ/Plants/PlantsCard/wallnutCard.png",
                "ImagePvZ/Plants/PlantsCard/SnowPea.png",
                "ImagePvZ/Plants/PlantsCard/squash.png",
        };
        JButton[] plantButtons2 = new JButton[5];
        String[] plantImages2 = {
                "ImagePvZ/Plants/PlantsCard/LilyPadSeedCard.png",
                "ImagePvZ/Plants/PlantsCard/cherrybombCard.png",
                "ImagePvZ/Plants/PlantsCard/jalapenoCard.png",
                "ImagePvZ/Plants/PlantsCard/jalapenoCard.png",
                "ImagePvZ/Plants/PlantsCard/jalapenoCard.png"
        };
        int buttonWidth = 220;
        int buttonHeight = 155;

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(1, plantButtons1.length, 10, 0));

        for (int i = 0; i < plantButtons1.length; i++) {
            ImageIcon plantIcon = createImageIcon(plantImages1[i]);
            Image plantImage = plantIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
            plantIcon = new ImageIcon(plantImage);
            plantButtons1[i] = new JButton(plantIcon);
            buttonPanel1.add(plantButtons1[i]);
        }
        // Second Plant Row Button
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new GridLayout(1, plantButtons2.length, 10, 0));
        for (int i = 0; i < plantButtons2.length; i++) {

            ImageIcon plantIcon = createImageIcon(plantImages2[i]);
            Image plantImage = plantIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);

            plantIcon = new ImageIcon(plantImage);
            plantButtons2[i] = new JButton(plantIcon);
            buttonPanel2.add(plantButtons2[i]);
        }

        // Merge buttonPanel1 and buttonPanel2
        JPanel buttonPlants = new JPanel();
        buttonPlants.setLayout(new GridLayout(2, 1));
        buttonPlants.add(buttonPanel1);
        buttonPlants.add(buttonPanel2);
        buttonPlants.setOpaque(false);
        buttonPlants.setBackground(new Color(0, 0, 0, 0));

        // Play Button
        ImageIcon playIcon = createImageIcon("ImagePvZ/Button/Play_Button.png");

        Dimension playSize = Toolkit.getDefaultToolkit().getScreenSize();
        int playWidth = (int) playSize.getWidth();
        int playHeight = (int) playSize.getHeight();
        Image playImage = playIcon.getImage().getScaledInstance(playWidth, playHeight, Image.SCALE_SMOOTH);
        playIcon = new ImageIcon(playImage);
        JButton playButton = new JButton(playIcon);
        int playX = (int) (playWidth * 0.85);
        int playY = (int) (playHeight * 0.85);

        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        setLayout(null);

        label.setBounds(0, 0, labelWidth, labelHeight);

        int buttonPlantsX = (width - buttonWidth * 5) / 2;
        int buttonPlantsY = (height - buttonHeight * 2) / 2;
        buttonPlants.setBounds(buttonPlantsX, buttonPlantsY, buttonWidth * 5, (buttonHeight * 2));

        playButton.setBounds(playX, playY, playWidth, playHeight);

        add(label);
        add(buttonPlants);
        add(playButton);

        setSize(width, height);
        setVisible(true);
    }

    // Method buat pindah ke GameFrame
    public void startGame() {
        GameManager gameManager = new GameManager();
        gameManager.startTimer();
        GameFrame gameFrame = new GameFrame(gameManager);
        gameFrame.setVisible(true);
        dispose();
    }

    public ImageIcon createImageIcon(String path) {
        return new ImageIcon(path);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            InventoryFrame frame = new InventoryFrame();
            frame.setVisible(true);
        });
    }
}
