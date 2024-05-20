package UI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomButtonUI extends BasicButtonUI {
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JButton button = (JButton) c;
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setRolloverEnabled(false); // Disable rollover effect
        button.setFocusable(false); // Disable focusable state
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        // Only paint the icon, skip background and border painting
        AbstractButton button = (AbstractButton) c;
        Icon icon = button.getIcon();
        if (icon != null) {
            icon.paintIcon(c, g, (c.getWidth() - icon.getIconWidth()) / 2, (c.getHeight() - icon.getIconHeight()) / 2);
        }
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        // Do not paint button pressed state
    }

    @Override
    public void update(Graphics g, JComponent c) {
        // Custom update method to prevent background painting
        paint(g, c);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        // Do not paint focus indicator
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        // Do not paint text
    }

    @Override
    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        // Ensure icon is painted without additional effects
        AbstractButton b = (AbstractButton) c;
        Icon icon = b.getIcon();

        if (icon != null) {
            icon.paintIcon(c, g, iconRect.x, iconRect.y);
        }
    }
}
