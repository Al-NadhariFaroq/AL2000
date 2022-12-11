package ui;

import fc.AL2000FC;
import ui.panels.Panel;
import ui.panels.PanelManager;
import ui.util.TopPanel;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class AL2000UI extends JFrame {
    private final AL2000FC FC;

    private final TopPanel topPanel;
    private final PanelManager panelManager;

    public AL2000UI(AL2000FC fc) {
        super("AL2000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960, 720));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new BorderLayout());

        this.FC = fc;

        topPanel = new TopPanel(this);
        panelManager = new PanelManager(this);

        add(topPanel, BorderLayout.NORTH);
        add(panelManager, BorderLayout.CENTER);
        panelManager.setCurrentPanel(Panel.HOME);

        pack();
        setLocationRelativeTo(null);
    }

    public AL2000FC getFC() {
        return FC;
    }

    public TopPanel getTopPanel() {
        return topPanel;
    }

    public PanelManager getPanelManager() {
        return panelManager;
    }
}