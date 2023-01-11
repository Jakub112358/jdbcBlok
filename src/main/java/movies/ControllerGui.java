package movies;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerGui extends Controller {

    @Override
    void displaySqlExceptionMessage(SQLException e) {
        JOptionPane.showMessageDialog(null, "data base crashed");
    }



    @Override
    String setTitle(){
        return JOptionPane.showInputDialog("set title");
    }
    @Override
    int setYear(){
        String yearOfProductionString = JOptionPane.showInputDialog("set year of production");
        return Integer.parseInt(yearOfProductionString);
    }
    @Override
    void incorrectYearMessage(){
        JOptionPane.showMessageDialog(null, "wrong date of production, try again");
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
    void displayAddMovieMessage() {
        JOptionPane.showMessageDialog(null, "you've chosen adding movie");
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
    void displayEndMessage() {
        JOptionPane.showMessageDialog(null,"terminating program");
    }
}
