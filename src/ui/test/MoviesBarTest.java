package ui.test;

import fc.ThemeDatabase;
import ui.component.MoviesBar;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedHashMap;
import java.util.Map;

public class MoviesBarTest extends JFrame {

    public MoviesBarTest() {
        super("MoviesBarTest");
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

        MoviesBar moviesBar = new MoviesBar();

        add(moviesBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        MoviesBarTest moviesBarTest = new MoviesBarTest();
        SwingUtilities.invokeLater(() -> moviesBarTest.setVisible(true));
    }
}