package Game;

import javax.swing.JPanel;
import java.awt.*;
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
        setLayout(new GridLayout(6, 1));

    }

}
