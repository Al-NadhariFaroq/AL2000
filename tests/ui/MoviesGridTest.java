package ui;

import fc.movie.Movie;
import fc.movie.Rating;
import ui.component.MoviesGrid;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class MoviesGridTest extends JFrame {

    public MoviesGridTest() {
        super("MoviesGridTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960, 720));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new BorderLayout());

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 243; i++) {
            Movie movie = new Movie("Avatar " + i,
                                    null,
                                    0,
                                    Rating.G,
                                    0f,
                                    null,
                                    null,
                                    null,
                                    "",
                                    "",
                                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg"
            );
            movies.add(movie);
        }

        MoviesGrid moviesGrid = new MoviesGrid(movies);
        add(moviesGrid);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        MoviesGridTest MoviesGridTest = new MoviesGridTest();
        SwingUtilities.invokeLater(() -> MoviesGridTest.setVisible(true));
    }
}
