package ui.test;

import fc.ThemeDatabase;
import ui.component.TogglesBar;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;

public class TogglesBarTest extends JFrame {

    public TogglesBarTest() {
        super("TogglesBarTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 480));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new BorderLayout());

        ThemeDatabase themes = new ThemeDatabase();
        themes.setAvailability("anime", ThemeDatabase.FORBIDDEN);
        themes.setAvailability("drama", ThemeDatabase.EXCLUDED);
        themes.setAvailability("crime", ThemeDatabase.EXCLUDED);
        themes.setAvailability("horror", ThemeDatabase.FORBIDDEN);
        themes.setAvailability("thriller", ThemeDatabase.FORBIDDEN);
        themes.setAvailability("fantastique", ThemeDatabase.EXCLUDED);
        themes.setAvailability("romance", ThemeDatabase.EXCLUDED);
        themes.setAvailability("musical", ThemeDatabase.EXCLUDED);
        themes.setAvailability("historical", ThemeDatabase.EXCLUDED);
        themes.setAvailability("documentary", ThemeDatabase.FORBIDDEN);
        themes.setAvailability("anthology", ThemeDatabase.FORBIDDEN);

        Map<String, Boolean> in = new LinkedHashMap<>();
        themes.forEach((theme, availability) -> {
            if (availability == ThemeDatabase.INCLUDED) {
                in.put(theme, false);
            } else if (availability == ThemeDatabase.EXCLUDED) {
                in.put(theme, true);
            }
        });

        JTextArea textArea = new JTextArea(themes.toString().replace(", ", ",\n"));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        TogglesBar togglesBar = new TogglesBar(in);
        togglesBar.setFont(togglesBar.getFont().deriveFont(13f));
        togglesBar.getButtons().forEach(btn -> btn.addActionListener(e -> {
            themes.setAvailability(btn.getText(), btn.isSelected() ? ThemeDatabase.EXCLUDED : ThemeDatabase.INCLUDED);
            textArea.setText(themes.toString().replace(", ", ",\n"));
        }));

        add(togglesBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        TogglesBarTest togglesBarTest = new TogglesBarTest();
        SwingUtilities.invokeLater(() -> togglesBarTest.setVisible(true));
    }
}