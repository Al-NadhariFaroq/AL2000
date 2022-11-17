package ui;

import fc.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MovieMenu extends JPanel {
        JLabel titleLabel, dateLabel, noteLabel,synopsisLabel;
        JLabel directorsLabel, actorsLabel, themesLabel;
        JButton rentBtn;

         public MovieMenu(Movie movie){
             setLayout(new FlowLayout());
             createComponent(movie);
             add(titleLabel);
             add(dateLabel);
             add(noteLabel);
             add(synopsisLabel);
             add(directorsLabel);
             add(actorsLabel);
             add(themesLabel);
             add(rentBtn);


         }

         void createComponent(Movie movie){
             titleLabel = new JLabel(movie.getTitle());
             dateLabel = new JLabel(movie.getDate());
             noteLabel = new JLabel(String.valueOf(movie.getNote()));
             synopsisLabel = new JLabel(movie.getSynopsis());
             directorsLabel = new JLabel(Arrays.toString(movie.getDirectors()));
             actorsLabel = new JLabel(Arrays.toString(movie.getActors()));
             themesLabel = new JLabel(Arrays.toString(movie.getThemes()));

             rentBtn = new JButton("Rent");
         }

}
