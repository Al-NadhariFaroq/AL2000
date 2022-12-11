package ui.panels;

import ui.AL2000UI;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class PanelManager extends JPanel {
    private final AL2000UI UI;

    private Panel currentPanel;

    public PanelManager(AL2000UI UI) {
        super(new CardLayout());

        this.UI = UI;
        Panel.createPanels(UI);

        for (Panel panel : Panel.values()) {
            add(panel.name(), panel.getPanel());
        }

        currentPanel = Panel.HOME;
    }

    public Panel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(Panel panel) {
        currentPanel = panel;
        UI.getTopPanel().getTitleLbl().setText(panel.getTitle());
        UI.getTopPanel().getLeftBtn().setVisible(panel.isLeftBtnVisible());
        UI.getTopPanel().getRightBtn().setVisible(panel.isRightBtnVisible());
        ((CardLayout) getLayout()).show(this, panel.name());
    }
}
