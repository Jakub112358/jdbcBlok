import java.util.ArrayList;
import java.util.List;

public class MoviesData {
    private static MoviesData instance;
    private List<Movie> movieList;

    private MoviesData() {
        movieList = new ArrayList<>();
    }

    public static MoviesData getInstance() {
        if (instance == null) {
            instance = new MoviesData();
        }
        return instance;
    }

    public void addMovie(Movie movie) {

        movieList.add(movie);
    }

    public List<Movie> getMovies() {
        System.out.println(movieList);
        return movieList;
    }
}
