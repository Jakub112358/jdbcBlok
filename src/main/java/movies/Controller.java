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
                MoviesService.getInstance().closeConnection();
                terminateLoop();
                break;
        }
    }

    private Movie setNewMovie() {
        String title = setTitle();
        int yearOfProduction = setYear();
        if (!MovieValidator.validateMovieDate(yearOfProduction)) {
            incorrectYearMessage();
            return setNewMovie();
        }
        String genre = setGenre();
        int score = setScore();
        return new Movie(title, yearOfProduction, genre, score);
    }

    abstract String setTitle();
    abstract int setYear();
    abstract void incorrectYearMessage();
    abstract String setGenre();
    abstract int setScore();

    abstract String readDecision();
    private void addMovie() throws SQLException {
        displayAddMovieMessage();
        Movie inputMovie = setNewMovie();
        MoviesService.getInstance().addMovie(inputMovie);
    }
    abstract void displayAddMovieMessage();
    abstract void displayMovies() throws SQLException;
    private void terminateLoop() {
        displayEndMessage();
        running = false;
    }
    abstract void displayEndMessage();




}
