package ui.panels;

import fc.Movie;
import ui.CyberVideo;

import javax.swing.*;
import java.awt.*;

public class SubscriberInfoMenu extends JPanel {
    JButton historyButton, btnGoBack;

    public SubscriberInfoMenu() {
        setLayout(new BorderLayout());

        JPanel topPanel = creatTopPanel();
        add(topPanel, BorderLayout.SOUTH);

        JPanel centerPanel = creatCenterPanel();
        add(centerPanel, BorderLayout.CENTER);

        //createComponent(movie);

        //JPanel movieInfoPanel = creatMovieInfoPanel(movie);
        //add(movieInfoPanel,BorderLayout.CENTER);
    }

    JPanel creatTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        btnGoBack = new JButton("back");
        btnGoBack.addActionListener(e -> CyberVideo.changeState(Panels.MAIN));
        topPanel.setBackground(new Color(170, 200, 0));
        topPanel.add(btnGoBack);
        return topPanel;
    }

    JPanel creatCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        btnGoBack = new JButton("subscription");
        btnGoBack.addActionListener(e -> CyberVideo.changeState(Panels.SUBSCRIPTION_MENU));
        centerPanel.setBackground(new Color(0, 200, 163));
        centerPanel.add(btnGoBack);
        return centerPanel;
    }

}
