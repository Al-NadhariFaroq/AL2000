package ui;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    int WIDTH = 720;
    int HEIGHT = 480;

    Main(String title)  {
        super(title);
        setSize(new Dimension(WIDTH,HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT/7));
        topPanel.setBackground(new Color(24, 32, 96));
        topPanel.add(new JLabel(""));
        mainPanel.add(topPanel, BorderLayout.NORTH);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.setForeground(Color.yellow);
        JLabel pub = new JLabel("");
        pub.setForeground(Color.yellow);
        bottomPanel.add(pub);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);


        JPanel PubPanel = new JPanel();
        PubPanel.setBackground(new Color(217, 208, 34));
        PubPanel.add(new JLabel("Pub"));
        mainPanel.add(PubPanel, BorderLayout.SOUTH);

        add(mainPanel);

    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main("CyberVideo2.0").setVisible(true);
            }
        });
    }
}