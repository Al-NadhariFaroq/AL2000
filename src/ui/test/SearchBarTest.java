package ui.test;

import ui.component.SearchBar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;

public class SearchBarTest extends JFrame {

    public SearchBarTest() {
        super("SearchBarTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 480));
        setMinimumSize(new Dimension(720, 480));
        getContentPane().setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel label = new JLabel("History of entered texts:");
        label.setAlignmentX(0.5f);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        list.setAlignmentX(0.5f);
        list.setBackground(null);
        list.setFont(list.getFont().deriveFont(Font.PLAIN));
        ((DefaultListCellRenderer) list.getCellRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane(list,
                                                 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        SearchBar searchBar = new SearchBar();
        searchBar.addActionListener(e -> {
            if (!searchBar.getText().equals("")) {
                listModel.addElement(searchBar.getText());
                searchBar.setText("");

                scrollPane.validate();
                Rectangle bounds = scrollPane.getViewport().getViewRect();
                JScrollBar vertical = scrollPane.getVerticalScrollBar();
                JScrollBar horizontal = scrollPane.getHorizontalScrollBar();
                vertical.setValue(vertical.getMaximum());
                horizontal.setValue((horizontal.getMaximum() - bounds.width) / 2);
            }
        });

        Box box = Box.createVerticalBox();
        box.add(label);
        box.add(scrollPane);

        add(searchBar, BorderLayout.NORTH);
        add(box, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SearchBarTest searchBarTest = new SearchBarTest();
        SwingUtilities.invokeLater(() -> searchBarTest.setVisible(true));
    }
}
