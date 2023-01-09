import java.util.Scanner;

public class Menu {
    private boolean running = true;

    public void startMenu() {
        do {
            menuAction();
        } while (running);
    }

    private void menuAction() {
        showOptions();
        String input = readDecision();
        executeOption(input);

    }


    private void executeOption(String input) {

        switch (input) {
            case "1":
                System.out.println(" you've chosen adding movie");
                Movie inputMovie = setNewMovie();
                if (MovieValidator.validateMovie(inputMovie)) {
                    MoviesData.getInstance().addMovie(inputMovie);
                } else {
                    System.out.println("wrong movie input");
                }

                break;
            case "2":
                System.out.println("you've chosen displaying movies");
                MoviesData.getInstance().getMovies();
                break;
            case "3":
                System.out.println("terminating program");
                running = false;
                break;
            default:
                System.out.println("wrong input, try again");

        }
    }

    private Movie setNewMovie(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("set title");
        String title = scanner.nextLine();
        System.out.println("set year of production");
        int yearOfProduction = scanner.nextInt();
        System.out.println("set genre");
        scanner.nextLine();
        String genre = scanner.nextLine();
        System.out.println("set rate");
        int score = scanner.nextInt();
        scanner.nextLine();
        return new Movie(title, yearOfProduction, genre, score);
    }


    private void showOptions() {
        System.out.println("""
                Select:
                1 - add movie
                2 - display movies
                3 - terminate program
                """);
    }

    private String readDecision() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}




