package ui.interactions;

import ui.panels.SubscriptionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PreferencesInteraction implements ActionListener {
    SubscriptionPanel panel;

    public PreferencesInteraction(SubscriptionPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        List<String> selected;
        if (src == panel.getBtn1()) {
            selected = panel.getNeutralList().getSelectedValuesList();
            for (String select : selected) {
                panel.getFavoriteModel().addElement(select);
                panel.getNeutralModel().removeElement(select);
            }
        } else if (src == panel.getBtn2()) {
            selected = panel.getFavoriteList().getSelectedValuesList();
            for (String select : selected) {
                panel.getNeutralModel().addElement(select);
                panel.getFavoriteModel().removeElement(select);
            }
        } else if (src == panel.getBtn3()) {
            selected = panel.getForbiddenList().getSelectedValuesList();
            for (String select : selected) {
                panel.getNeutralModel().addElement(select);
                panel.getForbiddenModel().removeElement(select);
            }
        } else if (src == panel.getBtn4()) {
            selected = panel.getNeutralList().getSelectedValuesList();
            for (String select : selected) {
                panel.getForbiddenModel().addElement(select);
                panel.getNeutralModel().removeElement(select);
            }
        }
    }
}
