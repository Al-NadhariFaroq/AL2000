package ui.panels;

import fc.Movie;
import ui.UserInterfaceAL2000;
import ui.component.SearchBar;
import ui.interactions.CardInteraction;
import ui.component.MovieButton;
import ui.util.GBC;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

public class HomePanel extends JPanel {
    private final UserInterfaceAL2000 UI;
    public JButton btnMenu, btnUser, btnPopular, btnNew, btnFilter, btnBluRay;

    public HomePanel(UserInterfaceAL2000 ui) {
        this.UI = ui;

        setLayout(new BorderLayout());

        JPanel topPanel = mainTopPanel();
        JPanel centerPanel = mainCenterPanel();
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
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

    private JPanel mainCenterPanel() {
        JPanel mainCenterPanel = new JPanel();

        mainCenterPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(null,
                                                 ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        JPanel moviesPanel = new JPanel(new GridBagLayout()) {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = scrollPane.getViewport().getSize().width;
                return size;
            }
        };

        scrollPane.getViewport().add(moviesPanel);

        for (int i = 0; i < 50; i++) {
            Movie movie = new Movie("Avatar " + i);
            movie.setPosterURL("https://media.wdwnt.com/2022/11/avatar-the-way-of-water-poster-960x1200.jpg");
            MovieButton movieButton = new MovieButton(movie);
            movieButton.addActionListener(e -> {
                ((MovieInfoPanel) UI.getPanel(Panel.MOVIE_INFO)).update(movieButton.getMovie());
                UI.changePanel(Panel.MOVIE_INFO);
            });
            moviesPanel.add(movieButton, GBC.placeAt(i % 5, i / 5).setFill(GBC.BOTH).setInsets(5).setWeight(1, 1));
        }

        mainCenterPanel.add(scrollPane, BorderLayout.CENTER);

        return mainCenterPanel;
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }

    public JButton getBtnUser() {
        return btnUser;
    }
}

