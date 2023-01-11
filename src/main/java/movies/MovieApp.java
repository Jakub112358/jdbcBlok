package movies;

public class MovieApp {
    public static void main(String[] args) {
        int choice = 2;
        Controller menu;
        if(choice == 1)
            menu = new ControllerConsole();
         else
            menu = new ControllerWindows();

        menu.startMenu();

    }
}
