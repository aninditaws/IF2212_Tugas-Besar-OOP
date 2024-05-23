package UI;

import javax.swing.*;
import java.awt.*;

public class DeckButton extends JButton {

    public boolean isCooldown = false;

    public DeckButton(Icon icon) {
        super(icon);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isCooldown) {
            g.setColor(new Color(0, 0, 0, 128));
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g.setColor(new Color(0, 0, 0, 0));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
