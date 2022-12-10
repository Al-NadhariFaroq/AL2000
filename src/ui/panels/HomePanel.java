package ui.panels;

import fc.AL2000FC;
import fc.movie.Movie;
import fc.movie.Rating;
import ui.AL2000UI;
import ui.component.MoviesGrid;
import ui.component.SearchBar;
import ui.interactions.CardInteraction;
import ui.component.MovieButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class HomePanel extends JPanel {
    private final AL2000UI UI;
    private final AL2000FC FC;
    public JButton btnMenu, btnUser, btnPopular, btnNew, btnFilter, btnBluRay;

    public HomePanel(AL2000UI ui, AL2000FC fc) {
        setLayout(new BorderLayout());
        this.UI = ui;
        this.FC = fc;

        JPanel topPanel = mainTopPanel();
        MoviesGrid moviesGrid = new MoviesGrid(FC.getMovies().getSortedMovies());

        for (MovieButton movieButton : moviesGrid.getMovieButtons()) {
            movieButton.addActionListener(e -> {
                ((MovieInfoPanel) UI.getPanel(Panel.MOVIE_INFO)).update(movieButton.getMovie());
                UI.changePanel(Panel.MOVIE_INFO);
            });
        }

        add(topPanel, BorderLayout.NORTH);
        add(moviesGrid, BorderLayout.CENTER);
    }

    private JPanel mainTopPanel() {
        JPanel mainTopPanel = new JPanel();
        mainTopPanel.setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        searchPanel.setBackground(new Color(98, 98, 60));

        ImageIcon menuIcon = new ImageIcon(new ImageIcon("./rsc/images/listicon.png").getImage()
                                                                                     .getScaledInstance(30,
                                                                                                        30,
                                                                                                        Image.SCALE_DEFAULT
                                                                                     ));
        btnMenu = new JButton(menuIcon);
        btnMenu.addActionListener(CardInteraction.getInstance());
        btnMenu.setBorder(new EmptyBorder(0, 10, 0, 10));

        ImageIcon userIcon = new ImageIcon(new ImageIcon("./rsc/images/user.png").getImage()
                                                                                 .getScaledInstance(30,
                                                                                                    30,
                                                                                                    Image.SCALE_DEFAULT
                                                                                 ));
        btnUser = new JButton(userIcon);
        btnUser.addActionListener(CardInteraction.getInstance());
        btnUser.setBorder(new EmptyBorder(0, 10, 0, 10));

        SearchBar searchBar = new SearchBar();

        searchPanel.add(btnMenu, BorderLayout.WEST);
        searchPanel.add(searchBar, BorderLayout.CENTER);
        searchPanel.add(btnUser, BorderLayout.EAST);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setBackground(Color.orange);
        buttonsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        btnPopular = new JButton("Popular");
        btnBluRay = new JButton("Blu-ray");
        btnNew = new JButton("New");
        btnFilter = new JButton("Filter");

        buttonsPanel.add(btnPopular);
        buttonsPanel.add(btnBluRay);
        buttonsPanel.add(btnNew);
        buttonsPanel.add(btnFilter);

        mainTopPanel.add(searchPanel, BorderLayout.NORTH);
        mainTopPanel.add(buttonsPanel, BorderLayout.SOUTH);

        return mainTopPanel;
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }

    public JButton getBtnUser() {
        return btnUser;
    }
}

