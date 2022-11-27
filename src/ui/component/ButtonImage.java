package ui.component;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class ButtonImage extends JButton {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            Graphics2D dessin = (Graphics2D) g;

            int height = getHeight();
            int width = height * image.getWidth(null) / image.getHeight(null);
            if (width < getWidth()) {
                width = getWidth();
                height = width * image.getHeight(null) / image.getWidth(null);
            }
            dessin.drawImage(image, getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, width, height, null);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || image == null) {
            return super.getPreferredSize();
        }
        return new Dimension(image.getWidth(null), image.getHeight(null));
    }
}
