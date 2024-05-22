package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import Inventory.*;
import Picture.*;
import Plant.*;

public class InventoryFrame extends JFrame {
    // Attributes

    // Attributes "Backend" buat inventory
    private Inventory inventory;
    private DeckTanaman deckTanaman;
    // Attributes "Frontend" buat inventory
    private DeckPanel deckPanel;
    private JPanel inventoryPanel;
    // Attribut ini kepake buat ngecek apakah button udah di klik atau belum (button
    // di inventoryPanel)
    private java.util.List<JButton> plantButtons;
    /*
     * Kepake di:
     * addButtontoInventory();
     * clearDeck();
     * reenableAllButtons();
     * disableButtonsIfMaxReached();
     */

    // Attribut ini buat nyimpen button yang udah di klik (kepake buat di swap, cek
    // apa aja button yang udah di klik)
    private java.util.List<JButton> selectedButtons;
    /*
     * Kepake di:
     * swapPlants()
     * swapButtonInDeckPanel();
     * swapButtonInInventoryPanel();
     */

    // Attribut buat layerin panel-panel yang dibuat
    private JLayeredPane layeredPane;
    /*
     * Panel tiap layer:
     * layer 0: Background image, deckPanel
     * layer 1: inventoryPanel
     * layer 2: buttonPanel,menuButton,playButton
     */

    // Attribut buat ngambil ukuran layar
    private Dimension screenSize;

    // Constructor
    public InventoryFrame() {
        setTitle("Michael vs. Lalapan");
        inventory = new Inventory();
        deckTanaman = new DeckTanaman(6);
        plantButtons = new ArrayList<>();
        selectedButtons = new ArrayList<>();

        initializeFrame();
        initializeComponents();
        setVisible(true);
    }

    // Methods

    // Method buat inisialisasi frame
    private void initializeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    // Method buat inisialisasi komponen-komponen di frame
    private void initializeComponents() {
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(screenSize);

        addBackgroundImage();
        // addDeckPanel();
        deckPanel = new DeckPanel(deckTanaman);

        addinventoryPanel();
        addControlButtons();
        setDeckPanel(deckPanel);
        addMenuButton();

        add(layeredPane, BorderLayout.CENTER);
    }

