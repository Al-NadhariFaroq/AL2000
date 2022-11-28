package ui.component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class ButtonText extends JButton {
    public static final int NONE = 0;
    public static final int COLOR = 1;
    public static final int UNDERLINE = 2;
    public static final int BOTH = 3;

    private int enteredFeedback;
    private int pressedFeedback;

    public ButtonText() {
        this(null);
    }

    public ButtonText(String text) {
        super(text);
        setBorder(BorderFactory.createEmptyBorder());
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        addMouseListener(createMouseListener());

        enteredFeedback = BOTH;
        pressedFeedback = COLOR;
    }

    public int getEnteredFeedback() {
        return enteredFeedback;
    }

    public int getPressedFeedback() {
        return pressedFeedback;
    }

    public void setEnteredFeedback(int enteredFeedback) {
        if (enteredFeedback < NONE || enteredFeedback > BOTH) {
            throw new IllegalArgumentException("Invalid enteredFeedback value");
        }
        this.enteredFeedback = enteredFeedback;
    }

    public void setPressedFeedback(int pressedFeedback) {
        if (pressedFeedback < NONE || pressedFeedback > BOTH) {
            throw new IllegalArgumentException("Invalid pressedFeedback value");
        }
        this.pressedFeedback = pressedFeedback;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void setUnderline(boolean underline) {
        Map attributes = getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, underline ? TextAttribute.UNDERLINE_ON : null);
        setFont(getFont().deriveFont(attributes));
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            private Color enteredColor;
            private Color pressedColor;

            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnabled()) {
                    if (pressedFeedback == COLOR || pressedFeedback == BOTH) {
                        pressedColor = enteredColor == null ? getForeground() : enteredColor;
                        setForeground(pressedColor.brighter().brighter());
                    }
                    if (pressedFeedback == UNDERLINE || pressedFeedback == BOTH) {
                        setUnderline(true);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isEnabled()) {
                    if (pressedFeedback == COLOR || pressedFeedback == BOTH) {
                        setForeground(pressedColor);
                        pressedColor = null;
                    }
                    if ((pressedFeedback == UNDERLINE || pressedFeedback == BOTH) &&
                        (enteredFeedback != UNDERLINE && enteredFeedback != BOTH)) {
                        setUnderline(false);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (isEnabled()) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    if ((enteredFeedback == COLOR || enteredFeedback == BOTH) && pressedColor == null) {
                        enteredColor = getForeground();
                        setForeground(enteredColor.darker().darker());
                    }
                    if (enteredFeedback == UNDERLINE || enteredFeedback == BOTH) {
                        setUnderline(true);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isEnabled()) {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    if ((enteredFeedback == COLOR || enteredFeedback == BOTH) && pressedColor == null) {
                        setForeground(enteredColor);
                        enteredColor = null;
                    }
                    if (enteredFeedback == UNDERLINE || enteredFeedback == BOTH) {
                        setUnderline(false);
                    }
                }
            }
        };
    }
}
