package movies;

import java.sql.SQLException;
import java.util.Scanner;

public class ControllerConsole extends Controller {
    Scanner scanner = new Scanner(System.in);

    @Override
    void displaySqlExceptionMessage(SQLException e) {
        e.printStackTrace();
    }


    @Override
    String setTitle() {
        System.out.println("set title");
        return scanner.nextLine();
    }

    @Override
    int setYear() {
        System.out.println("set year of production");
        return scanner.nextInt();
    }

    @Override
    void incorrectYearMessage() {
        System.out.println("wrong date of production");
    }

    @Override
    String setGenre() {
        System.out.println("set genre");
        scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    int setScore() {
        System.out.println("set rate (1-10): ");
        return scanner.nextInt();
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




