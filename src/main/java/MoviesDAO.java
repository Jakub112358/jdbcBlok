import books.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {
    private static MoviesDAO instance;
    private final Connection connection;

    private MoviesDAO()  {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String createTable = """
                CREATE TABLE IF NOT EXISTS movies (
                id int AUTO_INCREMENT PRIMARY KEY,
                title varchar(255) NOT NULL,
                yearOfProduction int NOT NULL,
                genre varchar(255) NOT NULL,
                score int NOT NULL
                );
                """;
        try {
            connection.prepareStatement(createTable).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MoviesDAO getInstance()  {
        if (instance == null) {
            instance = new MoviesDAO();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        String addMovieString = "INSERT INTO movies (title, yearOfProduction, genre, score) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(addMovieString);
            preparedStatement.setString(1,movie.getTitle());
            preparedStatement.setInt(2,movie.getYearOfProduction());
            preparedStatement.setString(3,movie.getMovieGenre());
            preparedStatement.setInt(4,movie.getScore());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getMovies() {
        List<Movie> movieList = new ArrayList<>();
        String getMoviesString = "SELECT * FROM movies";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(getMoviesString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                movieList.add(new Movie(resultSet.getString("title"),
                        resultSet.getInt("yearOfProduction"),
                        resultSet.getString("genre"),
                        resultSet.getInt("score")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movieList;
    }

}
