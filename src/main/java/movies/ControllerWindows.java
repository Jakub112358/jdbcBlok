package movies;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerWindows extends Controller {

    @Override
    void displaySqlExceptionMessage(SQLException e) {
        JOptionPane.showMessageDialog(null, "data base crashed");
    }

    @Override
    Movie setNewMovie() {

        String title = JOptionPane.showInputDialog("set title");
        int yearOfProduction = Integer.parseInt(JOptionPane.showInputDialog("set year of production"));
        if (!MovieValidator.validateMovieDate(yearOfProduction)) {
            JOptionPane.showMessageDialog(null, "wrong date of production, try again");
            return setNewMovie();
        }
        String genre = JOptionPane.showInputDialog("set genre");
        int score = Integer.parseInt(JOptionPane.showInputDialog("set rate (1-10)"));
        return new Movie(title, yearOfProduction, genre, score);

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

        for (Movie movie : MoviesDAO.getInstance().getMovies()) {
            JOptionPane.showMessageDialog(null, movie.toString());
        }
    }

    @Override
    void displayEndMessage() {
        JOptionPane.showMessageDialog(null,"terminating program");
    }
}
