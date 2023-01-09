import java.util.ArrayList;
import java.util.List;
//TODO: make it singleton
public class MoviesData {
    private List<Movie> movieList = new ArrayList<>();

    public void addMovie (Movie movie){
        movieList.add(movie);
    }
    public List<Movie> getMovies (){
        System.out.println(movieList);
        return movieList;
    }
}
