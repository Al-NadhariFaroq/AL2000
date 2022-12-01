package ui.component;

import fc.movie.SearchType;
import fc.movie.SortType;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

public class MoviesBar extends JPanel {
    private final JPanel topPanel;
    private final JComboBox<SortType> sortChoice;
    private final JComboBox<SearchType> searchChoice;
    private final SearchBar searchBar;
    private final TogglesBar themesBar;
    private final JCheckBox bluRaysCheck;

    public MoviesBar() {
        setLayout(new BorderLayout());

        sortChoice = new JComboBox<>();

        searchChoice = new JComboBox<>();

        searchBar = new SearchBar();

        themesBar = new TogglesBar();

        bluRaysCheck = new JCheckBox("Blu-rays only");
        bluRaysCheck.setContentAreaFilled(false);
        bluRaysCheck.setFocusPainted(false);

        topPanel = new JPanel(new GridBagLayout());
        topPanel.add(sortChoice);
        topPanel.add(searchChoice);
        topPanel.add(searchBar);
        topPanel.add(bluRaysCheck);

        add(topPanel, BorderLayout.NORTH);
        add(themesBar, BorderLayout.SOUTH);
    }
}
