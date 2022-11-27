package ui.component;

import fc.Movie;
import ui.util.GBC;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.util.Map;

public class MovieButton extends JPanel {
    Movie movie;
    private final ButtonImage posterBtn;
    private final JButton titleBtn;

    public MovieButton(Movie movie) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder());
        setBackground(null);

        posterBtn = new ButtonImage();
        posterBtn.setForeground(Color.GRAY);
        posterBtn.setFont(posterBtn.getFont().deriveFont(Font.BOLD));
        posterBtn.setContentAreaFilled(false);
        posterBtn.setFocusPainted(false);
        posterBtn.addComponentListener(createComponentListener());

        titleBtn = new JButton();
        titleBtn.setHorizontalAlignment(SwingConstants.CENTER);
        titleBtn.setFont(titleBtn.getFont().deriveFont(Font.BOLD));
        titleBtn.setBorder(BorderFactory.createEmptyBorder());
        titleBtn.setBackground(new Color(0, 0, 0, 255));
        titleBtn.setContentAreaFilled(false);
        titleBtn.setFocusPainted(false);
        titleBtn.addMouseListener(createMouseListener());

        setMovie(movie);

        add(posterBtn, GBC.placeAt(0, 0).setFill(GBC.BOTH).setWeight(1, 1));
        add(titleBtn, GBC.placeAt(0, 1));
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;

        titleBtn.setText(movie.getTitle());
        try {
            posterBtn.setText(null);
            posterBtn.setImage(ImageIO.read(new URL(movie.getPosterURL())));
        } catch (Exception e) {
            posterBtn.setImage(null);
            posterBtn.setText("<html><p style=\"text-align:center;\">no<br>poster<br>available</p>");
        }
    }

    public void addActionListener(ActionListener actionListener) {
        posterBtn.addActionListener(actionListener);
        titleBtn.addActionListener(actionListener);
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                e.getComponent().setForeground(getForeground().brighter().brighter());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                e.getComponent().setForeground(getForeground());
            }

            @SuppressWarnings({"rawtypes", "unchecked"})
            @Override
            public void mouseEntered(MouseEvent e) {
                Component button = e.getComponent();
                Font font = button.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                button.setFont(font.deriveFont(attributes));
            }

            @SuppressWarnings({"rawtypes", "unchecked"})
            @Override
            public void mouseExited(MouseEvent e) {
                Component button = e.getComponent();
                Font font = button.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, null);
                button.setFont(font.deriveFont(attributes));
            }
        };
    }

    private ComponentListener createComponentListener() {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (posterBtn.getImage() != null) {
                    Dimension btnSize = posterBtn.getSize();
                    int imgWidth = posterBtn.getImage().getWidth(null);
                    int imgHeight = posterBtn.getImage().getHeight(null);
                    btnSize.height = imgHeight * btnSize.width / imgWidth;
                    posterBtn.setPreferredSize(btnSize);
                } else {
                    super.componentResized(e);
                }
            }
        };
    }
}
