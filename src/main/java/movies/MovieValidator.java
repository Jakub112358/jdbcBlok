package movies;

import java.util.IllegalFormatException;

public class MovieValidator {
    public static boolean validateMovieDate (int yearOfProduction){
        return yearOfProduction >= 1800 && yearOfProduction <= 2100;
    }
    public static boolean validateMovieDate(String yearOfProduction){
        try {
            return validateMovieDate(Integer.parseInt(yearOfProduction));
        } catch (NumberFormatException e){
            return false;
        }
    }
}
