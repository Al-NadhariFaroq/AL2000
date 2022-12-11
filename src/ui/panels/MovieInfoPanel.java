package ui.panels;

import fc.movie.Movie;
import ui.component.MovieInfo;
import ui.interactions.CardInteraction;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MovieInfoPanel extends JPanel {
    JLabel noteLabel;
    JButton btnRent, btnBack;
    MovieInfo movieInfo;

    public MovieInfoPanel() {
        setLayout(new BorderLayout());

        createComponent();

        JPanel topPanel = createTopPanel();
        movieInfo = new MovieInfo();

        add(topPanel, BorderLayout.NORTH);
        add(movieInfo, BorderLayout.CENTER);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    void createComponent() {
        noteLabel = new JLabel("<html><font color=black>Rate:</font> " + "5*");
        btnRent = new JButton("RentPanel");
        btnRent.addActionListener(CardInteraction.getInstance());
    }

    JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(960, 100));
        topPanel.setBackground(Color.GRAY);

        btnBack = new JButton("Go Back");
        btnBack.addActionListener(CardInteraction.getInstance());

        topPanel.add(btnBack, BorderLayout.WEST);

        return topPanel;
    }

    public void update(Movie movie) {
        movieInfo.setMovie(movie);
    }
}
