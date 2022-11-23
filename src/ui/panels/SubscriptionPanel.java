package ui.panels;

import ui.CyberVideo;
import ui.StackLayout;

import javax.swing.*;
import java.awt.*;

public class SubscriptionPanel extends JPanel {
    JButton btnValid, btnGoBack;

    public SubscriptionPanel() {
        setLayout(new BorderLayout());
        JPanel informations = new JPanel(new StackLayout());

        JPanel layer1 = new JPanel(new BorderLayout());
        JLabel name = new JLabel("Name : ");
        JTextField textName = new JTextField();
        layer1.add(name, BorderLayout.WEST);
        layer1.add(textName, BorderLayout.CENTER);

        JPanel layer2 = new JPanel(new BorderLayout());
        JLabel lastName = new JLabel("Last name : ");
        JTextField textLastName = new JTextField();
        layer2.add(lastName, BorderLayout.WEST);
        layer2.add(textLastName, BorderLayout.CENTER);

        JPanel layer3 = new JPanel(new BorderLayout());
        JLabel mail = new JLabel("Mail : ");
        JTextField textMail = new JTextField();
        layer3.add(mail, BorderLayout.WEST);
        layer3.add(textMail, BorderLayout.CENTER);

        JPanel layer4 = new JPanel(new BorderLayout());
        JLabel dateOfBirth = new JLabel("Date of birth : ");
        JTextField textDateOfBirth = new JTextField();
        layer4.add(dateOfBirth, BorderLayout.WEST);
        layer4.add(textDateOfBirth, BorderLayout.CENTER);

        informations.add(layer1);
        informations.add(layer2);
        informations.add(layer3);
        informations.add(layer4);
        add(informations, BorderLayout.CENTER);

        btnValid = new JButton("valid");
        btnGoBack = new JButton("back");

        JPanel southPanel = new JPanel();
        southPanel.add(btnValid);
        southPanel.add(btnGoBack);
        add(southPanel, BorderLayout.SOUTH);
        btnGoBack.addActionListener(e -> CyberVideo.changeState(Panels.SUBSCRIBER_INFO));
        btnValid.addActionListener(e -> {
            CyberVideo.changeState(Panels.SUBSCRIBER_INFO);
        });

        add(creatTopPanel(), BorderLayout.NORTH);
    }

    JPanel creatTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.gray);

        JLabel title = new JLabel("SubscriptionPanel");
        topPanel.add(title);

        return topPanel;
    }
}
