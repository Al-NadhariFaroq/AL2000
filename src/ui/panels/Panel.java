package ui.panels;

import ui.AL2000UI;

import javax.swing.JPanel;

public enum Panel {
    HOME("AL2000", false, true),
    MOVIE_INFO("", true, false),
    SUBSCRIBER_INFO("Personal data", true, true),
    SUBSCRIPTION("Subscription", true, false),
    HISTORY("History", true, false),
    RELOAD("Reload", true, false),
    RENT("Rent", true, false);

    private final String title;
    private final boolean leftBtnVisible;
    private final boolean rightBtnVisible;
    private JPanel panel;

    Panel(String title, boolean leftBtnVisible, boolean rightBtnVisible) {
        this.title = title;
        this.leftBtnVisible = leftBtnVisible;
        this.rightBtnVisible = rightBtnVisible;
    }

    public String getTitle() {
        return title;
    }

    public boolean isLeftBtnVisible() {
        return leftBtnVisible;
    }

    public boolean isRightBtnVisible() {
        return rightBtnVisible;
    }

    public JPanel getPanel() {
        return panel;
    }

    private void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public static void createPanels(AL2000UI UI) {
        HOME.setPanel(new HomePanel(UI));
        MOVIE_INFO.setPanel(new MovieInfoPanel(UI));
        SUBSCRIBER_INFO.setPanel(new SubscriberInfoPanel(UI));
        SUBSCRIPTION.setPanel(new SubscriptionPanel(UI));
        HISTORY.setPanel(new HistoryPanel(UI));
        RELOAD.setPanel(new ReloadPanel(UI));
        RENT.setPanel(new RentPanel(UI));
    }
}
