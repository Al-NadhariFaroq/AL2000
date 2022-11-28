package ui.component;

import ui.util.GBC;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchBar extends JPanel {
    private final JTextField textField;
    private final TextPrompt textPrompt;
    private final JButton deleteBtn;
    private final JButton searchBtn;

    public SearchBar() {
        this("", "enter some text", 0);
    }

    public SearchBar(String startText, String defaultText, int columns) {
        setLayout(new GridBagLayout());
        setBorder(new JTextField().getBorder());
        addMouseListener(createTextFieldMouseListener());

        textField = new JTextField(startText, columns);
        textField.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 0));
        textField.addMouseListener(createTextFieldMouseListener());

        textPrompt = new TextPrompt(textField, defaultText);
        textPrompt.changeStyle(Font.ITALIC);

        deleteBtn = new JButton("\uD83D\uDFA9");
        deleteBtn.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));
        deleteBtn.setFocusPainted(false);
        deleteBtn.setContentAreaFilled(false);
        deleteBtn.setVerticalAlignment(SwingConstants.TOP);
        deleteBtn.addActionListener(e -> textField.setText(""));
        deleteBtn.addMouseListener(createDeleteBtnMouseListener());

        searchBtn = new JButton("\uD83D\uDD0D");
        searchBtn.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 4));
        searchBtn.setFocusPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setVerticalAlignment(SwingConstants.TOP);
        searchBtn.addMouseListener(createSearchBtnMouseListener());

        setFont(textField.getFont());
        setBackground(Color.WHITE);
        setForeground(new Color(51, 51, 51));
        deleteBtn.setForeground(getBackground());

        add(textField, GBC.placeAt(0, 0).setFill(GBC.BOTH).setWeight(1, 1));
        add(deleteBtn, GBC.placeAt(1, 0).setFill(GBC.VERTICAL).setWeightY(1));
        add(searchBtn, GBC.placeAt(2, 0).setFill(GBC.VERTICAL).setWeightY(1));
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public String getDefaultText() {
        return textPrompt.getText();
    }

    public void setDefaultText(String defaultText) {
        textPrompt.setText(defaultText);
    }

    public int setColumns() {
        return textField.getColumns();
    }

    public void setColumns(int columns) {
        textField.setColumns(columns);
    }

    @Override
    public Font getFont() {
        return super.getFont();
    }

    @Override
    public void setFont(Font font) {
        if (isFontSet()) {
            textField.setFont(font);
            textPrompt.setFont(font.deriveFont(Font.ITALIC));
            deleteBtn.setFont(font.deriveFont(font.getSize() + 6f));
            searchBtn.setFont(font.deriveFont(font.getSize() + 4f));
        }
        super.setFont(font);
    }

    @Override
    public void setBackground(Color bg) {
        if (isBackgroundSet()) {
            textField.setBackground(bg);
            deleteBtn.setBackground(bg);
            searchBtn.setBackground(bg);
        }
        super.setBackground(bg);
    }

    @Override
    public void setForeground(Color fg) {
        if (isForegroundSet()) {
            textField.setForeground(fg);
            textPrompt.setForeground(fg.brighter().brighter());
            deleteBtn.setForeground(fg);
            searchBtn.setForeground(fg);
        }
        super.setForeground(fg);
    }

    public void addActionListener(ActionListener actionListener) {
        textField.addActionListener(actionListener);
        searchBtn.addActionListener(actionListener);
    }

    private MouseListener createTextFieldMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    textField.copy();
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    textField.paste();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                deleteBtn.setForeground(getForeground());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteBtn.setForeground(getBackground());
            }
        };
    }

    private MouseListener createDeleteBtnMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                deleteBtn.setForeground(getForeground().brighter().brighter());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                deleteBtn.setForeground(getForeground());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                deleteBtn.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                deleteBtn.setForeground(getForeground());
            }
        };
    }

    private MouseListener createSearchBtnMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                searchBtn.setForeground(getForeground().brighter().brighter());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                searchBtn.setForeground(getForeground());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                searchBtn.setForeground(Color.BLUE);
                deleteBtn.setForeground(getForeground());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                searchBtn.setForeground(getForeground());
                deleteBtn.setForeground(getBackground());
            }
        };
    }
}
