package ui.component;

import ui.util.GBC;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JViewport;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TogglesBar extends JPanel {

    private static class ButtonsMouseListener extends MouseAdapter {
        private final JToggleButton btn;

        public ButtonsMouseListener(JToggleButton btn) {
            this.btn = btn;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (btn.isEnabled()) {
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (btn.isEnabled()) {
                btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

    private class ToggleBarComponentListener extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent e) {
            if (viewport.getView().getPreferredSize().width <= viewport.getWidth()) {
                leftBtn.setVisible(false);
                rightBtn.setVisible(false);
            } else {
                leftBtn.setVisible(true);
                rightBtn.setVisible(true);
            }
            updateLeftRightButtons();
        }
    }

    private final JViewport viewport;
    private final TextButton leftBtn;
    private final TextButton rightBtn;
    private final List<JToggleButton> buttons;

    private int shiftDistance = 50;
    private long shiftTime = 150;

    public TogglesBar() {
        this(null);
    }

    public TogglesBar(Map<String, Boolean> in) {
        setLayout(new GridBagLayout());
        addComponentListener(new ToggleBarComponentListener());

        viewport = new JViewport();
        viewport.setView(new JPanel(new GridBagLayout()));

        leftBtn = new TextButton("❮");
        leftBtn.setEnteredFeedback(TextButton.COLOR);
        leftBtn.addActionListener(e -> shiftViewport(-1));

        rightBtn = new TextButton("❯");
        rightBtn.setEnteredFeedback(TextButton.COLOR);
        rightBtn.addActionListener(e -> shiftViewport(1));

        GBC gbc = GBC.placeAt(GBC.RELATIVE, 0, true).setWeightY(1).setFill(GBC.BOTH);
        add(leftBtn, gbc.setIpadX(12));
        add(viewport, gbc.setWeightX(1));
        add(rightBtn, gbc.setIpadX(12));

        buttons = new ArrayList<>();
        updateButtons(in);
    }

    public int getShiftDistance() {
        return shiftDistance;
    }

    public void setShiftDistance(int distance) {
        this.shiftDistance = distance;
    }

    public long getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(long millis) {
        this.shiftTime = millis;
    }

    public List<JToggleButton> getButtons() {
        return buttons;
    }

    @Override
    public void setFont(Font font) {
        if (isFontSet()) {
            leftBtn.setFont(font.deriveFont(font.getSize() * 1.5f));
            rightBtn.setFont(font.deriveFont(font.getSize() * 1.5f));
            buttons.forEach(btn -> btn.setFont(font));
        }
        super.setFont(font);
    }

    private void updateButtons(Map<String, Boolean> in) {
        if (in != null) {
            JPanel view = (JPanel) viewport.getView();
            view.removeAll();
            buttons.clear();

            in.forEach((string, selected) -> {
                JToggleButton btn = new JToggleButton(string);
                btn.setMargin(new Insets(0, 1, 0, 1));
                btn.setFocusPainted(false);
                btn.addMouseListener(new ButtonsMouseListener(btn));
                btn.setSelected(selected);

                view.add(btn, GBC.placeAt(GBC.RELATIVE, 0).setInsets(0, 3).setWeightY(1).setFill(GBC.VERTICAL));
                buttons.add(btn);
            });
            updateLeftRightButtons();
        }
    }

    private void shiftViewport(int direction) {
        int sign = Integer.signum(direction);
        int shift;

        Point point = viewport.getViewPosition();
        if (sign < 0) {
            shift = Math.min(shiftDistance, point.x);
        } else {
            shift = Math.min(shiftDistance, viewport.getViewSize().width - viewport.getExtentSize().width - point.x);
        }

        new Thread(() -> {
            for (int i = 0; i < shift; i++) {
                point.x += sign;
                viewport.setViewPosition(point);
                try {
                    Thread.sleep(shiftTime / (long) shiftDistance);
                } catch (InterruptedException ignore) {
                }
            }
            updateLeftRightButtons();
        }).start();
    }

    private void updateLeftRightButtons() {
        int x = viewport.getViewPosition().x;
        leftBtn.setEnabled(x > 0);
        rightBtn.setEnabled(x < viewport.getViewSize().width - viewport.getExtentSize().width);
    }
}
