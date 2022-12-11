package ui.interactions;

import ui.AL2000UI;
import ui.panels.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardInteraction implements ActionListener {
    private final AL2000UI UI;

    public CardInteraction(AL2000UI UI) {
        this.UI = UI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        switch (UI.getPanelManager().getCurrentPanel()) {
            case HOME:
                if (src == UI.getTopPanel().getRightBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.SUBSCRIBER_INFO);
                }
                break;
            case MOVIE_INFO:
                if (src == UI.getTopPanel().getLeftBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.HOME);
                }
                break;
            case SUBSCRIBER_INFO:
                if (src == UI.getTopPanel().getLeftBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.HOME);
                } else if (src == UI.getTopPanel().getRightBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.SUBSCRIPTION);
                }
                break;
            case SUBSCRIPTION:
                if (src == UI.getTopPanel().getLeftBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.HOME);
                }
                break;
            case HISTORY:
                if (src == UI.getTopPanel().getLeftBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.HOME);
                }
                break;
            case RELOAD:
                if (src == UI.getTopPanel().getLeftBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.HOME);
                }
                break;
            case RENT:
                if (src == UI.getTopPanel().getLeftBtn()) {
                    UI.getPanelManager().setCurrentPanel(Panel.HOME);
                }
                break;
        }
    }
}
