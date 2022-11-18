package ui;

import javax.swing.*;
import java.awt.*;

public class MainCenterPanel extends JPanel {
    public MainCenterPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(null,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        JPanel moviesPanel = new JPanel(new GridLayout(10, 5)) {
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = scrollPane.getViewport().getSize().width;
                return size;
            }
        };

        scrollPane.getViewport().add(moviesPanel);

        for (int i = 0; i < 50; i++) {
           moviesPanel.add(new MoviePanel("Avatar " + i));
        }

        add(scrollPane, BorderLayout.CENTER);
    }
}
