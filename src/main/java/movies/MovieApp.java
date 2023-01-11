package movies;

public class MovieApp {
    public static void main(String[] args) {
        Controller menu;
        switch (args.length){
            case 0 -> menu = new ControllerConsole();
            default -> menu = new ControllerGui();
        }


        menu.startMenu();

    }
}
