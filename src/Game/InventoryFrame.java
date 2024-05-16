package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Inventory.*;
import Picture.*;
import Plant.*;

public class InventoryFrame extends JFrame {
    Inventory inventory = new Inventory();
    DeckTanaman deckTanaman = new DeckTanaman(6);
    JLayeredPane layeredPane;
    JLabel label;
    JButton button;
    ImageIcon imageIcon;
    Image image;
    PlantImage PlantImage;
    Dimension screenSize;

    java.util.List<JButton> planButtons = new java.util.ArrayList<>(); // ini buat nyimpen button

    public InventoryFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Declare size of screen
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // LayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        // Add Picture for Background
        imageIcon = new ImageIcon("ImagePvZ/Inventory/Inventory.png");

        image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(label, Integer.valueOf(0));

        // Part Buat Plant Buttons di Inventory
        JPanel plantButtons = new JPanel();
        plantButtons.setOpaque(false);
        plantButtons.setLayout(new GridLayout(2, 5, 20, 20));

        int index = 0;
        int margin = 20;
        for (PlantImage plant : PlantImage.values()) {
            final int currentIndex = index;
            ImageIcon imageIcon = new ImageIcon(plant.getImagePath());
            int imageWidth = 220;
            int imageHeight = 120;
            Image image = imageIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            JButton button = new JButton();
            button.setIcon(imageIcon);
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorder(null);
            button.setMargin(new Insets(margin, margin, margin, margin));
            button.setPreferredSize(new Dimension(imageWidth, imageHeight));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Plant clickedPlant = inventory.getPlant(currentIndex);
                    if (button.isEnabled()) {
                        if (deckTanaman.getArrayDeck().contains(inventory.getPlant(currentIndex))) {
                            deckTanaman.getArrayDeck().remove(clickedPlant);
                            button.setBorder(null);
                            reenableAllButtons();
                        } else {
                            if (deckTanaman.getArrayDeck().size() < deckTanaman.getMaxDeckSize()) {
                                inventory.chooseTanaman(clickedPlant, deckTanaman, inventory);
                                button.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

                            }
                        }
                        deckTanaman.printDeck();
                        disableButtonsIfMaxReached();
                    }
                }
            });

            plantButtons.add(button);
            index++;
        }
        // Center the buttons panel within the layeredPane
        int panelWidth = plantButtons.getPreferredSize().width;
        int panelHeight = plantButtons.getPreferredSize().height;
        plantButtons.setBounds((screenWidth - panelWidth) / 2, (screenHeight - panelHeight) / 2 - 100, panelWidth,
                panelHeight);

        layeredPane.add(plantButtons, Integer.valueOf(1));

        // Button to GameFrame
        button = new JButton();
        button.setIcon(new ImageIcon("ImagePvZ/Button/Play_Button.png"));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(200, 100));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager gameManager = new GameManager();
                GameFrame frame = new GameFrame(gameManager);
                frame.setVisible(true);
                dispose();
            }
        });
        button.setBounds(screenWidth - 500, screenHeight - 200, 458, 117);
        layeredPane.add(button, Integer.valueOf(1));

        add(layeredPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void reenableAllButtons() {
        for (JButton button : planButtons) {
            button.setEnabled(true);
        }
    }

    private void disableButtonsIfMaxReached() {
        if (deckTanaman.getArrayDeck().size() >= deckTanaman.getMaxDeckSize()) {
            for (JButton button : planButtons) {
                if (!deckTanaman.getArrayDeck().contains(inventory.getPlant(planButtons.indexOf(button)))) {
                    button.setEnabled(false);
                }
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            InventoryFrame frame = new InventoryFrame();
            frame.setVisible(true);
        });
    }
}
