import fc.AL2000FC;
import ui.AL2000UI;

import javax.swing.SwingUtilities;

public class MainAL2000 {

    public static void main(String[] args) {
        AL2000FC fc = new AL2000FC();
        AL2000UI ui = new AL2000UI(fc);
        SwingUtilities.invokeLater(() -> ui.setVisible(true));
    }
}
