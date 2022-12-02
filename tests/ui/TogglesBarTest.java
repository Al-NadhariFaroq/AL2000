package ui;

import fc.Themes;
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

        Themes themes = new Themes();
        themes.setAvailability("anime", Themes.FORBIDDEN);
        themes.setAvailability("drama", Themes.EXCLUDED);
        themes.setAvailability("crime", Themes.EXCLUDED);
        themes.setAvailability("horror", Themes.FORBIDDEN);
        themes.setAvailability("thriller", Themes.FORBIDDEN);
        themes.setAvailability("fantastique", Themes.EXCLUDED);
        themes.setAvailability("romance", Themes.EXCLUDED);
        themes.setAvailability("musical", Themes.EXCLUDED);
        themes.setAvailability("historical", Themes.EXCLUDED);
        themes.setAvailability("documentary", Themes.FORBIDDEN);
        themes.setAvailability("anthology", Themes.FORBIDDEN);

        Map<String, Boolean> in = new LinkedHashMap<>();
        themes.forEach((theme, availability) -> {
            if (availability == Themes.INCLUDED) {
                in.put(theme, false);
            } else if (availability == Themes.EXCLUDED) {
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
            themes.setAvailability(btn.getText(), btn.isSelected() ? Themes.EXCLUDED : Themes.INCLUDED);
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