import fc.FunctionalCoreAL2000;
import ui.UserInterfaceAL2000;

import javax.swing.*;

public class MainAL2000 {

    public static void main(String args[]) {
        // DataBaseAL2000 bd = new DataBaseAL2000();
        FunctionalCoreAL2000 fc = new FunctionalCoreAL2000();
        UserInterfaceAL2000 ui = new UserInterfaceAL2000(fc);
        SwingUtilities.invokeLater(() -> ui.setVisible(true));
    }
}
