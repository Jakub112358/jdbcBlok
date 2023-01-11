package movies;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerGui extends Controller {

    @Override
    String setTitle(){
        return JOptionPane.showInputDialog("set title");
    }
    @Override
    String setCustomerYear() {
        return JOptionPane.showInputDialog("set year of production");
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
        showMessage("you've chosen displaying movies");
        StringBuilder displayMovieString = new StringBuilder();
        for (Movie movie : MoviesService.getInstance().getMovies()) {
            displayMovieString.append(movie).append("\n");
        }
        showMessage(displayMovieString.toString());
    }


    @Override
    void showMessage(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
