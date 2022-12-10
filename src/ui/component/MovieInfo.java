package ui.component;

import fc.movie.Movie;
import ui.util.GBC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

public class MovieInfo extends JScrollPane {
    private JTextArea titleLbl;
    private JLabel dateLbl;
    private JLabel dateValueLbl;
    private JLabel ratingLbl;
    private JLabel ratingValueLbl;
    private JLabel themesLbl;
    private JTextArea themesNamesLbl;
    private JLabel directorsLbl;
    private JTextArea directorsNamesLbl;
    private JLabel actorsLbl;
    private JTextArea actorsNamesLbl;
    private JLabel synopsisLbl;
    private JTextArea synopsisValueLbl;
    private JLabel poster;

    private Movie movie;

    public MovieInfo() {
        this(null);
    }

    public MovieInfo(Movie movie) {
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        titleLbl = createTextArea();
        dateLbl = new JLabel("Release date:");
        dateValueLbl = new JLabel();
        ratingLbl = new JLabel("Rating:");
        ratingValueLbl = new JLabel();
        themesLbl = new JLabel("Themes:");
        themesNamesLbl = createTextArea();
        directorsLbl = new JLabel("Directors:");
        directorsNamesLbl = createTextArea();
        actorsLbl = new JLabel("Actors:");
        actorsNamesLbl = createTextArea();
        synopsisLbl = new JLabel("Synopsis:");
        synopsisValueLbl = createTextArea();
        poster = new JLabel();

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.add(titleLbl, GBC.placeAt(0, 0, 5, 1));
        mainPanel.add(poster, GBC.placeAt(0, 1, 1, 7));
        mainPanel.add(dateLbl, GBC.placeAt(1, 1));
        mainPanel.add(dateValueLbl, GBC.placeAt(2, 1));
        mainPanel.add(ratingLbl, GBC.placeAt(3, 1));
        mainPanel.add(ratingValueLbl, GBC.placeAt(4, 1));
        mainPanel.add(themesLbl, GBC.placeAt(1, 2, 4, 1));
        mainPanel.add(themesNamesLbl, GBC.placeAt(1, 3, 4, 1));
        mainPanel.add(directorsLbl, GBC.placeAt(1, 4, 4, 1));
        mainPanel.add(directorsNamesLbl, GBC.placeAt(1, 5, 4, 1));
        mainPanel.add(actorsLbl, GBC.placeAt(1, 6, 4, 1));
        mainPanel.add(actorsNamesLbl, GBC.placeAt(1, 7, 4, 1));
        mainPanel.add(synopsisLbl, GBC.placeAt(0, 8, 5, 1));
        mainPanel.add(synopsisValueLbl, GBC.placeAt(0, 9, 5, 1));

        setViewportView(mainPanel);

        if (movie != null) {
            setMovie(movie);
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        titleLbl.setText(movie.getTitle());
        dateValueLbl.setText(new SimpleDateFormat("dd/MM/yyyy").format(getMovie().getDate().getTime()));
        ratingValueLbl.setText(movie.getRating().toString());
        themesNamesLbl.setText(String.join(", ", movie.getThemes()));
        directorsNamesLbl.setText(String.join(", ", movie.getDirectors()));
        actorsNamesLbl.setText(String.join(", ", movie.getActors()));
        synopsisValueLbl.setText(movie.getSynopsis());

        ImageIcon image = null;
        try {
            image = new ImageIcon(ImageIO.read(new URL(movie.getPosterURL())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        poster.setIcon(image);
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setBackground(getBackground());
        textArea.setEditable(false);
        return textArea;
    }
}
