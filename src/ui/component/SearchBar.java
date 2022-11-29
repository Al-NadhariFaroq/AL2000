package ui.component;

import ui.util.GBC;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchBar extends JPanel {
    private final JTextField textField;
    private final TextPrompt textPrompt;
    private final ButtonText deleteBtn;
    private final ButtonText searchBtn;
    private final JLabel pipeLbl;

    public SearchBar() {
        this("", "enter some text", 0);
    }

    public SearchBar(String startText, String defaultText, int columns) {
        setLayout(new GridBagLayout());
        setBorder(new JTextField().getBorder());

        textField = new JTextField(startText, columns);
        textField.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 0));
        textField.addMouseListener(createCopyPasteMouseListener());
        textField.getDocument().addDocumentListener(createHideDeleteBtnListener());

        textPrompt = new TextPrompt(textField, defaultText);
        textPrompt.changeStyle(Font.ITALIC);

        deleteBtn = new ButtonText("\uD83D\uDFA9");
        deleteBtn.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
        deleteBtn.setVerticalAlignment(SwingConstants.TOP);
        deleteBtn.setEnteredFeedback(ButtonText.COLOR);
        deleteBtn.setPressedFeedback(ButtonText.COLOR);
        deleteBtn.setEnteredColor(Color.RED.darker());
        deleteBtn.setPressedColor(Color.RED.brighter());
        deleteBtn.setVisible(false);
        deleteBtn.addActionListener(e -> {
            textField.setText("");
            textField.requestFocus(true);
        });

        searchBtn = new ButtonText("\uD83D\uDD0D");
        searchBtn.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
        searchBtn.setVerticalAlignment(SwingConstants.TOP);
        searchBtn.setEnteredFeedback(ButtonText.COLOR);
        searchBtn.setPressedFeedback(ButtonText.COLOR);
        searchBtn.setEnteredColor(Color.BLUE);
        searchBtn.setPressedColor(Color.CYAN.darker().darker());

        pipeLbl = new JLabel("ǀ");
        pipeLbl.setForeground(Color.GRAY);
        pipeLbl.setVerticalAlignment(SwingConstants.TOP);

        setFont(textField.getFont());
        setBackground(Color.WHITE);
        setForeground(textField.getForeground());

        add(textField, GBC.placeAt(0, 0).setWeight(1, 1).setFill(GBC.BOTH));
        add(deleteBtn, GBC.placeAt(1, 0).setWeightY(1).setFill(GBC.VERTICAL));
        add(pipeLbl, GBC.placeAt(2, 0));
        add(searchBtn, GBC.placeAt(3, 0).setWeightY(1).setFill(GBC.VERTICAL));
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
            pipeLbl.setFont(font.deriveFont(font.getSize() + 4f));
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
            deleteBtn.setTextColor(fg);
            searchBtn.setTextColor(fg);
        }
        super.setForeground(fg);
    }

    public void addActionListener(ActionListener actionListener) {
        textField.addActionListener(actionListener);
        searchBtn.addActionListener(actionListener);
    }

    private MouseListener createCopyPasteMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    textField.copy();
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    textField.paste();
                }
            }
        };
    }

    private DocumentListener createHideDeleteBtnListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hideDeleteBtn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hideDeleteBtn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                hideDeleteBtn();
            }

            private void hideDeleteBtn() {
                deleteBtn.setVisible(!textField.getText().equals(""));
                revalidate();
            }
        };
    }
}
