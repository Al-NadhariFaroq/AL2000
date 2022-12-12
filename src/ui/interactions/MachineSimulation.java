package ui.interactions;

import ui.AL2000UI;

import javax.swing.JOptionPane;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class MachineSimulation implements KeyEventDispatcher {
    private final AL2000UI UI;

    public MachineSimulation(AL2000UI UI) {
        this.UI = UI;
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_TYPED && e.isControlDown()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_C:
                    if (e.isShiftDown()) {
                        UI.getFC().getChanges().firePropertyChange("removeCreditCard", null, null);
                    } else {
                        String in = JOptionPane.showInputDialog(null,
                                                                "Credit card number:",
                                                                "Insert credit card",
                                                                JOptionPane.QUESTION_MESSAGE
                        );
                        Integer creditCardNumber = Integer.parseInt(in);
                        UI.getFC().getChanges().firePropertyChange("addCreditCard", null, creditCardNumber);
                    }
                    break;
                case KeyEvent.VK_S:
                    if (e.isShiftDown()) {
                        UI.getFC().getChanges().firePropertyChange("removeSubscriptionCard", null, null);
                    } else {
                        String in = JOptionPane.showInputDialog(null,
                                                                "Subscription card number:",
                                                                "Insert subscription card",
                                                                JOptionPane.QUESTION_MESSAGE
                        );
                        Integer subscriptionCardNumber = Integer.parseInt(in);
                        UI.getFC().getChanges().firePropertyChange("addSubscriptionCard", null, subscriptionCardNumber);
                    }
                    break;
                case KeyEvent.VK_D:
                    String in = JOptionPane.showInputDialog(null,
                                                            "Blu-ray serial number:",
                                                            "Insert Blu-ray",
                                                            JOptionPane.QUESTION_MESSAGE
                    );
                    Integer serialNumber = Integer.parseInt(in);
                    UI.getFC().getChanges().firePropertyChange("insertBluRay", null, serialNumber);
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
