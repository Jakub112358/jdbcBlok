package movies;

import java.util.IllegalFormatException;

public class MovieValidator {

    public static boolean validateMovieDate(String yearOfProduction){
        try {
            int year = Integer.parseInt(yearOfProduction);
            return year>=1800 && year <= 2100;
        } catch (NumberFormatException e){
            System.out.println("Year of production must be int");
            return false;
        }
    }

    public static boolean validateNumber (String name, int min, int max){
        try {
            int number = Integer.parseInt(name);
            return number >= min && number <= max;
        } catch (NumberFormatException e){
            System.out.println("Year of production must be int");
            return false;
        }
    }
}
