package ui;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    int WIDTH = 960;
    int HEIGHT = 720;

    Main(String title)  {
        super(title);
        setSize(new Dimension(WIDTH,HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);
        JPanel mainPanel = new JPanel(new BorderLayout());

        MainTopPanel topPanel = new MainTopPanel();
        MainBottomPanel bottomPanel = new MainBottomPanel();

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new Main("CyberVideo2.0").setVisible(true));
    }
}