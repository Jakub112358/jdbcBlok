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
        String genre = setGenre();
        int score = setRate();
        return new Movie(title, yearOfProduction, genre, score);
    }

    int setYear() {
        String yearOfProductionString = getStringFromUser("set year of production");
        if (validateNumber(yearOfProductionString,"year of production",1800,2100)) {
            return Integer.parseInt(yearOfProductionString);
        } else {
            return setYear();
        }
    }

    private String setTitle() {
        return getStringFromUser("set title");
    }

    private String setGenre() {
        return getStringFromUser("set genre");
    }

    private int setRate() {
        String rateString = getStringFromUser("set rate (1-10): ");
        if (validateNumber(rateString,"rate",1,10)) {
            return Integer.parseInt(rateString);
        } else {
            return setRate();
        }
    }

    private String readDecision() {
        return getStringFromUser("""
                Select:
                1 - add movie
                2 - display movies
                3 - terminate program
                """);
    }

    private void addMovie() throws SQLException {
        showMessage("you've chosen adding movies");
        Movie inputMovie = setNewMovie();
        MoviesService.getInstance().addMovie(inputMovie);
    }

    private void displayMovies() throws SQLException {
        showMessage("you've chosen displaying movies");
        StringBuilder displayMovieString = new StringBuilder();
        for (Movie movie : MoviesService.getInstance().getMovies()) {
            displayMovieString.append(movie).append("\n");
        }
        showMessage(displayMovieString.toString());
    }

    private void terminateLoop() {
        displayEndMessage();
        running = false;
    }

    void displayEndMessage() {
        showMessage("terminating program");
    }

    abstract void showMessage(String message);

    abstract String getStringFromUser(String message);

    private boolean validateNumber(String inputString, String name, int min, int max) {
        try {
            int number = Integer.parseInt(inputString);
            if (number < min) {
                showMessage(name + " must be > " + min);
                return false;
            }
            if (number > max) {
                showMessage(name + " must be < " + max);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            showMessage(name + " must be int");
            return false;
        }
    }

}
