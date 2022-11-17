package ui;

import javax.swing.*;
import java.awt.*;

public class MainBottomPanel extends JPanel {
    public MainBottomPanel(){
        setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setBackground(Color.orange);
        buttonsPanel.setPreferredSize(new Dimension(960,34));
        buttonsPanel.add(new JButton("Popular"));
        buttonsPanel.add(new JButton("BLue-Ray"));
        buttonsPanel.add(new JButton("New"));
        buttonsPanel.add(new JButton("Filter"));


        JPanel moviesPanel = new JPanel(new GridLayout(12,5));
        //moviesPanel.setBackground(Color.GRAY);
        JScrollPane scrollPane =new JScrollPane(moviesPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        for (int i =0; i< 50;i++){
           moviesPanel.add(new MoviePanel("Avatar " + i));
        }

        add(buttonsPanel,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
    }
}
