package ui;

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
    private final FunctionalCoreAL2000 fc;
    private final List<JPanel> panels;
    private Panel currentPanel;

    public UserInterfaceAL2000(FunctionalCoreAL2000 fc) {
        super("CyberVideo 2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960, 720));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new CardLayout());
        CardInteraction.setUI(this);

        this.fc = fc;

        HomePanel homePanel = new HomePanel(this);
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

        pack();
        setLocationRelativeTo(null);

        panels = new ArrayList<>();
        panels.add(homePanel);
        panels.add(movieInfoPanel);
        panels.add(subscriberInfoPanel);
        panels.add(subscriptionPanel);
        panels.add(historyPanel);
        panels.add(reloadPanel);
        panels.add(rentPanel);
        currentPanel = Panel.HOME;
    }

    public FunctionalCoreAL2000 getFC() {
        return fc;
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