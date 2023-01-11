package movies;

import java.sql.SQLException;

public abstract class Controller {
    private boolean running = true;
    public void startMenu() {
        do {
            menuAction();
        } while (running);
    }

    private void menuAction() {
        String input = readDecision();
        executeOption(input);
    }
    private void executeOption(String input) {
        try {
            handleOption(input);
        } catch (SQLException e) {
            displaySqlExceptionMessage(e);
        }
    }
    abstract void displaySqlExceptionMessage(SQLException e);
    private void handleOption(String input) throws SQLException {

        switch (input) {
            case "1":
                addMovie();
                break;
            case "2":
                displayMovies();
                break;
            case "3":
                MoviesDAO.getInstance().closeConnection();
                terminateLoop();
                break;
        }
    }

    abstract Movie setNewMovie();

    abstract String readDecision();
    private void addMovie() throws SQLException {
        displayAddMovieMessage();
        Movie inputMovie = setNewMovie();
        MoviesDAO.getInstance().addMovie(inputMovie);
    }
    abstract void displayAddMovieMessage();
    abstract void displayMovies() throws SQLException;
    private void terminateLoop() {
        displayEndMessage();
        running = false;
    }
    abstract void displayEndMessage();




}
