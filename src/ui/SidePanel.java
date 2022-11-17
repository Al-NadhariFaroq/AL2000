package ui;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {

    public SidePanel(){
        setPreferredSize(new Dimension(160,480));
        setLayout(new StackLayout());
        setBackground(Color.CYAN);
        add(new JButton("Subscribe"));
        add(new JButton("Return Movie"));
        add(new JButton("Return Movie"));
        add(new JButton("Return Movie"));
        add(new JButton("Return Movie"));
        add(new JButton("Return Movie"));
        add(new JButton("Return Movie"));
    }
}
