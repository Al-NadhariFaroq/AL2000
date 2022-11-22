package ui;

import fc.Movie;

import javax.swing.*;
import java.awt.*;

public class CyberVideo extends JFrame {
    int WIDTH = 960;
    int HEIGHT = 720;
    static CardLayout card;
    static Container cPane;

    CyberVideo() {
        super("CyberVideo2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(720,480));
        card = new CardLayout();
        setLayout(card);
        setLocationRelativeTo(null);
        cPane = getContentPane();

        MainPanel mainPanel = new MainPanel();
        mainPanel.btnPopular.addActionListener((e)-> changePanel());
        add(mainPanel);

        MovieMenu moviePanel = new MovieMenu(new Movie("Avatar "));
        add(moviePanel);
        new Interaction(mainPanel);
        pack();
    }
    public static void changeState(int s){
        if (s == 1)
            card.first(cPane);
        if (s == 2)
            card.next(cPane);
    }

    void changePanel(){
        card.next(cPane);
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new CyberVideo().setVisible(true));
    }
}