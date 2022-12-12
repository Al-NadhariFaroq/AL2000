package ui.panels;

import fc.ThemeManagement;
import fc.movie.SearchType;
import fc.movie.SortType;
import ui.AL2000UI;
import ui.component.MoviesGrid;
import ui.component.SearchBar;
import ui.component.TogglesBar;
import ui.component.MovieButton;
import ui.util.GBC;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class HomePanel extends JPanel {
    private final AL2000UI UI;
    private final Color fg = new Color(220, 220, 220);

    private final JComboBox<SortType> sortChoice;
    private final JComboBox<SearchType> searchChoice;
    private final SearchBar searchBar;
    private final JCheckBox bluRaysCheck;
    private final TogglesBar themesBar;
    private final MoviesGrid moviesGrid;

    public HomePanel(AL2000UI UI) {
        setLayout(new GridBagLayout());
        setBackground(new Color(53, 74, 95));

        this.UI = UI;

        moviesGrid = createMoviesGrid();
        themesBar = createThemesBar();
        bluRaysCheck = createBluRaysCheck();
        searchBar = createSearchBar();
        searchChoice = createSearchChose();
        sortChoice = createSortChose();

        add(createSearchPanel(), GBC.placeAt(0, 0).setInsets(10, 0).setFill(GBC.BOTH));
        add(themesBar, GBC.placeAt(0, 1).setInsets(10).setFill(GBC.BOTH));
        add(moviesGrid, GBC.placeAt(0, 2).setWeight(1, 1).setFill(GBC.BOTH));

        updateThemes();
        updateMovies();
    }

    public void updateThemes() {
        Map<String, Boolean> themes = new LinkedHashMap<>();
        UI.getFC().getThemes().getAllThemes().forEach(theme -> {
            int availability = UI.getFC().getThemes().getAvailability(theme);
            if (availability != ThemeManagement.FORBIDDEN) {
                themes.put(theme, availability == ThemeManagement.EXCLUDED);
            }
        });
        themesBar.updateButtons(themes);
        themesBar.getButtons().forEach(btn -> btn.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            UI.getFC().getThemes().setAvailability(btn.getText(), btn.isSelected() ? ThemeManagement.EXCLUDED : ThemeManagement.INCLUDED);
            UI.getFC().getMovies().setThemes(UI.getFC().getThemes().getIncludedThemes());
            updateMovies();
        })));
    }

    public void updateMovies() {
        moviesGrid.setMovies(UI.getFC().getMovies().getSortedMovies());
    }

    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setOpaque(false);

        GBC gbc = GBC.placeAt(GBC.RELATIVE, 0, true).setInsets(0, 10);
        searchPanel.add(sortChoice, gbc);
        searchPanel.add(searchChoice, gbc);
        searchPanel.add(searchBar, gbc.setWeightX(1).setFill(GBC.HORIZONTAL));
        searchPanel.add(bluRaysCheck, gbc);

        return searchPanel;
    }

    private JComboBox<SortType> createSortChose() {
        JComboBox<SortType> sortChose = new JComboBox<>();
        for (SortType sortType : SortType.values()) {
            sortChose.addItem(sortType);
        }
        sortChose.addActionListener(e -> new Thread(() -> {
            UI.getFC().getMovies().setSortType(sortChose.getItemAt(sortChose.getSelectedIndex()));
            updateMovies();
        }).start());
        sortChose.setSelectedIndex(0);
        return sortChose;
    }

    private JComboBox<SearchType> createSearchChose() {
        JComboBox<SearchType> searchChose = new JComboBox<>();
        for (SearchType searchType : SearchType.values()) {
            searchChose.addItem(searchType);
        }
        searchChose.addActionListener(e -> new Thread(() -> {
            SearchType searchType = searchChose.getItemAt(searchChose.getSelectedIndex());
            searchBar.setDefaultText(searchType.getDescription());
            UI.getFC().getMovies().setSearchType(searchType);
            updateMovies();
        }).start());
        searchChose.setSelectedIndex(0);
        return searchChose;
    }

    private SearchBar createSearchBar() {
        SearchBar searchBar = new SearchBar();
        searchBar.addActionListener(e -> new Thread(() -> {
            UI.getFC().getMovies().setSearchWords(searchBar.getText());
            updateMovies();
        }).start());
        return searchBar;
    }

    private JCheckBox createBluRaysCheck() {
        JCheckBox bluRaysCheck = new JCheckBox("Blu-rays only");
        bluRaysCheck.setForeground(fg);
        bluRaysCheck.setContentAreaFilled(false);
        bluRaysCheck.setFocusPainted(false);
        bluRaysCheck.addActionListener(e -> new Thread(() -> {
            UI.getFC().getMovies().setBluRaysOnly(bluRaysCheck.isSelected());
            updateMovies();
        }).start());
        return bluRaysCheck;
    }

    private TogglesBar createThemesBar() {
        TogglesBar themesBar = new TogglesBar();
        themesBar.setBackground(new Color(53, 74, 95));
        themesBar.setForeground(fg);
        themesBar.setFont(themesBar.getFont().deriveFont(15f));

        return themesBar;
    }

    private MoviesGrid createMoviesGrid() {
        MoviesGrid moviesGrid = new MoviesGrid(new ArrayList<>());
        moviesGrid.setBackground(new Color(203, 208, 214));
        moviesGrid.setNavBarBackground(new Color(53, 74, 95));
        moviesGrid.setNavBarForeground(fg);

        for (MovieButton movieButton : moviesGrid.getMovieButtons()) {
            movieButton.addActionListener(e -> {
                ((MovieInfoPanel) Panel.MOVIE_INFO.getPanel()).updateMovie(movieButton.getMovie());
                UI.getPanelManager().setCurrentPanel(Panel.MOVIE_INFO);
            });
        }

        return moviesGrid;
    }
}

