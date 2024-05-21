package Game;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import Inventory.DeckTanaman;

public class DeckPanel extends JPanel {
    private DeckTanaman deckTanaman;

    public DeckPanel(DeckTanaman deckTanaman) {
        this.deckTanaman = deckTanaman;
        initializeComponents();
    }

    public DeckTanaman getDeckTanaman() {
        return this.deckTanaman;
    }

    public void initializeComponents() {

        setPreferredSize(new Dimension(150, 150));
        setLayout(new GridLayout(6, 1));
        setOpaque(false);
        setBounds(34, 148, 150, 600);

    }

    public void disableAllButtonFunctionality() {
        for (Component component : getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                // Remove action listener
                ActionListener[] listeners = button.getActionListeners();
                for (ActionListener listener : listeners) {
                    button.removeActionListener(listener);
                }
            }
        }
    }

}
