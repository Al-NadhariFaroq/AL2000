package ui.component;

import fc.Movie;
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
import java.awt.event.MouseEvent;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class MovieGrid extends JPanel {
    private int resultsPerLine;
    private int resultsPerPage;
    private int currentPage;
    private List<Movie> movies;

    private JScrollPane scrollPane;
    private JPanel gridPanel;
    private JLabel resultLbl;
    private JLabel startLbl;
    private JLabel toLbl;
    private JLabel endLbl;
    private JLabel onLbl;
    private JLabel nbResultsLbl;
    private ButtonText prevPageBtn;
    private ButtonText nextPageBtn;
    private JTextField curPageLbl;
    private JLabel slashLbl;
    private JLabel nbPagesLbl;
    private JLabel quantityLbl;
    private ButtonText btn10pages;
    private ButtonText btn20pages;
    private ButtonText btn50pages;
    private ButtonText btn100pages;
    private final JLabel emptyMoviesLbl;
    private final List<MovieButton> movieButtons;

    public MovieGrid(List<Movie> movies) {
        this(movies, 5);
    }

    public MovieGrid(List<Movie> movies, int resultsPerLine) {
        if (movies == null) {
            throw new NullPointerException("variable movies might not have been initialized");
        }

        setLayout(new BorderLayout());

        add(createMovieGrid(), BorderLayout.CENTER);
        add(createNavBar(), BorderLayout.SOUTH);

        emptyMoviesLbl = new JLabel("No results");
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

    public int getResultsPerLine() {
        return resultsPerLine;
    }

    public void setResultsPerLine(int resultsPerLine) {
        this.resultsPerLine = resultsPerLine;
        setCurrentPage(1);
    }

    private void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
        gridPanel.removeAll();
        setCurrentPage(1);

        deselectButton(btn10pages, 10);
        deselectButton(btn20pages, 20);
        deselectButton(btn50pages, 50);
        deselectButton(btn100pages, 100);
    }

    private void deselectButton(ButtonText button, int value) {
        MouseEvent e = new MouseEvent(button, 0, 0, 0, 0, 0, 0, false);
        button.getMouseListeners()[1].mouseReleased(e);
        button.getMouseListeners()[1].mouseExited(e);
        button.setEnabled(resultsPerPage != value);
    }

    private void setCurrentPage(int currentPage) {
        if (currentPage <= 0 || currentPage > (movies.size() - 1) / resultsPerPage + 1) {
            throw new InvalidParameterException("invalid currentPage value");
        }
        this.currentPage = currentPage;
        prevPageBtn.setEnabled(currentPage > 1);
        nextPageBtn.setEnabled(currentPage < (movies.size() - 1) / resultsPerPage + 1);
        curPageLbl.setText(String.valueOf(currentPage));
        updateMovies();
    }

    public void setMovies(List<Movie> movies) {
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
        if (movies.size() == 0) {
            gridPanel.removeAll();
            gridPanel.add(emptyMoviesLbl, GBC.placeAt(0, 0));
        } else {
            gridPanel.remove(emptyMoviesLbl);
            int componentCount = gridPanel.getComponentCount();
            for (int buttonIdx = resultsPerPage - 1; buttonIdx >= 0; buttonIdx--) {
                int movieIdx = (currentPage - 1) * resultsPerPage + buttonIdx;
                if (movieIdx < movies.size()) {
                    MovieButton movieButton = movieButtons.get(buttonIdx);
                    if (buttonIdx >= componentCount) {
                        int row = buttonIdx % resultsPerLine;
                        int column = buttonIdx / resultsPerLine;
                        gridPanel.add(movieButton,
                                      GBC.placeAt(row, column).setFill(GBC.HORIZONTAL).setInsets(10).setWeight(1, 1),
                                      componentCount
                        );
                    }
                    movieButton.setMovie(movies.get(movieIdx));
                } else {
                    gridPanel.remove(movieButtons.get(buttonIdx));
                }
            }
        }
        scrollPane.getVerticalScrollBar().setValue(0);
        startLbl.setText(String.valueOf((currentPage - 1) * resultsPerPage + 1));
        endLbl.setText(String.valueOf((currentPage - 1) * resultsPerPage + gridPanel.getComponentCount()));
        nbResultsLbl.setText(String.valueOf(movies.size()));
        nbPagesLbl.setText(String.valueOf((movies.size() - 1) / resultsPerPage + 1));
        revalidate();
    }

    private JScrollPane createMovieGrid() {
        scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                     ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        gridPanel = new JPanel(new GridBagLayout()) {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = scrollPane.getViewport().getSize().width;
                return size;
            }
        };
        scrollPane.getViewport().add(gridPanel);

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
        GBC gbc = GBC.placeAt(GBC.RELATIVE, 0).setInsets(0, 2);
        nbPagesInfo.add(resultLbl, gbc.setWeightX(0.1).setAnchor(GBC.LINE_END));
        nbPagesInfo.add(startLbl, gbc);
        nbPagesInfo.add(toLbl, gbc);
        nbPagesInfo.add(endLbl, gbc);
        nbPagesInfo.add(onLbl, gbc);
        nbPagesInfo.add(nbResultsLbl, gbc.setWeightX(0.9).setAnchor(GBC.LINE_START));

        return nbPagesInfo;
    }

    private JPanel createPageManagement() {
        prevPageBtn = new ButtonText("⮘");
        prevPageBtn.setEnteredFeedback(ButtonText.COLOR);
        prevPageBtn.addActionListener(e -> setCurrentPage(currentPage - 1));

        nextPageBtn = new ButtonText("⮚");
        nextPageBtn.setEnteredFeedback(ButtonText.COLOR);
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
        curPageLbl.addActionListener(createCurPageLblActionListener());

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

        btn10pages = new ButtonText("10");
        btn20pages = new ButtonText("20");
        btn50pages = new ButtonText("50");
        btn100pages = new ButtonText("100");
        btn10pages.addActionListener(e -> setResultsPerPage(10));
        btn20pages.addActionListener(e -> setResultsPerPage(20));
        btn50pages.addActionListener(e -> setResultsPerPage(50));
        btn100pages.addActionListener(e -> setResultsPerPage(100));

        JPanel quantityManagement = new JPanel(new GridBagLayout());
        GBC gbc = GBC.placeAt(GBC.RELATIVE, 0).setInsets(0, 3);
        quantityManagement.add(quantityLbl, gbc.setWeightX(0.9).setAnchor(GBC.LINE_END));
        quantityManagement.add(btn10pages, gbc);
        quantityManagement.add(btn20pages, gbc);
        quantityManagement.add(btn50pages, gbc);
        quantityManagement.add(btn100pages, gbc.setWeightX(0.1).setAnchor(GBC.LINE_START));

        return quantityManagement;
    }

    private ActionListener createCurPageLblActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setCurrentPage(Integer.parseInt(curPageLbl.getText()));
                } catch (Exception ignore) {
                    curPageLbl.setText(String.valueOf(currentPage));
                }
            }
        };
    }
}
