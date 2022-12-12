package ui.util;

import ui.AL2000UI;
import ui.interactions.CardInteraction;
import ui.panels.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

public class TopPanel extends JPanel {
    private final AL2000UI UI;

    private final JButton leftBtn;
    private final JButton rightBtn;
    private final JLabel titleLbl;

    public TopPanel(AL2000UI UI) {
        super(new GridBagLayout());
        setBackground(new Color(3, 37, 65));

        this.UI = UI;

        leftBtn = new JButton("Back");
        rightBtn = new JButton("Subscribe");
        titleLbl = new JLabel(Panel.HOME.getTitle(), JLabel.CENTER);

        CardInteraction cardInteraction = new CardInteraction(UI);
        leftBtn.addActionListener(cardInteraction);
        rightBtn.addActionListener(cardInteraction);
        titleLbl.setForeground(Color.WHITE);

        add(leftBtn, GBC.placeAt(0, 0).setInsets(10).setFill(GBC.BOTH));
        add(titleLbl, GBC.placeAt(1, 0).setInsets(5).setWeight(1, 1));
        add(rightBtn, GBC.placeAt(2, 0).setInsets(10).setFill(GBC.BOTH));

        setFont(getFont().deriveFont(15f));
    }

    public JButton getLeftBtn() {
        return leftBtn;
    }

    public JButton getRightBtn() {
        return rightBtn;
    }

    public JLabel getTitleLbl() {
        return titleLbl;
    }

    @Override
    public void setFont(Font font) {
        if (isFontSet()) {
            leftBtn.setFont(font);
            rightBtn.setFont(font);
            titleLbl.setFont(font.deriveFont(font.getSize() * 3f));
        }
        super.setFont(font);
    }
}
