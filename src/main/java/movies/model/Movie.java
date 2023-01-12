package movies.model;

import java.util.List;

public class Movie {
    private int id;
    private String title;
    private int yearOfProduction;
    private String movieGenre;
    private int score;

    public Movie(String title, int yearOfProduction, String movieGenre, int score) {
        this.title = title;
        this.yearOfProduction = yearOfProduction;
        this.movieGenre = movieGenre;
        this.score = score;
    }

    @Override
    public String toString() {
        return "movies.model.Movie{" +
                "title='" + title + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", movieGenre='" + movieGenre + '\'' +
                ", score=" + score +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public int getScore() {
        return score;
    }
}
