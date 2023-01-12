package movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesService {
    private static MoviesService instance;
    private static final String CREATE_TABLE_SQL = """
            CREATE TABLE IF NOT EXISTS movies (
            id int AUTO_INCREMENT PRIMARY KEY,
            title varchar(255) NOT NULL,
            yearOfProduction int NOT NULL,
            genre varchar(255) NOT NULL,
            score int NOT NULL
            );
            """;
    private static final String TRUNCATE_TABLE_SQL = "TRUNCATE movies";
    private static final String URL_SQL = "jdbc:mysql://localhost:3306/movies";
    private static final String USER_SQL = "root";
    private static final String PASSWORD_SQL = "1234";
    private static final String ADD_MOVIE_SQL = "INSERT INTO movies (title, yearOfProduction, genre, score) VALUES (?,?,?,?)";
    private static final String GET_ALL_MOVIES_SQL = "SELECT * FROM movies";
    private Connection connection;

    private MoviesService() throws SQLException {
        connect();
        createTable();
    }

    public static MoviesService getInstance() throws SQLException {
        if (instance == null)
            instance = new MoviesService();
        return instance;
    }

    private void createTable() throws SQLException {
        connection.prepareStatement(CREATE_TABLE_SQL).execute();
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(URL_SQL, USER_SQL, PASSWORD_SQL);
    }

    public void truncateTable() throws SQLException {
        connection.prepareStatement(CREATE_TABLE_SQL).execute();
        connection.prepareStatement(TRUNCATE_TABLE_SQL).execute();
    }

    public void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
    }

    public void addMovie(Movie movie) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(ADD_MOVIE_SQL);
        preparedStatement.setString(1, movie.getTitle());
        preparedStatement.setInt(2, movie.getYearOfProduction());
        preparedStatement.setString(3, movie.getMovieGenre());
        preparedStatement.setInt(4, movie.getScore());
        preparedStatement.execute();
    }

    public List<Movie> getMovies() throws SQLException {
        List<Movie> movieList;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        movieList = mapResultSetToList(resultSet);
        return movieList;
    }

    private List<Movie> mapResultSetToList(ResultSet resultSet) throws SQLException {
        List<Movie> movieList = new ArrayList<>();
        while (resultSet.next()) {
            movieList.add(new Movie(resultSet.getString("title"),
                    resultSet.getInt("yearOfProduction"),
                    resultSet.getString("genre"),
                    resultSet.getInt("score")));
        }
        return movieList;
    }

}
