package ui.component;

import fc.movie.Movie;
import ui.util.GBC;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.net.URL;

public class MovieButton extends JPanel {
    private Movie movie;
    private final ImageButton posterBtn;
    private final TextButton titleBtn;

    public MovieButton() {
        this(null);
    }

    public MovieButton(Movie movie) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);

        posterBtn = new ImageButton();
        posterBtn.setAutoResizing(ImageButton.HEIGHT);
        posterBtn.setText("<html><p style=\"text-align:center;\">no<br>poster<br>available</p>");
        posterBtn.setForeground(Color.GRAY);
        posterBtn.setFont(posterBtn.getFont().deriveFont(Font.BOLD, 14f));

        titleBtn = new TextButton();
        titleBtn.setFont(titleBtn.getFont().deriveFont(Font.BOLD, 13f));

        setMovie(movie);

        add(posterBtn, GBC.placeAt(0, 0).setFill(GBC.BOTH).setWeight(1, 1));
        add(titleBtn, GBC.placeAt(0, 1).setWeightX(1));
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;

        if (movie == null) {
            titleBtn.setText(null);
            posterBtn.setImage(null);
        } else {
            titleBtn.setText(movie.getTitle());
            posterBtn.setImage(null);
            new Thread(() -> {
                try {
                    posterBtn.setImage(ImageIO.read(new URL(movie.getPosterURL())));
                } catch (Exception e) {
                    posterBtn.setImage(null);
                }
            }).start();
        }
    }

    @Override
    public void setFont(Font font) {
        if (isFontSet()) {
            posterBtn.setFont(font.deriveFont(Font.BOLD));
            titleBtn.setFont(font);
        }
        super.setFont(font);
    }

    public void addActionListener(ActionListener actionListener) {
        posterBtn.addActionListener(actionListener);
        titleBtn.addActionListener(actionListener);
    }
}
