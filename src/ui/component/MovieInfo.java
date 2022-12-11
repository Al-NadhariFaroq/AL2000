package ui.component;

import fc.movie.Movie;
import fc.movie.Rating;
import ui.util.GBC;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MovieInfo extends JPanel {
    private JPanel mainPanel;
    private final ImageLabel poster;
    private final JTextPane titleValue;
    private final JLabel separator1;
    private final JLabel separator2;
    private final JLabel ratingValue;
    private final JLabel dateValue;
    private final JLabel lengthValue;
    private final JLabel synopsisLbl;
    private final JLabel directorsLbl;
    private final JLabel actorsLbl;
    private final JTextArea synopsisValue;
    private final JTextArea themesValues;
    private final JTextArea directorsValues;
    private final JTextArea actorsValues;

    private Movie movie;

    public MovieInfo() {
        this(null);
    }

    public MovieInfo(Movie movie) {
        setLayout(new GridBagLayout());

        poster = new ImageLabel();
        poster.setAutoResizing(ImageLabel.WIDTH);
        poster.setDefaultText("<html><p style=\"text-align:center;\">no<br>poster<br>available</p>");

        titleValue = new JTextPane();
        titleValue.setBackground(getBackground());
        titleValue.setEditable(false);

        separator1 = new JLabel("•");
        separator2 = new JLabel("•");
        ratingValue = new JLabel("", SwingConstants.CENTER);
        ratingValue.setBorder(BorderFactory.createLineBorder(ratingValue.getForeground(), 1));
        dateValue = new JLabel();
        lengthValue = new JLabel();
        directorsLbl = new JLabel("Directors");
        actorsLbl = new JLabel("Actors");
        synopsisLbl = new JLabel("Synopsis");

        themesValues = createTextArea(false);
        directorsValues = createTextArea(true);
        actorsValues = createTextArea(true);
        synopsisValue = createTextArea(true);

        add(poster,
            GBC.placeAt(0, 0).setInsets(40, 20).setWeight(0.05d, 1).setFill(GBC.VERTICAL).setAnchor(GBC.LINE_END)
        );
        add(createMainPanel(), GBC.placeAt(1, 0).setWeight(0.95d, 1).setFill(GBC.BOTH));

        setFont(getFont().deriveFont(15f));
        setMovie(movie);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        if (movie == null) {
            movie = new Movie("Movie title",
                              Calendar.getInstance(),
                              0,
                              Rating.UR,
                              0f,
                              new ArrayList<>(),
                              new ArrayList<>(),
                              new HashMap<>(),
                              "",
                              "",
                              ""
            );
        }

        this.movie = movie;

        poster.setImage(null);
        new Thread(() -> {
            try {
                poster.setImage(ImageIO.read(new URL(this.movie.getPosterURL())));
            } catch (Exception e) {
                poster.setImage(null);
            }
        }).start();

        titleValue.setText(movie.getTitle() + " (" + movie.getReleaseDate().get(Calendar.YEAR) + ")");
        colorYearTitle();

        ratingValue.setText(" " + movie.getRating().toString() + " ");
        dateValue.setText(new SimpleDateFormat("dd/MM/yyyy").format(getMovie().getReleaseDate().getTime()));
        lengthValue.setText(minutesToHours(movie.getRunningTime()));
        themesValues.setText(String.join(", ", movie.getThemes()));
        directorsValues.setText(String.join(", ", movie.getDirectors()));
        actorsValues.setText(String.join(", ", movie.getActors()));
        synopsisValue.setText(movie.getSynopsis());
    }

    @Override
    public void setBackground(Color bg) {
        if (isBackgroundSet()) {
            mainPanel.setBackground(bg);
            for (Component component : mainPanel.getComponents()) {
                component.setBackground(bg);
            }
        }
        super.setBackground(bg);
    }

    @Override
    public void setForeground(Color fg) {
        if (isForegroundSet()) {
            poster.setForeground(fg);
            mainPanel.setForeground(fg);
            for (Component component : mainPanel.getComponents()) {
                component.setForeground(fg);
            }
            ratingValue.setForeground(fg.darker());
            ratingValue.setBorder(BorderFactory.createLineBorder(fg.darker(), 1));
            colorYearTitle();
        }
        super.setForeground(fg);
    }

    @Override
    public void setFont(Font font) {
        if (isFontSet()) {
            poster.setFont(font);
            for (Component component : mainPanel.getComponents()) {
                component.setFont(font);
            }
            titleValue.setFont(font.deriveFont(Font.BOLD, font.getSize() * 2f));
            directorsLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() + 1f));
            actorsLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() + 1f));
            synopsisLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() + 1f));
        }
        super.setFont(font);
    }

    private String minutesToHours(int length) {
        int hours = length / 60;
        int minutes = length % 60;
        return (hours == 0 ? "" : hours + "h") + (minutes < 10 ? "0" : "") + minutes + "m";
    }

    private void colorYearTitle() {
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setForeground(attributes, getForeground().darker());
        StyleConstants.setBold(attributes, false);
        int offset = titleValue.getDocument().getLength() - 6;
        titleValue.getStyledDocument().setCharacterAttributes(offset, 6, attributes, false);
    }

    private JTextArea createTextArea(boolean lineWrap) {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(lineWrap);
        textArea.setWrapStyleWord(lineWrap);
        textArea.setBackground(getBackground());
        textArea.setEditable(false);
        return textArea;
    }

    private JPanel createMainPanel() {
        JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        mainPanel = new JPanel(new GridBagLayout()) {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = scrollPane.getViewport().getSize().width;
                return size;
            }
        };
        scrollPane.setViewportView(mainPanel);

        GBC gbc = GBC.placeAt(0, 0, 6, 1)
                     .setInsets(40, 20, 0, 20)
                     .setWeightX(1)
                     .setFill(GBC.HORIZONTAL)
                     .setAnchor(GBC.LINE_START);
        mainPanel.add(titleValue, gbc);

        gbc = GBC.placeAt(GBC.RELATIVE, 1, true);
        mainPanel.add(ratingValue, gbc.setIpadX(3).setInsets(0, 20, 0, 10));
        mainPanel.add(dateValue, gbc);
        mainPanel.add(separator1, gbc.setInsets(0, 10));
        mainPanel.add(themesValues, gbc);
        mainPanel.add(separator2, gbc.setInsets(0, 10));
        mainPanel.add(lengthValue, gbc.setInsets(0, 0, 0, 20).setWeightX(1).setAnchor(GBC.LINE_START));

        gbc = GBC.placeAt(0, GBC.RELATIVE, 6, 1).setFill(GBC.HORIZONTAL).setAnchor(GBC.LINE_START);
        mainPanel.add(directorsLbl, gbc.setInsets(20, 20, 5, 20));
        mainPanel.add(directorsValues, gbc.setInsets(0, 20, 0, 20));
        mainPanel.add(actorsLbl, gbc.setInsets(20, 20, 5, 20));
        mainPanel.add(actorsValues, gbc.setInsets(0, 20, 0, 20));
        mainPanel.add(synopsisLbl, gbc.setInsets(20, 20, 5, 20));
        mainPanel.add(synopsisValue, gbc.setInsets(0, 20, 40, 20));

        return mainPanel;
    }
}
