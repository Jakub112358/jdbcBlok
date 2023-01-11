package movies;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerGui extends Controller {
    @Override
    void showMessage(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
    @Override
    String getStringFromUser(String message) {
        return JOptionPane.showInputDialog(message);
    }
}
