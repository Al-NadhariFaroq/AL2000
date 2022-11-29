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

    private Color textColor;
    private Color enteredColor;
    private Color pressedColor;

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

        textColor = getForeground();
        enteredColor = textColor.darker().darker();
        pressedColor = textColor.brighter().brighter();
    }

    public int getEnteredFeedback() {
        return enteredFeedback;
    }

    public void setEnteredFeedback(int enteredFeedback) {
        if (enteredFeedback < NONE || enteredFeedback > BOTH) {
            throw new IllegalArgumentException("Invalid enteredFeedback value");
        }
        this.enteredFeedback = enteredFeedback;
    }

    public int getPressedFeedback() {
        return pressedFeedback;
    }

    public void setPressedFeedback(int pressedFeedback) {
        if (pressedFeedback < NONE || pressedFeedback > BOTH) {
            throw new IllegalArgumentException("Invalid pressedFeedback value");
        }
        this.pressedFeedback = pressedFeedback;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        setForeground(textColor);
    }

    public Color getEnteredColor() {
        return enteredColor;
    }

    public void setEnteredColor(Color enteredColor) {
        this.enteredColor = enteredColor;
    }

    public Color getPressedColor() {
        return pressedColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void setUnderline(boolean underline) {
        Map attributes = getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, underline ? TextAttribute.UNDERLINE_ON : null);
        setFont(getFont().deriveFont(attributes));
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            private boolean isEntered = false;
            private boolean isPressed = false;

            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnabled()) {
                    isPressed = true;
                    if (pressedFeedback == COLOR || pressedFeedback == BOTH) {
                        setForeground(pressedColor);
                    }
                    if (pressedFeedback == UNDERLINE || pressedFeedback == BOTH) {
                        setUnderline(true);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isEnabled()) {
                    isPressed = false;
                    if (pressedFeedback == COLOR || pressedFeedback == BOTH) {
                        setForeground(isEntered ? enteredColor : textColor);
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
                    isEntered = true;
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    if ((enteredFeedback == COLOR || enteredFeedback == BOTH) && !isPressed) {
                        setForeground(enteredColor);
                    }
                    if (enteredFeedback == UNDERLINE || enteredFeedback == BOTH) {
                        setUnderline(true);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isEnabled()) {
                    isEntered = false;
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    if ((enteredFeedback == COLOR || enteredFeedback == BOTH) && !isPressed) {
                        setForeground(textColor);
                    }
                    if (enteredFeedback == UNDERLINE || enteredFeedback == BOTH) {
                        setUnderline(false);
                    }
                }
            }
        };
    }
}
