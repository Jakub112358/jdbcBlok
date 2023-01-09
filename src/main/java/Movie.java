public class Movie {
    private String title;
    private int yearOfProduction;
    private String movieGenre;
    private int rate;

    public Movie(String title, int yearOfProduction, String movieGenre, int score) {
        this.title = title;
        this.yearOfProduction = yearOfProduction;
        this.movieGenre = movieGenre;
        this.rate = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", movieGenre='" + movieGenre + '\'' +
                ", rate=" + rate +
                '}';
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

    public int getRate() {
        return rate;
    }
}
