package ui;

import fc.movie.Movie;
import fc.movie.Rating;
import ui.component.MovieInfo;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MovieInfoTest extends JFrame {

    public MovieInfoTest() {
        super("MovieInfoTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960, 720));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new BorderLayout());

        Calendar date = Calendar.getInstance();
        date.set(2009, Calendar.DECEMBER, 16);

        List<String> themes = new ArrayList<>();
        themes.add("Science fiction");
        themes.add("Action");
        themes.add("Adventure");

        List<String> directors = new ArrayList<>();
        directors.add("James Cameron");

        Map<String, String> actors = new LinkedHashMap<>();
        actors.put("Sam Worthington", "Jake Sully");
        actors.put("Zoe Saldana", "Neytiri");
        actors.put("Sigourney Weaver", "Dr. Grace Augustine");
        actors.put("Stephen Lang", "Colonel Miles Quaritch");
        actors.put("Michelle Rodriguez", "Trudy Chacon");

        Movie movie = new Movie("Avatar",
                date,
                themes,
                directors,
                actors,
                "A paraplegic Marine is dispatched to the moon Pandora on a unique mission.",
                Rating.PG13,
                0f,
                "",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg"
        );

        MovieInfo movieInfo = new MovieInfo(movie);
        add(movieInfo);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        MovieInfoTest MovieInfoTest = new MovieInfoTest();
        SwingUtilities.invokeLater(() -> MovieInfoTest.setVisible(true));
    }
}
