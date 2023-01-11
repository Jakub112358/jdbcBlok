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
            showMessage("data base crashed");
        }
    }
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
            showMessage("wrong date of production");
            return setNewMovie();
        }
        String genre = setGenre();
        int score = setScore();
        return new Movie(title, yearOfProduction, genre, score);
    }

    int setYear() {
        String yearOfProductionString = setCustomerYear();
        if(MovieValidator.validateMovieDate(yearOfProductionString)){
            return Integer.parseInt(yearOfProductionString);
        } else {
            showMessage("wrong year of production");
            return setYear();
        }
    }
    abstract String setCustomerYear();

    abstract String setTitle();

    abstract String setGenre();
    abstract int setScore();

    abstract String readDecision();
    private void addMovie() throws SQLException {
        showMessage("you've chosen displaying movies");
        Movie inputMovie = setNewMovie();
        MoviesService.getInstance().addMovie(inputMovie);
    }

    abstract void displayMovies() throws SQLException;
    private void terminateLoop() {
        displayEndMessage();
        running = false;
    }
    void displayEndMessage() {
        showMessage("terminating program");
    }

    abstract void showMessage(String message);


}
