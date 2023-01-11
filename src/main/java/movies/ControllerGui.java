package movies;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerGui extends Controller {

    @Override
    String setTitle(){
        return JOptionPane.showInputDialog("set title");
    }
    @Override
    int setYear(){
        String yearOfProductionString = JOptionPane.showInputDialog("set year of production");
        if(MovieValidator.validateMovieDate(yearOfProductionString)){
            return Integer.parseInt(yearOfProductionString);
        } else {
            System.out.println("wrong year of production");
            return setYear();
        }

    }
    @Override
    String setGenre(){
        return JOptionPane.showInputDialog("set genre");
    }
    @Override
    int setScore(){
        return Integer.parseInt(JOptionPane.showInputDialog("set rate (1-10)"));
    }
    @Override
    String readDecision() {
        return JOptionPane.showInputDialog("""
                Select:
                1 - add movie
                2 - display movies
                3 - terminate program
                """);
    }

    @Override
    void displayMovies() throws SQLException {
        JOptionPane.showMessageDialog(null, "you've chosen displaying movies");
        StringBuilder displayMovieString = new StringBuilder();

        for (Movie movie : MoviesService.getInstance().getMovies()) {
            displayMovieString.append(movie).append("\n");
        }
        JOptionPane.showMessageDialog(null, displayMovieString.toString());
    }


    @Override
    void showMessage(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
