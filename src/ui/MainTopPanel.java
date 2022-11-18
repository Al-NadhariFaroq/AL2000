package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainTopPanel extends JPanel {
    public MainTopPanel(){
        setLayout(new BorderLayout());

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
        buttonsPanel.add(new JButton("Popular"));
        buttonsPanel.add(new JButton("Blu-ray"));
        buttonsPanel.add(new JButton("New"));
        buttonsPanel.add(new JButton("Filter"));

        add(searchPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
