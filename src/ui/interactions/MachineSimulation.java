package ui.interactions;

import ui.AL2000UI;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MachineSimulation implements KeyListener {
    private final AL2000UI UI;

    public MachineSimulation(AL2000UI UI) {
        this.UI = UI;
        UI.getContentPane().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_C:
                System.out.println("ENTER");
                String in = JOptionPane.showInputDialog("Credit card number:");
                Integer creditCardNumber = Integer.parseInt(in);
                UI.getFC().getChanges().firePropertyChange("addCreditCard", null, creditCardNumber);
                break;
            case KeyEvent.VK_S:
                break;
            case KeyEvent.VK_D:
                break;
            case KeyEvent.VK_V:
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("PRESSED");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
