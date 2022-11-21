package ui;

import db.dao.CardDAO;
import db.entities.Card;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    int WIDTH = 960;
    int HEIGHT = 720;

    Main() {
        super("CyberVideo2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //setResizable(false);
        setLayout(new BorderLayout());
        CardDAO cardDAO = new CardDAO();
//        Card card = cardDAO.get(123456789);
        System.out.println(cardDAO.getAll());
        MainTopPanel topPanel = new MainTopPanel();
        MainCenterPanel centerPanel = new MainCenterPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}