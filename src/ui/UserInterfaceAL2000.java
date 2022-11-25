package ui;

import fc.Card;
import fc.FunctionalCoreAL2000;
import fc.Movie;
import ui.interactions.CardInteraction;
import ui.panels.*;
import ui.panels.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserInterfaceAL2000 extends JFrame {
    int WIDTH = 960;
    int HEIGHT = 720;

    List<JPanel> panels;
    Panel currentPanel;

    public UserInterfaceAL2000(FunctionalCoreAL2000 fc) {
        super("CyberVideo2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new CardLayout());
        CardInteraction.setUI(this);

        HomePanel homePanel = new HomePanel();
        MovieInfoPanel movieInfoPanel = new MovieInfoPanel(new Movie("Avatar"));
        SubscriberInfoPanel subscriberInfoPanel = new SubscriberInfoPanel();
        SubscriptionPanel subscriptionPanel = new SubscriptionPanel();
        HistoryPanel historyPanel = new HistoryPanel();
        ReloadPanel reloadPanel = new ReloadPanel();
        RentPanel rentPanel = new RentPanel();

        add(Panel.HOME.name(), homePanel);
        add(Panel.MOVIE_INFO.name(), movieInfoPanel);
        add(Panel.SUBSCRIBER_INFO.name(), subscriberInfoPanel);
        add(Panel.SUBSCRIPTION.name(), subscriptionPanel);
        add(Panel.HISTORY.name(), historyPanel);
        add(Panel.RELOAD.name(), reloadPanel);
        add(Panel.RENT.name(), rentPanel);

        panels = new ArrayList<>();
        panels.add(homePanel);
        panels.add(movieInfoPanel);
        panels.add(subscriberInfoPanel);
        panels.add(subscriptionPanel);
        panels.add(historyPanel);
        panels.add(reloadPanel);
        panels.add(rentPanel);
        currentPanel = Panel.HOME;

        pack();
        setLocationRelativeTo(null);
    }

    public Panel getCurrentPanel() {
        return currentPanel;
    }

    public JPanel getPanel(Panel panel) {
        return panels.get(panel.ordinal());
    }

    public void changePanel(Panel panel) {
        currentPanel = panel;
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), panel.name());
    }
}