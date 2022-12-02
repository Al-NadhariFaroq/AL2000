package ui;

import ui.component.TogglesBar;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TogglesBarTest extends JFrame {

    public TogglesBarTest() {
        super("TogglesBarTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 480));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new BorderLayout());

        Map<String, Boolean> data = createData(createInput());

        JTextArea textArea = new JTextArea(printData(data));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        TogglesBar togglesBar = new TogglesBar(data);
        togglesBar.setFont(togglesBar.getFont().deriveFont(13f));
        togglesBar.getButtons().forEach(btn -> btn.addActionListener(e -> {
            data.put(btn.getText(), btn.isSelected());
            textArea.setText(printData(data));
        }));

        add(togglesBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private Map<String, Boolean> createData(List<String> input) {
        Random random = new Random();
        Map<String, Boolean> data = new LinkedHashMap<>();
        input.forEach(word -> data.put(word, random.nextBoolean()));
        return data;
    }

    private List<String> createInput() {
        List<String> input = new ArrayList<>();
        input.add("first");
        input.add("second");
        input.add("third");
        input.add("fourth");
        input.add("fifth");
        input.add("sixth");
        input.add("seventh");
        input.add("eighth");
        input.add("ninth");
        input.add("tenth");
        input.add("eleventh");
        input.add("twelfth");
        input.add("thirteenth");
        input.add("fourteenth");
        input.add("fifteenth");
        input.add("sixteenth");
        input.add("seventeenth");
        input.add("eighteenth");
        input.add("nineteenth");
        input.add("twentieth");
        return input;
    }

    private String printData(Map<String, Boolean> data) {
        StringBuilder txt = new StringBuilder();
        data.forEach((word, selected) -> txt.append(word)
                                            .append(": ")
                                            .append(selected ? "selected" : "unselected")
                                            .append("\n"));
        return txt.toString();
    }

    public static void main(String[] args) {
        TogglesBarTest togglesBarTest = new TogglesBarTest();
        SwingUtilities.invokeLater(() -> togglesBarTest.setVisible(true));
    }
}