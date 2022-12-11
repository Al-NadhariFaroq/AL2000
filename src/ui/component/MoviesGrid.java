package ui.component;

import fc.movie.Movie;
import ui.util.GBC;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MoviesGrid extends JPanel {

    private class CurPageLblActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                setCurrentPage(Integer.parseInt(curPageLbl.getText()));
            } catch (IllegalArgumentException ignore) {
                curPageLbl.setText(String.valueOf(currentPage));
            }
        }
    }

    private JScrollPane scrollPane;
    private JPanel gridPanel;
    private GridLayout gridLayout;
    private JLabel resultLbl;
    private JLabel startLbl;
    private JLabel toLbl;
    private JLabel endLbl;
    private JLabel onLbl;
    private JLabel nbResultsLbl;
    private TextButton prevPageBtn;
    private TextButton nextPageBtn;
    private JTextField curPageLbl;
    private JLabel slashLbl;
    private JLabel nbPagesLbl;
    private JLabel quantityLbl;
    private TextButton btn10pages;
    private TextButton btn20pages;
    private TextButton btn50pages;
    private TextButton btn100pages;
    private final JLabel emptyMoviesLbl;
    private final List<MovieButton> movieButtons;

    private int resultsPerLine;
    private int resultsPerPage;
    private int currentPage;
    private List<Movie> movies;

    public MoviesGrid(List<Movie> movies) {
        this(movies, 5);
    }

    public MoviesGrid(List<Movie> movies, int resultsPerLine) {
        if (movies == null) {
            throw new NullPointerException("variable movies might not have been initialized");
        }

        setLayout(new BorderLayout());

        add(createMovieGrid(), BorderLayout.CENTER);
        add(createNavBar(), BorderLayout.SOUTH);

        emptyMoviesLbl = new JLabel("No results", JLabel.CENTER);
        emptyMoviesLbl.setForeground(Color.GRAY);

        movieButtons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            movieButtons.add(new MovieButton());
        }

        setFont(getFont().deriveFont(14f));

        this.resultsPerLine = resultsPerLine;
        this.resultsPerPage = 20;
        this.currentPage = 1;
        this.movies = movies;
        updateMovies();
        btn20pages.setEnabled(false);
        prevPageBtn.setEnabled(false);
        nextPageBtn.setEnabled(currentPage < (movies.size() - 1) / resultsPerPage + 1);
    }

    public int getColumns() {
        return resultsPerLine;
    }

    public void setColumns(int cols) {
        resultsPerLine = cols;
        setCurrentPage(1);
    }

    private void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
        btn10pages.setEnabled(resultsPerPage != 10);
        btn20pages.setEnabled(resultsPerPage != 20);
        btn50pages.setEnabled(resultsPerPage != 50);
        btn100pages.setEnabled(resultsPerPage != 100);

        gridPanel.removeAll();
        setCurrentPage(1);
    }

    private void setCurrentPage(int currentPage) throws IllegalArgumentException {
        if (currentPage <= 0) {
            throw new IllegalArgumentException("current page cannot be 0 or negative");
        }
        if (currentPage > (movies.size() - 1) / resultsPerPage + 1) {
            throw new IllegalArgumentException("current page cannot be greater than the maximum number of pages");
        }
        this.currentPage = currentPage;
        prevPageBtn.setEnabled(currentPage > 1);
        nextPageBtn.setEnabled(currentPage < (movies.size() - 1) / resultsPerPage + 1);
        curPageLbl.setText(String.valueOf(currentPage));
        updateMovies();
    }

    public void setMovies(List<Movie> movies) throws NullPointerException {
        if (movies == null) {
            throw new NullPointerException("variable movies might not have been initialized");
        }
        this.movies = movies;
        setCurrentPage(1);
    }

    public List<MovieButton> getMovieButtons() {
        return movieButtons;
    }

    @Override
    public void setFont(Font font) {
        if (isFontSet()) {
            prevPageBtn.setFont(font.deriveFont(font.getSize() * 3f));
            nextPageBtn.setFont(font.deriveFont(font.getSize() * 3f));
            resultLbl.setFont(font.deriveFont(font.getSize() - 1f));
            startLbl.setFont(font.deriveFont(font.getSize() - 1f));
            toLbl.setFont(font.deriveFont(font.getSize() - 1f));
            endLbl.setFont(font.deriveFont(font.getSize() - 1f));
            onLbl.setFont(font.deriveFont(font.getSize() - 1f));
            nbResultsLbl.setFont(font.deriveFont(font.getSize() - 1f));
            curPageLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() + 3f));
            slashLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() + 3f));
            nbPagesLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() + 3f));
            quantityLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() - 1f));
            btn10pages.setFont(font.deriveFont(Font.BOLD, font.getSize() + 1f));
            btn20pages.setFont(font.deriveFont(Font.BOLD, font.getSize() + 1f));
            btn50pages.setFont(font.deriveFont(Font.BOLD, font.getSize() + 1f));
            btn100pages.setFont(font.deriveFont(Font.BOLD, font.getSize() + 1f));
            emptyMoviesLbl.setFont(font.deriveFont(Font.BOLD, font.getSize() * 2f));
            for (MovieButton movieButton : movieButtons) {
                movieButton.setFont(font.deriveFont(Font.BOLD));
            }
        }
        super.setFont(font);
    }

    private void updateMovies() {
        scrollPane.getVerticalScrollBar().setValue(0);
        curPageLbl.setText(String.valueOf(currentPage));
        nbPagesLbl.setText(String.valueOf((movies.size() - 1) / resultsPerPage + 1));
        nbResultsLbl.setText(String.valueOf(movies.size()));

        if (movies.size() == 0) {
            gridPanel.removeAll();
            gridLayout.setColumns(1);
            gridPanel.add(emptyMoviesLbl);
            startLbl.setText("0");
            endLbl.setText("0");
        } else {
            gridPanel.remove(emptyMoviesLbl);
            gridLayout.setColumns(resultsPerLine);

            for (int buttonIdx = 0; buttonIdx < resultsPerPage; buttonIdx++) {
                int movieIdx = (currentPage - 1) * resultsPerPage + buttonIdx;

                if (movieIdx < movies.size()) {
                    if (buttonIdx >= gridPanel.getComponentCount()) {
                        gridPanel.add(movieButtons.get(buttonIdx));
                    }
                    movieButtons.get(buttonIdx).setMovie(movies.get(movieIdx));
                } else {
                    gridPanel.remove(movieButtons.get(buttonIdx));
                }
            }

            startLbl.setText(String.valueOf((currentPage - 1) * resultsPerPage + 1));
            endLbl.setText(String.valueOf((currentPage - 1) * resultsPerPage + gridPanel.getComponentCount()));
        }
        repaint();
    }

    private JScrollPane createMovieGrid() {
        scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                     ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        gridLayout = new GridLayout(0, 5, 10, 10);
        gridPanel = new JPanel(gridLayout);

        JPanel centerPanel = new JPanel(new GridBagLayout()) {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = scrollPane.getViewport().getSize().width;
                return size;
            }
        };

        centerPanel.add(gridPanel,
                        GBC.placeAt(0, 0)
                           .setInsets(10)
                           .setWeight(1, 1)
                           .setFill(GBC.HORIZONTAL)
                           .setAnchor(GBC.PAGE_START)
        );
        scrollPane.getViewport().add(centerPanel);

        return scrollPane;
    }

    private JPanel createNavBar() {
        JPanel navBar = new JPanel(new GridLayout());
        navBar.add(createNbPagesInfo());
        navBar.add(createPageManagement());
        navBar.add(createQuantityManagement());
        return navBar;
    }

    private JPanel createNbPagesInfo() {
        resultLbl = new JLabel("Result");
        startLbl = new JLabel("0");
        toLbl = new JLabel("to");
        endLbl = new JLabel("19");
        onLbl = new JLabel("on");
        nbResultsLbl = new JLabel("20");

        JPanel nbPagesInfo = new JPanel(new GridBagLayout());
        GBC gbc = GBC.placeAt(GBC.RELATIVE, 0, true).setInsets(0, 2);
        nbPagesInfo.add(resultLbl, gbc.setWeightX(0.1).setAnchor(GBC.LINE_END));
        nbPagesInfo.add(startLbl, gbc);
        nbPagesInfo.add(toLbl, gbc);
        nbPagesInfo.add(endLbl, gbc);
        nbPagesInfo.add(onLbl, gbc);
        nbPagesInfo.add(nbResultsLbl, gbc.setWeightX(0.9).setAnchor(GBC.LINE_START));

        return nbPagesInfo;
    }

    private JPanel createPageManagement() {
        prevPageBtn = new TextButton("<");
        prevPageBtn.setEnteredFeedback(TextButton.COLOR);
        prevPageBtn.addActionListener(e -> setCurrentPage(currentPage - 1));

        nextPageBtn = new TextButton(">");
        nextPageBtn.setEnteredFeedback(TextButton.COLOR);
        nextPageBtn.addActionListener(e -> setCurrentPage(currentPage + 1));

        curPageLbl = new JTextField("1") {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = nbPagesLbl.getPreferredSize().width + 2;
                return size;
            }
        };
        curPageLbl.setHorizontalAlignment(JTextField.RIGHT);
        curPageLbl.setBorder(BorderFactory.createEmptyBorder());
        curPageLbl.setOpaque(false);
        curPageLbl.addActionListener(new CurPageLblActionListener());

        slashLbl = new JLabel("/");
        nbPagesLbl = new JLabel("100", JLabel.LEFT);

        JPanel pageManagement = new JPanel(new GridBagLayout());
        pageManagement.add(prevPageBtn, GBC.placeAt(0, 0).setInsets(0, 1));
        pageManagement.add(curPageLbl, GBC.placeAt(1, 0).setFill(GBC.HORIZONTAL));
        pageManagement.add(slashLbl, GBC.placeAt(2, 0).setInsets(0, 3));
        pageManagement.add(nbPagesLbl, GBC.placeAt(3, 0).setFill(GBC.HORIZONTAL));
        pageManagement.add(nextPageBtn, GBC.placeAt(4, 0).setInsets(0, 1));

        return pageManagement;
    }

    private JPanel createQuantityManagement() {
        quantityLbl = new JLabel("Results per page:");

        btn10pages = new TextButton("10");
        btn20pages = new TextButton("20");
        btn50pages = new TextButton("50");
        btn100pages = new TextButton("100");
        btn10pages.addActionListener(e -> setResultsPerPage(10));
        btn20pages.addActionListener(e -> setResultsPerPage(20));
        btn50pages.addActionListener(e -> setResultsPerPage(50));
        btn100pages.addActionListener(e -> setResultsPerPage(100));

        JPanel quantityManagement = new JPanel(new GridBagLayout());
        GBC gbc = GBC.placeAt(GBC.RELATIVE, 0, true).setInsets(0, 3);
        quantityManagement.add(quantityLbl, gbc.setWeightX(0.9).setAnchor(GBC.LINE_END));
        quantityManagement.add(btn10pages, gbc);
        quantityManagement.add(btn20pages, gbc);
        quantityManagement.add(btn50pages, gbc);
        quantityManagement.add(btn100pages, gbc.setWeightX(0.1).setAnchor(GBC.LINE_START));

        return quantityManagement;
    }
}
