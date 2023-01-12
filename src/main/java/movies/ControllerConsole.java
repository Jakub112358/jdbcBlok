package movies;

import java.util.Scanner;

public class ControllerConsole extends Controller {
    Scanner scanner = new Scanner(System.in);

    @Override
    void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    String getStringFromUser(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}