    // Method buat nambahin background image
    private void addBackgroundImage() {
        ImageIcon imageIcon = PictureFactory.getImageIcon(Picture.INVENTORY);
        Image image = imageIcon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, screenSize.width, screenSize.height);
        layeredPane.add(label, Integer.valueOf(0));

    }

    // Method buat nambahin deckPanel
    public void setDeckPanel(DeckPanel deckPanel) {
        this.deckPanel = deckPanel;
        deckPanel.setPreferredSize(new Dimension(150, 150));
        deckPanel.setBounds(34, 148, 150, 600);
        deckPanel.setLayout(new GridLayout(6, 1));
        deckPanel.setOpaque(false);
        layeredPane.add(deckPanel, BorderLayout.WEST, Integer.valueOf(0));
        // add(deckPanel);
    }

    // Method buat nambahin inventoryPanel
    private void addinventoryPanel() {
        inventoryPanel = new JPanel();
        inventoryPanel.setOpaque(false);
        inventoryPanel.setLayout(new GridLayout(3, 4, 15, 15));
        // inventory.printInventory();

        addButtontoInventory();

        int inventoryWidth = inventoryPanel.getPreferredSize().width;
        int inventoryHeight = inventoryPanel.getPreferredSize().height;
        int inventoryX = (screenSize.width - inventoryWidth) / 2 - 100;
        int inventoryY = (screenSize.height - inventoryHeight) / 2 - 100;
        inventoryPanel.setBounds(inventoryX, inventoryY, inventoryWidth, inventoryHeight);

        layeredPane.add(inventoryPanel, Integer.valueOf(1));
    }

    // Masukin Plants dalam bentuk JButton ke dalam inventoryPanel
    private void addButtontoInventory() {
        plantButtons.clear();
        for (int i = 0; i < 10 && i < PlantImage.values().length; i++) {
            PlantImage plantImage = PlantImage.values()[i];
            final int currentIndex = i;
            ImageIcon imageIcon = new ImageIcon(plantImage.getImagePath());
            int imageWidth = 155;
            int imageHeight = 93;
            Image image = imageIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            JButton button = createPlantButton(imageIcon, currentIndex);

            inventoryPanel.add(button);
            plantButtons.add(button);

            inventory.addPlantButton(button);
        }

    }

    // Method buat simpen original action listener dari plantButtons
    /*
     * Dia ini kepake di control buttons: clearDeck, swapPlants,
     * deleteSelectedPlants
     * Jadi kalau kita klik 1 button kita matiin 2 button lainnya
     * Terus kalau kita klik lagi, kita idupin lagi 2 button lainnya
     * 
     * Kepake di:
     * createPlantButton(ImageIcon imageIcon, int index)
     * addButton();
     */
    private Map<JButton, ActionListener> originalPlantButtonListeners = new HashMap<>();

    // Method ngebuat JButton dari Plants
    private JButton createPlantButton(ImageIcon imageIcon, int index) {
        JButton button = new JButton(imageIcon);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(new Dimension(155, 93));
        ActionListener listener = e -> handlePlantButtonClick(index, button);
        button.addActionListener(listener);
        originalPlantButtonListeners.put(button, listener);

        return button;
    }

    // Method buat simpen original action listener dari deckButtons
    /*
     * Dia ini kepake di control buttons: clearDeck, swapPlants,
     * deleteSelectedPlants
     * Jadi kalau kita klik 1 button kita matiin 2 button lainnya
     * Terus kalau kita klik lagi, kita idupin lagi 2 button lainnya
     * 
     * Kepake di:
     * handlePlantButtonClick(int index, JButton button)
     * handleDeckButtonClick(JButton button)
     */
    private Map<JButton, ActionListener> originalDeckButtonListeners = new HashMap<>();

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

                    // nyimpen action listenernya di sini
                    ActionListener originalListener = e -> handleDeckButtonClick(clonedButton);
                    clonedButton.addActionListener(originalListener);
                    originalDeckButtonListeners.put(clonedButton, originalListener);

                    // Debugging aja ini buat liat button apa yang dipencet
                    // clonedButton.setName(PlantImage.values()[index].name());
                    // System.out.println("Button name: " + clonedButton.getName());
                }
            }
            deckTanaman.printDeck();
            disableButtonsIfMaxReached();
        }
    }

    // Method buat bisa remove by click dari button di deckPanel
    /*
     * Kepake di:
     * handlePlantButtonClick(int index, JButton button)
     */
    private void handleDeckButtonClick(JButton button) {
        int buttonIndex = deckPanel.getComponentZOrder(button);
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

    // Method buat masukin button ke dalam deckPanel
    /*
     * Kepake di:
     * handlePlantButtonClick(int index, JButton button);
     */
    private void addButtonToDeck(JButton button) {
        deckPanel.add(button);
        deckPanel.revalidate();
        deckPanel.repaint();
    }

    // Method buat apus button dari deckPanel
    /*
     * Kepake di:
     * handlePlantButtonClick(int index, JButton button);
     */
    private void removeButtonFromDeck(JButton button) {
        for (Component component : deckPanel.getComponents()) {
            if (component instanceof JButton && ((JButton) component).getIcon().equals(button.getIcon())) {
                deckPanel.remove(component);
                deckPanel.revalidate();
                deckPanel.repaint();
                break;
            }
        }
    }

    // Method buat ngehandle button click di 3 control buttons: clearDeck,
    // swapPlants, deleteSelectedPlants
    // Attribut buat simpen keadaan buttonnya lagi on atau off
    private Map<JToggleButton, Boolean> controlBtnStates;
    // Attribut buat ngecek apakah deleteSelectedPlants udah di klik atau belum
    private boolean deleteSelectedPlantsActive = false;

    // Method buat nge-add control buttons: clearDeck, swapPlants,
    // deleteSelectedPlants
    private void addControlButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        // buttonPanel.setBackground(Color.red);
        buttonPanel.setLayout(new GridLayout(1, 3, 0, 0));
        buttonPanel.setBounds((screenSize.width - 810) / 2, screenSize.height - 195, 600, 100);
        controlBtnStates = new HashMap<>();

        addButton(buttonPanel, Picture.CLEARBUTTON, e -> clearDeck());
        addButton(buttonPanel, Picture.SWAPBUTTON, e -> swapPlants());
        addButton(buttonPanel, Picture.DELETEBUTTON, e -> deleteSelectedPlants());

        layeredPane.add(buttonPanel, Integer.valueOf(2));
        addPlayButton();
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    // Method buat addButton
    /*
     * Sebenarnya method ini cuman kepake buat 3 control button itu aja
     * Jadi yang terjadi adalah ketika kita klik salah satu button, button lainnya
     * akan mati
     * Terus kalau kita klik lagi, button lainnya akan idup lagi
     */
    private void addButton(JPanel panel, Picture picture, ActionListener actionListener) {
        JToggleButton button = new JToggleButton();
        button.setIcon(PictureFactory.getImageIcon(picture));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setSize(400, 100);
        button.setMargin(new Insets(0, 0, 0, 0));

        button.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (actionListener != null) {
                    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
                }
            } else {
                // Ini buat balikin button ke state awal
                for (Map.Entry<JButton, ActionListener> entry : originalPlantButtonListeners.entrySet()) {
                    JButton plantButton = entry.getKey();
                    ActionListener originalListener = entry.getValue();
                    for (ActionListener listener : plantButton.getActionListeners()) {
                        plantButton.removeActionListener(listener);
                    }
                    plantButton.addActionListener(originalListener);
                }
                // Reattach the original action listeners to deck buttons
                for (Map.Entry<JButton, ActionListener> entry : originalDeckButtonListeners.entrySet()) {
                    JButton deckButton = entry.getKey();
                    ActionListener originalListener = entry.getValue();
                    for (ActionListener listener : deckButton.getActionListeners()) {
                        deckButton.removeActionListener(listener);
                    }
                    deckButton.addActionListener(originalListener);
                }
            }
        });

        panel.add(button);
        controlBtnStates.put(button, false);
    }

    // Method buat masukin menu button ( yang di pojok atas )
    private void addMenuButton() {
        JButton menuButton = new JButton();
        menuButton.setIcon(PictureFactory.getImageIcon(Picture.MENUBUTTON));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(null);
        menuButton.setMargin(new Insets(0, 0, 0, 0));
        menuButton.setBounds(screenSize.width - 300, screenSize.height - 850, 242, 95);
        // kalau diklik dia bakal ke WelcomingFrame
        menuButton.addActionListener(e -> {
            WelcomingFrame mainMenuFrame = new WelcomingFrame();
            mainMenuFrame.setVisible(true);
            dispose();
        });

        layeredPane.add(menuButton, Integer.valueOf(2));
        layeredPane.revalidate();
        layeredPane.repaint();

    }

    // Method buat nge-clear deck
    /*
     * Jadi ini dia apus button yang ada di deckPanel
     * juga ngeapus semua plant yang ada di deckTanaman
     * Selain itu dia ngestate ulang inventory, soalnya kalo kita swap-swap plant di
     * inventory, method ini balikin ke state awal
     * ini juga nge-clear plantButtons, soalnya kalo ga di-clear dia bakal redundant
     */
    private void clearDeck() {
        deckTanaman.clearDeck(); // ini method cleardeck di deckTanaman ygy beda sama yang ada di inventoryframe
        inventory.clearPlants();
        inventory.clearPlantButtons();
        inventory.initializeInventory();
        addButtontoInventory();
        reenableAllButtons();
        for (JButton button : plantButtons) {
            button.setBorder(null);
        }
        deckPanel.removeAll();
        deckPanel.revalidate();
        deckPanel.repaint();
        layeredPane.remove(inventoryPanel);
        addinventoryPanel();
    }

    // Method buat apus actionListeners pada suatu component
    /*
     * kepake di:
     * swapPlants();
     */
    private void removeActionListeners(Component[] components) {
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                for (ActionListener listener : button.getActionListeners()) {
                    button.removeActionListener(listener);
                }
            }
        }
    }

    // Method buat swap Plants di deckPanel dan di inventoryPanel
    /*
     * Pertama, matiin dulu 2 action listener lainnya
     * terus baru de kita tuker tuker plantnya di deckPanel dan inventoryPanel
     * pastiin plant ga bisa nuker antar deckPanel dan inventoryPanel
     */
    private void swapPlants() {
        removeActionListeners(deckPanel.getComponents());
        removeActionListeners(inventoryPanel.getComponents());

        for (Component component : deckPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addActionListener(e -> {
                    if (selectedButtons.contains(button)) {
                        selectedButtons.remove(button);
                        button.setBorder(null);
                    } else {
                        if (selectedButtons.size() < 2) {
                            selectedButtons.add(button);
                            button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
                            if (selectedButtons.size() == 2 && isButtonSamePanel(selectedButtons, deckPanel)) {
                                swapButtonInDeckPanel(selectedButtons.get(0), selectedButtons.get(1));
                            }
                        }
                    }
                });
            }
        }

        for (Component component : inventoryPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addActionListener(e -> {
                    if (selectedButtons.contains(button)) {
                        selectedButtons.remove(button);
                        button.setBorder(null);
                    } else {
                        if (selectedButtons.size() < 2) {
                            selectedButtons.add(button);
                            button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
                            if (selectedButtons.size() == 2 && isButtonSamePanel(selectedButtons, inventoryPanel)) {
                                swapButtonInInventoryPanel(selectedButtons.get(0), selectedButtons.get(1));
                            }
                        }
                    }
                });
            }
        }
    }

    // Method buat ngecek apakah button yang di klik itu di panel yang sama atau
    // engga (deckPanel atau inventoryPanel)
    private boolean isButtonSamePanel(List<JButton> buttons, JPanel panel) {
        for (JButton button : buttons) {
            if (button.getParent() != panel) {
                return false;
            }
        }
        return true;
    }

    /*
     * Method swap di deckPanel dan di inventoryPanel tu isinya sama
     * tapi karena ada main di back-endnya (mereka ngambil beda object)
     * jadinya dibedain
     */
    // Method buat swap button di deckPanel
    private void swapButtonInDeckPanel(JButton btn1, JButton btn2) {
        int idx1 = deckPanel.getComponentZOrder(btn1);
        int idx2 = deckPanel.getComponentZOrder(btn2);

        deckPanel.add(btn2, idx1);
        deckPanel.add(btn1, idx2);
        // pembeda dengan swapButtonInInventoryPanel
        Plant plant1 = deckTanaman.getArrayDeck().get(idx1);
        Plant plant2 = deckTanaman.getArrayDeck().get(idx2);
        inventory.Switch(deckTanaman, plant1, plant2);

        deckPanel.revalidate();
        deckPanel.repaint();

        selectedButtons.clear();
        btn1.setBorder(null);
        btn2.setBorder(null);
    }

    // Method buat swap button di inventoryPanel
    private void swapButtonInInventoryPanel(JButton btn1, JButton btn2) {
        int idx1 = inventoryPanel.getComponentZOrder(btn1);
        int idx2 = inventoryPanel.getComponentZOrder(btn2);

        inventoryPanel.add(btn2, idx1);
        inventoryPanel.add(btn1, idx2);
        // pembeda dengan swapButtonInDeckPanel
        Plant plant1 = inventory.getPlant(idx1);
        Plant plant2 = inventory.getPlant(idx2);
        inventory.Switch(plant1, plant2);

        inventoryPanel.revalidate();
        inventoryPanel.repaint();

        selectedButtons.clear();
        btn1.setBorder(null);
        btn2.setBorder(null);
    }

    // Method buat nge-delete plant yang udah di klik
    private void deleteSelectedPlants() {
        if (!deleteSelectedPlantsActive) {
            JPanel deckPanel = (JPanel) layeredPane.getComponentAt(34, 148);

            for (Component component : deckPanel.getComponents()) {
                if (component instanceof JButton) {
                    JButton button = (JButton) component;
                    button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int buttonIndex = deckPanel.getComponentZOrder(button);
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
        } else {
            // Remove all action listeners from deckPanel buttons
            for (Component component : deckPanel.getComponents()) {
                if (component instanceof JButton) {
                    JButton button = (JButton) component;
                    for (MouseListener listener : button.getMouseListeners()) {
                        button.removeMouseListener(listener);
                    }
                    button.setBorder(null); // Remove any selection borders
                }
            }
        }
        deleteSelectedPlantsActive = !deleteSelectedPlantsActive; // Toggle the state
    }

    // Method buat nge-add play button
    /*
     * Ini tu yang tulisannya "Let's Rock!"
     * Kalo di klik dia bakal ke GameFrame
     */
    private void addPlayButton() {
        JButton playButton = new JButton();
        playButton.setIcon(PictureFactory.getImageIcon(Picture.NEXTBUTTON));
        playButton.setOpaque(false);
        // playButton.setContentAreaFilled(false);
        // playButton.setBorder(null);
        playButton.setMargin(new Insets(0, 0, 0, 0));
        playButton.setBounds(screenSize.width - 350, screenSize.height - 145, 242, 61);
        playButton.addActionListener(e -> startGame());

        layeredPane.add(playButton, Integer.valueOf(2));
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    // Method buat nge-start game
    private void startGame() {
        if (deckTanaman.getArrayDeck().size() == deckTanaman.getMaxDeckSize()) {
            GameManager gameManager = new GameManager();
            gameManager.startTimer();
            GameFrame frame = new GameFrame(gameManager, deckPanel);
            frame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Deck Tanaman belum penuh");
        }
    }

    // Method buat nge-enable semua button di inventoryPanel
    /*
     * Kepake di:
     * handlePlantButtonClick(int index, JButton button);
     * handleDeckButtonClick(JButton button);
     * clearDeck();
     * deleteSelectedPlants();
     */
    private void reenableAllButtons() {
        for (JButton button : plantButtons) {
            button.setEnabled(true);
        }
    }
    // Method buat matiin buttonPlant lainnya yang ga diklik pas deckTanaman udh
    // full
    /*
     * Kepake di:
     * private void handlePlantButtonClick(int index, JButton button) {
     * 
     */

    private void disableButtonsIfMaxReached() {
        if (deckTanaman.getArrayDeck().size() >= 6) {
            System.out.println("size plantButtons: " + plantButtons.size());

            for (int i = 0; i < plantButtons.size(); i++) {
                JButton button = plantButtons.get(i);
                Plant plant = inventory.getPlant(i);

                // Uncomment this line if you need to debug the plant names
                // System.out.println("Plant name: " + plant.name);

                if (!deckTanaman.getArrayDeck().contains(plant)) {
                    button.setEnabled(false);
                }

            }
        }
    }

    // Main method
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            InventoryFrame inventoryFrame = new InventoryFrame();

            inventoryFrame.setVisible(true);
        });
    }
}