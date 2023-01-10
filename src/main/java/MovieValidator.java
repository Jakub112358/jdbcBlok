public class MovieValidator {
    public static boolean validateMovieDate (int yearOfProduction){
        return yearOfProduction >= 1800 && yearOfProduction <= 2100;
    }
}
