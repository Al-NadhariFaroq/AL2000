package ui;

import fc.Movie;
import ui.panels.*;

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
        setMinimumSize(new Dimension(720, 480));
        card = new CardLayout();
        setLayout(card);
        setLocationRelativeTo(null);
        cPane = getContentPane();

        MainPanel mainPanel = new MainPanel();
        mainPanel.btnPopular.addActionListener((e) -> changePanel());
        add(Panels.MAIN.name(), mainPanel);

        MovieMenu moviePanel = new MovieMenu(new Movie("Avatar "));
        add(Panels.MOVIE_INFO.name(), moviePanel);

        SubscriberInfoMenu infoMenu = new SubscriberInfoMenu();
        add(Panels.SUBSCRIBER_INFO.name(), infoMenu);

        SubscriptionMenu subscriptionMenu = new SubscriptionMenu();
        add(Panels.SUBSCRIPTION_MENU.name(), subscriptionMenu);

        GetHistory historyInfo = new GetHistory();
        add(Panels.HISTORY_INFO.name(), historyInfo);

        ReloadCard reload = new ReloadCard();
        add(Panels.RELOAD.name(), reload);

        Rent rent = new Rent();
        add(Panels.RENT.name(), rent);

        //new Interaction(mainPanel);
        pack();
    }

    public static void changeState(Panels panel) {
        card.show(cPane, panel.name());
    }

    void changePanel() {
        card.next(cPane);
    }

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(() -> new CyberVideo().setVisible(true));
    }
}