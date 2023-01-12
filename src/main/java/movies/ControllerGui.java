package movies;

import javax.swing.*;

public class ControllerGui extends Controller {
    @Override
    void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    String getStringFromUser(String message) {
        String result = JOptionPane.showInputDialog(message);
        if (result == null) {
            showMessage("terminating program");
            System.exit(0);
        }
        return result;
    }
}
