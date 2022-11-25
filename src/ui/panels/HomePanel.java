package ui.panels;

import ui.interactions.CardInteraction;
import ui.MovieButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HomePanel extends JPanel {
    public JButton btnMenu, btnUser, btnPopular, btnNew, btnFilter, btnBluRay;

    List<MovieButton> movieButtons;

    public HomePanel() {
        setLayout(new BorderLayout());

        movieButtons = new ArrayList<>();

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

        ImageIcon menuIcon = new ImageIcon(
                new ImageIcon("./rsc/images/listicon.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        btnMenu = new JButton(menuIcon);
        btnMenu.addActionListener(CardInteraction.getInstance());
        btnMenu.setBorder(new EmptyBorder(0, 10, 0, 10));

        ImageIcon userIcon = new ImageIcon(
                new ImageIcon("./rsc/images/user.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        btnUser = new JButton(userIcon);
        btnUser.addActionListener(CardInteraction.getInstance());
        btnUser.setBorder(new EmptyBorder(0, 10, 0, 10));

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 32));
        textField.setBorder(new EmptyBorder(0, 5, 0, 5));

        searchPanel.add(btnMenu, BorderLayout.WEST);
        searchPanel.add(textField, BorderLayout.CENTER);
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

        JScrollPane scrollPane = new JScrollPane(null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        JPanel moviesPanel = new JPanel(new GridLayout(10, 5)) {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = scrollPane.getViewport().getSize().width;
                return size;
            }
        };

        scrollPane.getViewport().add(moviesPanel);

        for (int i = 0; i < 50; i++) {
            MovieButton movieButton = new MovieButton("Avatar " + i);
            moviesPanel.add(movieButton);
            movieButtons.add(movieButton);
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

    public MovieButton getMovieButton(int i) {
        return movieButtons.get(i);
    }
}

