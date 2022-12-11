package ui;

import fc.AL2000FC;
import fc.movie.Movie;
import fc.movie.Rating;
import ui.interactions.CardInteraction;
import ui.panels.HistoryPanel;
import ui.panels.HomePanel;
import ui.panels.MovieInfoPanel;
import ui.panels.Panel;
import ui.panels.ReloadPanel;
import ui.panels.RentPanel;
import ui.panels.SubscriberInfoPanel;
import ui.panels.SubscriptionPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class AL2000UI extends JFrame {
    private final AL2000FC fc;
    private final List<JPanel> panels;
    private Panel currentPanel;

    public AL2000UI(AL2000FC fc) {
        super("AL2000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960, 720));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new CardLayout());
        CardInteraction.setUI(this);

        this.fc = fc;

        HomePanel homePanel = new HomePanel(this, fc);
        MovieInfoPanel movieInfoPanel = new MovieInfoPanel();
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

    public AL2000FC getFC() {
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