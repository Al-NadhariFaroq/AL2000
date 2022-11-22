package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPanel extends JPanel{
    JButton btnPopular, btnNew, btnFilter, btnBluRay;
    public MainPanel(){
        setLayout(new BorderLayout());

        JPanel topPanel = mainTopPanel();
        JPanel centerPanel = mainCenterPanel();
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel mainTopPanel(){
        JPanel mainTopPanel = new JPanel();
        mainTopPanel.setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        searchPanel.setBackground(new Color(98, 98, 60));

        ImageIcon menuIcon = new ImageIcon(new ImageIcon("./rsc/images/listicon.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JLabel menuLabel = new JLabel(menuIcon);
        menuLabel.setBorder(new EmptyBorder(0, 10, 0, 10));

        ImageIcon userIcon = new ImageIcon(new ImageIcon("./rsc/images/user.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JLabel userLabel = new JLabel(userIcon);
        userLabel.setBorder(new EmptyBorder(0, 10, 0, 10));

        JTextField textField = new JTextField();
        textField.setPreferredSize( new Dimension(200, 32));
        textField.setBorder(new EmptyBorder(0, 5, 0, 5));

        searchPanel.add(menuLabel, BorderLayout.WEST);
        searchPanel.add(textField, BorderLayout.CENTER);
        searchPanel.add(userLabel, BorderLayout.EAST);

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

    private JPanel mainCenterPanel(){
        JPanel mainCenterPanel = new JPanel();

        mainCenterPanel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(null,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        JPanel moviesPanel = new JPanel(new GridLayout(10, 5)) {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = scrollPane.getViewport().getSize().width;
                return size;
            }
        };

        scrollPane.getViewport().add(moviesPanel);

        for (int i = 0; i < 50; i++) {
            moviesPanel.add(new MoviePanel("Avatar " + i));
        }

        mainCenterPanel.add(scrollPane, BorderLayout.CENTER);

        return mainCenterPanel;
    }
}

