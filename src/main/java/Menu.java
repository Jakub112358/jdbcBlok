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
                addMovie();
                break;
            case "2":
                displayMovies();
                break;
            case "3":
terminateLoop();
                break;
            default:
                System.out.println("wrong input, try again");

        }
    }

    private Movie setNewMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("set title");
        String title = scanner.nextLine();
        System.out.println("set year of production");
        int yearOfProduction = scanner.nextInt();
        // tu jest coś źle!!
        if(!MovieValidator.validateMovieDate(yearOfProduction)){
            System.out.println("wrong date of production");
            return setNewMovie();
        }
        System.out.println("set genre");
        scanner.nextLine();
        String genre = scanner.nextLine();
        System.out.println("set rate (1-10): ");
        int score = scanner.nextInt();
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

    private void addMovie() {
        System.out.println(" you've chosen adding movie");
        Movie inputMovie = setNewMovie();
        MoviesDAO.getInstance().addMovie(inputMovie);
    }

    private void displayMovies() {
        System.out.println("you've chosen displaying movies");

        for (Movie movie : MoviesDAO.getInstance().getMovies()) {
            System.out.println(movie);
        }
    }
    private void terminateLoop(){
        System.out.println("terminating program");
        running = false;
    }
}




