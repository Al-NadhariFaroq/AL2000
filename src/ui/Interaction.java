package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Interaction implements MouseListener {
    CyberVideo.Panels panel;
    public Interaction(CyberVideo.Panels panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        CyberVideo.changeState(panel);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
