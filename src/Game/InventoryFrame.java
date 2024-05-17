package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Inventory.*;
import Picture.*;
import Plant.*;
// import Update.Update;

public class InventoryFrame extends JFrame {
    Inventory inventory = new Inventory();
    DeckTanaman deckTanaman = new DeckTanaman(6);
    JLayeredPane layeredPane;
    JLabel label;
    JPanel panel;
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
        imageIcon = PictureFactory.getImageIcon(Picture.INVENTORY);

        image = imageIcon.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenWidth, screenHeight);
        layeredPane.add(label, Integer.valueOf(0));

        // deckPanel

        JPanel deckPanel = new JPanel();

        deckPanel.setPreferredSize(new Dimension(150, 150));
        deckPanel.setBounds(34, 150, 150, 600);
        deckPanel.setLayout(new GridLayout(6, 1));
        deckPanel.setBackground(new Color(255, 255, 255, 150));
        deckPanel.setOpaque(false);
        layeredPane.add(deckPanel, BorderLayout.WEST, Integer.valueOf(0));

        // Inventory
        JPanel plantButtons = new JPanel();
        plantButtons.setOpaque(false);
        plantButtons.setLayout(new GridLayout(3, 4, 10, 10));

        int index = 0;

        for (PlantImage plant : PlantImage.values()) {
            final int currentIndex = index;
            ImageIcon imageIcon = new ImageIcon(plant.getImagePath());
            int imageWidth = 155;
            int imageHeight = 93;
            Image image = imageIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            JButton button = new JButton();
            button.setIcon(imageIcon);
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorder(null);
            button.setSize(new Dimension(imageWidth, imageHeight));

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Plant clickedPlant = inventory.getPlant(currentIndex);
                    JButton clonnedButton = new JButton(button.getIcon());
                    if (button.isEnabled()) {
                        if (deckTanaman.getArrayDeck().contains(inventory.getPlant(currentIndex))) {
                            deckTanaman.getArrayDeck().remove(clickedPlant);
                            button.setBorder(null);
                            reenableAllButtons();

                            for (Component component : deckPanel.getComponents()) {
                                if (component instanceof JButton) {
                                    JButton button = (JButton) component;
                                    if (button.getIcon().equals(clonnedButton.getIcon())) {
                                        deckPanel.remove(button);
                                        deckPanel.revalidate();
                                        deckPanel.repaint();
                                    }
                                }
                            }
                        } else {
                            if (deckTanaman.getArrayDeck().size() < deckTanaman.getMaxDeckSize()) {
                                inventory.chooseTanaman(clickedPlant, deckTanaman, inventory);
                                button.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

                                deckPanel.add(clonnedButton);
                                deckPanel.revalidate();
                                deckPanel.repaint();
                            }
                        }
                        deckTanaman.printDeck();
                        disableButtonsIfMaxReached();
                    }
                }
            });

            plantButtons.add(button); // Add button to plantButtons panel
            planButtons.add(button); // Add button to list panel
            index++;
        }
        // Center the plantButtons within the layeredPane
        int panelWidth = plantButtons.getPreferredSize().width;
        int panelHeight = plantButtons.getPreferredSize().height;

        int panelX = (screenWidth - panelWidth) / 2 - 100;
        int panelY = (screenHeight - panelHeight) / 2 - 100;

        plantButtons.setBounds(panelX, panelY,
                panelWidth,
                panelHeight);

        layeredPane.add(plantButtons, Integer.valueOf(1));
        // 3 button: Clear, Swap, Delete
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBounds((screenWidth - 880) / 2, screenHeight - 157, 692, 66);
        layeredPane.add(buttonPanel, Integer.valueOf(1));

        // clearButton
        button = new JButton();
        button.setIcon(PictureFactory.getImageIcon(Picture.CLEARBUTTON));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(300, 100);
        button.setMargin(new Insets(0, 0, 0, 0));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckTanaman.clearDeck();
                reenableAllButtons();

                // Reset borders for all plan buttons
                for (JButton button : planButtons) {
                    button.setBorder(null);
                }

                // Revalidate and repaint the deckPanel
                deckPanel.removeAll();
                deckPanel.revalidate();
                deckPanel.repaint();

            }
        });

        buttonPanel.add(button);
        // swapButton
        button = new JButton();
        button.setIcon(PictureFactory.getImageIcon(Picture.SWAPBUTTON));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(300, 100);
        button.setMargin(new Insets(0, 0, 0, 0));

        buttonPanel.add(button);

        // deleteButton
        button = new JButton();
        button.setIcon(PictureFactory.getImageIcon(Picture.DELETEBUTTON));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(300, 100);
        button.setMargin(new Insets(0, 0, 0, 0));

        buttonPanel.add(button);

        // Button to GameFrame
        button = new JButton();
        button.setIcon(PictureFactory.getImageIcon(Picture.NEXTBUTTON));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (deckTanaman.getArrayDeck().size() < deckTanaman.getMaxDeckSize()) {
                    JOptionPane.showMessageDialog(null, "Deck belum penuh");
                    return;
                } else {
                    GameManager gameManager = new GameManager();
                    gameManager.startTimer();
                    GameFrame frame = new GameFrame(gameManager);
                    frame.setVisible(true);
                    dispose();

                }
            }
        });
        button.setBounds(screenWidth - 445, screenHeight - 163, 457, 121);

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
