package ui;

import javax.swing.*;
import java.awt.*;
import java.nio.ByteOrder;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CyberVideo2.0");
        frame.setSize(new Dimension(720,480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel panelDVD = new JPanel();
        panelDVD.setBackground(Color.LIGHT_GRAY);
        panelDVD.add(new JLabel("Films Available In BLue-Ray"));
        mainPanel.add(panelDVD, BorderLayout.EAST);

        JPanel panelPub = new JPanel();
        panelPub.setBackground(new Color(24, 32, 96));
        panelPub.setForeground(Color.yellow);
        JLabel pub = new JLabel("Publicite");
        pub.setForeground(Color.yellow);
        panelPub.add(pub);
        mainPanel.add( panelPub, BorderLayout.NORTH);


        JPanel panelInteraction = new JPanel();
        panelInteraction.setBackground(Color.LIGHT_GRAY);
        panelInteraction.add(new JLabel("User + buttons"));
        mainPanel.add(panelInteraction, BorderLayout.WEST);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}