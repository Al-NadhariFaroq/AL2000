package ui.panels;

import fc.movie.Movie;
import ui.util.StackLayout;
import ui.interactions.CardInteraction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MovieInfoPanel extends JPanel {
    JLabel titleLabel, dateLabel, noteLabel, synopsisLabel;
    JLabel directorsLabel, actorsLabel, themesLabel;
    JButton btnRent, btnBack;

    public MovieInfoPanel(Movie movie) {
        setLayout(new BorderLayout());

        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        createComponent(movie);

        JPanel movieInfoPanel = createMovieInfoPanel(movie);
        add(movieInfoPanel, BorderLayout.CENTER);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    void createComponent(Movie movie) {
        titleLabel = createLabel(movie.getTitle() + ": The Way of Water", 30);
        dateLabel = createLabel("<html><font color=black>Released:</font> " + "16/12/2022", 16);
        themesLabel = createLabel("<html><font color=black>Genre:</font> " + "Science fiction, action", 16);
        synopsisLabel = createLabel("<html><font color=black>Synopsis:</font><br/>" + "movie.getSynopsis()", 16);
        directorsLabel = createLabel("<html><font color=black>Directors:</font> " + "James Cameron & Jon Landau", 16);
        actorsLabel = createLabel("<html><font color=black>Main actors:</font> " +
                                  "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang, Kate Winslet, ...",
                                  16
        );
        noteLabel = createLabel("<html><font color=black>Rate:</font> " + "5*", 16);

        btnRent = new JButton("RentPanel");
        btnRent.addActionListener(CardInteraction.getInstance());
    }

    JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(960, 100));
        topPanel.setBackground(Color.gray);
        btnBack = new JButton("Go Back");
        btnBack.addActionListener(CardInteraction.getInstance());
        topPanel.add(btnBack, BorderLayout.WEST);
        return topPanel;
    }

    JPanel createMovieInfoPanel(Movie movie) {
        JPanel movieInfoPanel = new JPanel(new StackLayout());
        movieInfoPanel.setBackground(Color.cyan);
        movieInfoPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

        JPanel imageInfoPanel = new JPanel(new BorderLayout());

        JPanel imagePanel = new JPanel(new CardLayout());

        java.net.URL imgUrl = getClass().getResource("/images/avatar.jpg");
        assert imgUrl != null;
        ImageIcon icon = new ImageIcon(new ImageIcon(imgUrl).getImage());//.getScaledInstance(300, 450, Image.SCALE_DEFAULT));
        JLabel label = new JLabel(icon);
        label.setBorder(new EmptyBorder(0, 25, 10, 5));
        imagePanel.add(label);
        imageInfoPanel.add(imagePanel, BorderLayout.WEST);

        JPanel infoPanel = new JPanel(new GridLayout(6, 0, 1, 1));
        infoPanel.setBackground(Color.blue);
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        Box dateThemeBox = Box.createHorizontalBox();
        dateThemeBox.add(dateLabel);
        dateThemeBox.add(themesLabel);

        infoPanel.add(titleLabel);
        infoPanel.add(dateThemeBox);
        infoPanel.add(directorsLabel);
        infoPanel.add(actorsLabel);
        infoPanel.add(synopsisLabel);

        imageInfoPanel.add(infoPanel, BorderLayout.CENTER);

        movieInfoPanel.add(imageInfoPanel);
        /*********************************************/
        //JPanel lastPanel = new JPanel(new GridLayout(1,20));
        //lastPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        imagePanel.add(btnRent);
        //lastPanel.add(noteLabel);
        //infoPanel.add(lastPanel);

        return movieInfoPanel;
    }

    JLabel createLabel(String text, int size) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, size));
        return label;
    }

    public void update(Movie movie) {
        // update data in function of title
    }
}
