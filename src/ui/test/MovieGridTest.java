package ui.test;

import fc.Movie;
import ui.component.MovieGrid;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class MovieGridTest extends JFrame {

    public MovieGridTest() {
        super("MovieGridTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960, 720));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new BorderLayout());

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 156; i++) {
            Movie movie = new Movie("Avatar " + i);
            movie.setPosterURL("https://media.wdwnt.com/2022/11/avatar-the-way-of-water-poster-960x1200.jpg");
            movies.add(movie);
        }

        MovieGrid movieGrid = new MovieGrid(movies);
        add(movieGrid);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        MovieGridTest MovieGridTest = new MovieGridTest();
        SwingUtilities.invokeLater(() -> MovieGridTest.setVisible(true));
    }
}
