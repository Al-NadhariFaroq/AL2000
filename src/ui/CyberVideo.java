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

        HomePanel homePanel = new HomePanel();
        homePanel.btnPopular.addActionListener((e) -> changePanel());
        add(Panels.HOME.name(), homePanel);

        MovieInfoPanel moviePanel = new MovieInfoPanel(new Movie("Avatar"));
        add(Panels.MOVIE_INFO.name(), moviePanel);

        SubscriberInfoPanel infoMenu = new SubscriberInfoPanel();
        add(Panels.SUBSCRIBER_INFO.name(), infoMenu);

        SubscriptionPanel subscriptionPanel = new SubscriptionPanel();
        add(Panels.SUBSCRIPTION.name(), subscriptionPanel);

        HistoryPanel historyPanelInfo = new HistoryPanel();
        add(Panels.HISTORY.name(), historyPanelInfo);

        ReloadPanel reloadPanel = new ReloadPanel();
        add(Panels.RELOAD.name(), reloadPanel);

        RentPanel rentPanel = new RentPanel();
        add(Panels.RENT.name(), rentPanel);

        //new Interaction(homePanel);
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