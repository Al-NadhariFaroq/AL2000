package ui.component;

import javax.swing.JButton;
import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonImage extends JButton {
    public static final int NONE = 0;
    public static final int WIDTH = 1;
    public static final int HEIGHT = 2;

    private Image image;
    private String defaultText;
    private int autoResizing;
    private boolean isPressed;

    public ButtonImage() {
        this(null, "", NONE);
    }

    public ButtonImage(Image image) {
        this(image, "", NONE);
    }

    public ButtonImage(Image image, String defaultText, int autoResizing) {
        super();
        setContentAreaFilled(false);
        setFocusPainted(false);
        addMouseListener(createMouseListener());
        addComponentListener(createComponentListener());

        setAutoResizing(autoResizing);
        setText(defaultText);
        setImage(image);
        isPressed = false;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        super.setText(image == null ? defaultText : "");
        repaint();
    }

    @Override
    public void setText(String defaultText) {
        this.defaultText = defaultText;
        if (image == null) {
            super.setText(defaultText);
        }
    }

    public int getAutoResizing() {
        return autoResizing;
    }

    public void setAutoResizing(int autoResizing) {
        if (autoResizing != NONE && autoResizing != WIDTH && autoResizing != HEIGHT) {
            throw new IllegalArgumentException("Invalid autoResizing value");
        }
        this.autoResizing = autoResizing;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            Graphics2D g2d = (Graphics2D) g;

            int height = getHeight();
            int width = height * image.getWidth(null) / image.getHeight(null);
            if (width < getWidth()) {
                width = getWidth();
                height = width * image.getHeight(null) / image.getWidth(null);
            }
            if (!isEnabled() || isPressed) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
            }
            g2d.drawImage(image, getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, width, height, null);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || image == null) {
            return super.getPreferredSize();
        }
        return new Dimension(image.getWidth(null), image.getHeight(null));
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (isEnabled()) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isEnabled()) {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        };
    }

    private ComponentListener createComponentListener() {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getImage() != null && autoResizing != NONE) {
                    int imgWidth = getImage().getWidth(null);
                    int imgHeight = getImage().getHeight(null);
                    Dimension btnSize = getSize();
                    if (autoResizing == WIDTH) {
                        btnSize.width = imgWidth * btnSize.height / imgHeight;
                    } else if (autoResizing == HEIGHT) {
                        btnSize.height = imgHeight * btnSize.width / imgWidth;
                    }
                    setPreferredSize(btnSize);
                } else {
                    super.componentResized(e);
                }
            }
        };
    }
}
