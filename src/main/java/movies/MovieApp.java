package movies;

public class MovieApp {

    private static final String CONSOLE_MODE = "console";
    private static final String GUI_MODE = "gui";
    private static final String DEFAULT_MODE = GUI_MODE;

    private static Controller controller;
    public static void main(String[] args) {

        String mode = DEFAULT_MODE;
        if(args.length!=0){
            mode = args[0];
        }
        executeProgram(mode);
        controller.startMenu();

    }
    public static void executeProgram(String mode){
        if(mode.equalsIgnoreCase(CONSOLE_MODE)){
            controller = new ControllerConsole();
        } else if (mode.equalsIgnoreCase(GUI_MODE)) {
            controller = new ControllerGui();
        } else {
            executeProgram(DEFAULT_MODE);
        }
    }
}
