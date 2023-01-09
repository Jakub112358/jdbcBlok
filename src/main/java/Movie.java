import java.util.List;

public class Movie {
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
}
