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

public class SearchBar extends JPanel {

    private class TextFieldDocumentListener implements DocumentListener {
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
    }

    private final JTextField textField;
    private final TextPrompt textPrompt;
    private final TextButton deleteBtn;
    private final TextButton searchBtn;
    private final JLabel pipeLbl;

    private boolean actionPerformedOnDeletion = true;

    public SearchBar() {
        this("", "enter some text", 0);
    }

    public SearchBar(String startText, String defaultText, int columns) {
        setLayout(new GridBagLayout());
        setBorder(new JTextField().getBorder());

        textField = new JTextField(startText, columns);
        textField.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 0));
        textField.getDocument().addDocumentListener(new TextFieldDocumentListener());

        textPrompt = new TextPrompt(textField, defaultText);
        textPrompt.changeStyle(Font.ITALIC);

        deleteBtn = new TextButton("X");
        deleteBtn.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
        deleteBtn.setEnteredFeedback(TextButton.COLOR);
        deleteBtn.setPressedFeedback(TextButton.COLOR);
        deleteBtn.setEnteredColor(Color.RED.darker());
        deleteBtn.setPressedColor(Color.RED.brighter());
        deleteBtn.setVisible(false);
        deleteBtn.addActionListener(e -> {
            textField.setText("");
            textField.requestFocus(true);
            if (actionPerformedOnDeletion) {
                textField.postActionEvent();
            }
        });

        searchBtn = new TextButton("S");
        searchBtn.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
        searchBtn.setEnteredFeedback(TextButton.COLOR);
        searchBtn.setPressedFeedback(TextButton.COLOR);
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

    public boolean isActionPerformedOnDeletion() {
        return actionPerformedOnDeletion;
    }

    public void setActionPerformedOnDeletion(boolean actionPerformedOnDeletion) {
        this.actionPerformedOnDeletion = actionPerformedOnDeletion;
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
            deleteBtn.setFont(font.deriveFont(font.getSize() + 4f));
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

    private void hideDeleteBtn() {
        deleteBtn.setVisible(!textField.getText().equals(""));
        revalidate();
    }
}
