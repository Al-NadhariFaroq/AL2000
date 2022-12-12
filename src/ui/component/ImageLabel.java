package ui.component;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ImageLabel extends JLabel {

    private class ImageLabelComponentListener extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent e) {
            autoResize();
        }
    }

    public static final int NONE = 0;
    public static final int WIDTH = 1;
    public static final int HEIGHT = 2;

    private Image image;
    private String defaultText;
    private int autoResizing;

    public ImageLabel() {
        this(null, "", NONE);
    }

    public ImageLabel(Image image) {
        this(image, "", NONE);
    }

    public ImageLabel(Image image, String defaultText, int autoResizing) {
        super();
        addComponentListener(new ImageLabelComponentListener());

        setAutoResizing(autoResizing);
        setDefaultText(defaultText);
        setImage(image);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        setText(image == null ? defaultText : "");
        autoResize();
    }

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
        if (image == null) {
            setText(defaultText);
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

    private void autoResize() {
        if (getImage() != null && autoResizing != NONE) {
            int imgWidth = getImage().getWidth(null);
            int imgHeight = getImage().getHeight(null);
            Dimension size = getSize();
            if (autoResizing == WIDTH) {
                size.width = imgWidth * size.height / imgHeight;
            } else if (autoResizing == HEIGHT) {
                size.height = imgHeight * size.width / imgWidth;
            }
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            revalidate();
            repaint();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || image == null) {
            return super.getPreferredSize();
        }
        return new Dimension(image.getWidth(null), image.getHeight(null));
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
            g2d.drawImage(image, getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, width, height, null);
        }
    }
}
