package movies;

import java.sql.SQLException;
import java.util.Scanner;

public class ControllerConsole extends Controller {

    @Override
    void displaySqlExceptionMessage(SQLException e) {
        e.printStackTrace();
    }

    @Override
    Movie setNewMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("set title");
        String title = scanner.nextLine();
        System.out.println("set year of production");
        int yearOfProduction = scanner.nextInt();
        if (!MovieValidator.validateMovieDate(yearOfProduction)) {
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

    @Override
    String readDecision() {
        showOptions();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    @Override
    void displayAddMovieMessage() {
        System.out.println(" you've chosen adding movie");
    }

    @Override
    void displayMovies() throws SQLException {
        System.out.println("you've chosen displaying movies");

        for (Movie movie : MoviesService.getInstance().getMovies()) {
            System.out.println(movie);
        }
    }


    @Override
    void displayEndMessage() {
        System.out.println("terminating program");
    }
}




