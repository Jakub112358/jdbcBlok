package movies;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;

public class ControllerConsole extends Controller {
    Scanner scanner = new Scanner(System.in);

    @Override
    String setTitle() {
        System.out.println("set title");
        return scanner.nextLine();
    }
    @Override
    int setYear() {
        System.out.println("set year of production");
        String yearOfProductionString = scanner.nextLine();
        if(MovieValidator.validateMovieDate(yearOfProductionString)){
            return Integer.parseInt(yearOfProductionString);
        } else {
            System.out.println("wrong year of production");
            return setYear();
        }
    }
    String setCustomerYear(){
        System.out.println("set year of production");
        return scanner.nextLine();
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
    void displayMovies() throws SQLException {
        System.out.println("you've chosen displaying movies");

        for (Movie movie : MoviesService.getInstance().getMovies()) {
            System.out.println(movie);
        }
    }
    @Override


    void showMessage(String message){
        System.out.println(message);
    }
}




