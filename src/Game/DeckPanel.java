package Game;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import Inventory.DeckTanaman;
import Picture.PlantImage;

public class DeckPanel extends JPanel {
    private DeckTanaman deckTanaman;
    JButton selectedDeckButton;

    public DeckPanel(DeckTanaman deckTanaman) {
        this.deckTanaman = deckTanaman;
        initializeComponents();
    }

    public DeckTanaman getDeckTanaman() {
        return this.deckTanaman;
    }

    public JButton getSelectedDeckButton() {
        return this.selectedDeckButton;
    }

    public void setSelectedDeckButton(JButton selectedDeckButton) {
        this.selectedDeckButton = selectedDeckButton;
    }

    public void initializeComponents() {

        setPreferredSize(new Dimension(150, 150));
        setLayout(new GridLayout(6, 1));
        setOpaque(false);
        setBounds(34, 148, 150, 600);

        for (PlantImage plantImage : PlantImage.values()) {
            JButton button = new JButton();
            button.setIcon(plantImage.getImageIcon());
            button.setName(plantImage.name()); // Set the name of the button to the enum constant name
            button.addActionListener(e -> setSelectedDeckButton(button));
            add(button);
        }

    }

}
