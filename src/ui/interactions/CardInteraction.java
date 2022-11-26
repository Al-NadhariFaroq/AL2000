package ui.interactions;

import ui.UserInterfaceAL2000;
import ui.panels.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class CardInteraction implements ActionListener {
    private static CardInteraction cardInteraction = null;
    private static UserInterfaceAL2000 UI;

    private CardInteraction() {
    }

    public static CardInteraction getInstance() {
        if (cardInteraction == null) {
            cardInteraction = new CardInteraction();
        }
        return cardInteraction;
    }

    public static void setUI(UserInterfaceAL2000 ui) {
        UI = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        switch (UI.getCurrentPanel()) {
            case HOME:
                HomePanel homePanel = (HomePanel) UI.getPanel(Panel.HOME);
                if (src == homePanel.getBtnMenu()) {
                    UI.changePanel(Panel.MOVIE_INFO);
                } else if (src == homePanel.getBtnUser()) {
                    UI.changePanel(Panel.SUBSCRIBER_INFO);
                }
                for (int i = 0; i < 50; i++) {
                    if (src == homePanel.getMovieButton(i).getBtn()) {
                        UI.changePanel(Panel.MOVIE_INFO);
                        ((MovieInfoPanel) UI.getPanel(Panel.MOVIE_INFO)).update(homePanel.getMovieButton(i).getTitle());
                    }
                }
                break;
            case MOVIE_INFO:
                MovieInfoPanel movieInfoPanel = (MovieInfoPanel) UI.getPanel(Panel.MOVIE_INFO);
                if (src == movieInfoPanel.getBtnBack()) {
                    UI.changePanel(Panel.HOME);
                }
                break;
            case SUBSCRIBER_INFO:
                SubscriberInfoPanel subscriberInfoPanel = (SubscriberInfoPanel) UI.getPanel(Panel.SUBSCRIBER_INFO);
                if (src == subscriberInfoPanel.getBtnBack()) {
                    UI.changePanel(Panel.HOME);
                } else if (src == subscriberInfoPanel.getBtnSubscription()) {
                    UI.changePanel(Panel.SUBSCRIPTION);
                }
                break;
            case SUBSCRIPTION:
                SubscriptionPanel subscriptionPanel = (SubscriptionPanel) UI.getPanel(Panel.SUBSCRIPTION);
                if (src == subscriptionPanel.getBtnBack()) {
                    UI.changePanel(Panel.HOME);
                } else if (src == subscriptionPanel.getBtnValid()) {
                    UI.changePanel(Panel.HOME);
                    UI.getFC().subscription(subscriptionPanel.getFirstNameText().getText(),
                                            subscriptionPanel.getLastNameText().getText(),
                                            Date.valueOf(subscriptionPanel.getDateOfBirthText().getText()),
                                            subscriptionPanel.getMailText().getText()
                    );
                }
                break;
            case HISTORY:
                HistoryPanel historyPanel = (HistoryPanel) UI.getPanel(Panel.HISTORY);
                break;
            case RELOAD:
                ReloadPanel reloadPanel = (ReloadPanel) UI.getPanel(Panel.RELOAD);
                break;
            case RENT:
                RentPanel rentPanel = (RentPanel) UI.getPanel(Panel.RENT);
                break;
        }
    }
}
