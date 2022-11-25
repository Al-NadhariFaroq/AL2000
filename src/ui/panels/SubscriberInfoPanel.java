package ui.panels;

import ui.interactions.CardInteraction;

import javax.swing.*;
import java.awt.*;

public class SubscriberInfoPanel extends JPanel {
    JButton btnSubscription, btnBack;

    public SubscriberInfoPanel() {
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
        btnBack = new JButton("back");
        btnBack.addActionListener(CardInteraction.getInstance());
        topPanel.setBackground(new Color(170, 200, 0));
        topPanel.add(btnBack);
        return topPanel;
    }

    JPanel creatCenterPanel() {
        JPanel centerPanel = new JPanel(new FlowLayout());
        btnSubscription = new JButton("subscription");
        btnSubscription.addActionListener(CardInteraction.getInstance());
        centerPanel.setBackground(new Color(0, 200, 163));
        centerPanel.add(btnSubscription);
        return centerPanel;
    }

    public JButton getBtnSubscription() {
        return btnSubscription;
    }

    public JButton getBtnBack() {
        return btnBack;
    }
}
