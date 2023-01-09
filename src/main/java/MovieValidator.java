public class MovieValidator {
    public static boolean validateMovie (Movie movie){
        if (movie.getYearOfProduction()>=1800 && movie.getYearOfProduction()<=2100)
            return true;
        return false;
    }
}
