package ui.panels;

import fc.movie.Movie;
import ui.AL2000UI;
import ui.component.MovieInfo;
import ui.util.GBC;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;

public class MovieInfoPanel extends JPanel {
    private final AL2000UI UI;

    private final MovieInfo movieInfo;
    private JButton rentBtn;

    public MovieInfoPanel(AL2000UI UI) {
        super(new GridBagLayout());
        setBackground(new Color(203, 208, 214));

        this.UI = UI;

        movieInfo = new MovieInfo();
        movieInfo.setBackground(new Color(53, 74, 95));
        movieInfo.setForeground(Color.WHITE);

        add(movieInfo, GBC.placeAt(0, 0).setInsets(50, 0).setWeight(1, 1).setFill(GBC.BOTH));
        add(createBottomBar(), GBC.placeAt(0, 1).setFill(GBC.BOTH));
    }

    public void updateMovie(Movie movie) {
        movieInfo.setMovie(movie);
    }

    private JPanel createBottomBar() {
        JPanel bottomBar = new JPanel();
        bottomBar.setBackground(new Color(53, 74, 95));

        rentBtn = new JButton("Rent");
        bottomBar.add(rentBtn);

        return bottomBar;
    }
}
