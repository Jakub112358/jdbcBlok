import books.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {
    private static MoviesDAO instance;
    private static final String CREATE_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS movies (
            id int AUTO_INCREMENT PRIMARY KEY,
            title varchar(255) NOT NULL,
            yearOfProduction int NOT NULL,
            genre varchar(255) NOT NULL,
            score int NOT NULL
            );
            """;
    private static final String URL_SQL = "jdbc:mysql://localhost:3306/movies";
    private static final String USER_SQL = "root";
    private static final String PASSWORD_SQL = "1234";
    private static final String ADD_MOVIE_SQL = "INSERT INTO movies (title, yearOfProduction, genre, score) VALUES (?,?,?,?)";
    private static final String GET_ALL_MOVIES_SQL = "SELECT * FROM movies";
    private Connection connection;

    private MoviesDAO() {
        connect();
        createTable();
    }

    private void createTable() {
        try {
            connection.prepareStatement(CREATE_TABLE_SQL).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(URL_SQL, USER_SQL, PASSWORD_SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static MoviesDAO getInstance() {
        if (instance == null) {
            instance = new MoviesDAO();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(ADD_MOVIE_SQL);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getYearOfProduction());
            preparedStatement.setString(3, movie.getMovieGenre());
            preparedStatement.setInt(4, movie.getScore());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getMovies() {
        List<Movie> movieList;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            movieList = mapResultSetToList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movieList;
    }

    private List<Movie> mapResultSetToList(ResultSet resultSet){
        List<Movie> movieList = new ArrayList<>();
        try {
            while (resultSet.next()) {
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
