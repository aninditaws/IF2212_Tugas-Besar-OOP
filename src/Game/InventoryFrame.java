package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Inventory.*;
import Picture.*;
import Plant.*;

public class InventoryFrame extends JFrame {
    private Inventory inventory;
    private DeckTanaman deckTanaman;
    private JLayeredPane layeredPane;
    private Dimension screenSize;
    private java.util.List<JButton> plantButtons;

    public InventoryFrame() {
        setTitle("Michael vs. Lalapan");
        inventory = new Inventory();
        deckTanaman = new DeckTanaman(6);
        plantButtons = new ArrayList<>();

        initializeFrame();
        initializeComponents();
        setVisible(true);
    }

    private void initializeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    private void initializeComponents() {
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        addBackgroundImage();
        addDeckPanel();
        addPlantButtonsPanel();
        addControlButtons();

        add(layeredPane, BorderLayout.CENTER);
    }

    private void addBackgroundImage() {
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.INVENTORY);
        Image image = imageIcon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenSize.width, screenSize.height);
        layeredPane.add(label, Integer.valueOf(0));
    }

    private void addDeckPanel() {
        JPanel deckPanel = new JPanel();
        deckPanel.setPreferredSize(new Dimension(150, 150));
        deckPanel.setBounds(34, 148, 150, 600);
        deckPanel.setLayout(new GridLayout(6, 1));
        deckPanel.setOpaque(false);
        layeredPane.add(deckPanel, BorderLayout.WEST, Integer.valueOf(0));
    }

    private void addPlantButtonsPanel() {
        JPanel plantButtonsPanel = new JPanel();
        plantButtonsPanel.setOpaque(false);
        plantButtonsPanel.setLayout(new GridLayout(3, 4, 10, 10));

        int index = 0;
        for (PlantImage plantImage : PlantImage.values()) {
            final int currentIndex = index;
            ImageIcon imageIcon = new ImageIcon(plantImage.getImagePath());
            int imageWidth = 155;
            int imageHeight = 93;
            Image image = imageIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            JButton button = createPlantButton(imageIcon, currentIndex);

            plantButtonsPanel.add(button);
            plantButtons.add(button);

            inventory.addPlantButton(button);

            index++;
        }

        int panelWidth = plantButtonsPanel.getPreferredSize().width;
        int panelHeight = plantButtonsPanel.getPreferredSize().height;
        int panelX = (screenSize.width - panelWidth) / 2 - 100;
        int panelY = (screenSize.height - panelHeight) / 2 - 100;
        plantButtonsPanel.setBounds(panelX, panelY, panelWidth, panelHeight);

        layeredPane.add(plantButtonsPanel, Integer.valueOf(2));
    }

    private JButton createPlantButton(ImageIcon imageIcon, int index) {
        JButton button = new JButton();
        button.setIcon(imageIcon);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(new Dimension(155, 93));
        button.addActionListener(e -> handlePlantButtonClick(index, button));
        return button;
    }

    private void handlePlantButtonClick(int index, JButton button) {
        Plant clickedPlant = inventory.getPlant(index);
        JButton clonedButton = new JButton(button.getIcon());
        if (button.isEnabled()) {
            if (deckTanaman.getArrayDeck().contains(clickedPlant)) {
                deckTanaman.getArrayDeck().remove(clickedPlant);
                button.setBorder(null);
                reenableAllButtons();
                removeButtonFromDeck(clonedButton);
            } else {
                if (deckTanaman.getArrayDeck().size() < deckTanaman.getMaxDeckSize()) {
                    inventory.chooseTanaman(clickedPlant, deckTanaman, inventory);
                    button.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                    addButtonToDeck(clonedButton);
                }
            }
            deckTanaman.printDeck();
            disableButtonsIfMaxReached();
        }
    }

    private void addButtonToDeck(JButton button) {
        JPanel deckPanel = (JPanel) layeredPane.getComponentAt(34, 148);
        deckPanel.add(button);
        deckPanel.revalidate();
        deckPanel.repaint();
    }

    private void removeButtonFromDeck(JButton button) {
        JPanel deckPanel = (JPanel) layeredPane.getComponentAt(34, 148);
        for (Component component : deckPanel.getComponents()) {
            if (component instanceof JButton && ((JButton) component).getIcon().equals(button.getIcon())) {
                deckPanel.remove(component);
                deckPanel.revalidate();
                deckPanel.repaint();
                break;
            }
        }
    }

    private void addControlButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(1, 3, 0, 0));
        buttonPanel.setBounds((screenSize.width - 810) / 2, screenSize.height - 195, 600, 100);

        addButton(buttonPanel, Picture.CLEARBUTTON, e -> clearDeck());
        addButton(buttonPanel, Picture.SWAPBUTTON, e -> swapPlants());
        addButton(buttonPanel, Picture.DELETEBUTTON, e -> deleteSelectedPlants());

        layeredPane.add(buttonPanel, Integer.valueOf(3));
        addPlayButton();
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private void addButton(JPanel panel, Picture picture, ActionListener actionListener) {
        JButton button = new JButton();
        button.setIcon(PictureFactory.getImageIcon(picture));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(400, 100);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.addActionListener(actionListener);
        panel.add(button);
    }

    private void clearDeck() {
        deckTanaman.clearDeck();
        reenableAllButtons();
        for (JButton button : plantButtons) {
            button.setBorder(null);
        }
        JPanel deckPanel = (JPanel) layeredPane.getComponentAt(34, 148);
        deckPanel.removeAll();
        deckPanel.revalidate();
        deckPanel.repaint();
    }

    private void swapPlants() {
        // Implement swap functionality

    }

    private void deleteSelectedPlants() {
        JPanel deckPanel = (JPanel) layeredPane.getComponentAt(34, 148);

        for (Component component : deckPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int buttonIndex = deckPanel.getComponentZOrder(button);
                        // System.out.println("Button index: " + buttonIndex);

                        if (buttonIndex != -1 && buttonIndex < deckTanaman.getArrayDeck().size()) {
                            deckPanel.remove(button);
                            deckPanel.revalidate();
                            deckPanel.repaint();
                            Plant removedPlant = deckTanaman.getArrayDeck().remove(buttonIndex);

                            for (int i = 0; i < inventory.getPlantInventory().size(); i++) {
                                Plant plant = inventory.getPlant(i);
                                if (plant.equals(removedPlant)) {
                                    inventory.removePlantBorder(i);
                                    reenableAllButtons();
                                    break;

                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void addPlayButton() {
        JButton playButton = new JButton();
        playButton.setIcon(PictureFactory.getImageIcon(Picture.NEXTBUTTON));
        playButton.setOpaque(false);
        // playButton.setContentAreaFilled(false);
        // playButton.setBorder(null);
        playButton.setMargin(new Insets(0, 0, 0, 0));
        playButton.setBounds(screenSize.width - 350, screenSize.height - 145, 242, 61);
        playButton.addActionListener(e -> startGame());

        layeredPane.add(playButton, Integer.valueOf(3));
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    private void startGame() {
        if (deckTanaman.getArrayDeck().size() == deckTanaman.getMaxDeckSize()) {
            GameManager gameManager = new GameManager();
            gameManager.startTimer();
            GameFrame frame = new GameFrame(gameManager);
            frame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Deck Tanaman belum penuh");
        }
    }

    private void reenableAllButtons() {
        for (JButton button : plantButtons) {
            button.setEnabled(true);
        }
    }

    private void disableButtonsIfMaxReached() {
        if (deckTanaman.getArrayDeck().size() >= deckTanaman.getMaxDeckSize()) {
            for (JButton button : plantButtons) {
                if (!deckTanaman.getArrayDeck().contains(inventory.getPlant(plantButtons.indexOf(button)))) {
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
