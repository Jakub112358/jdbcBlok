import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        boolean running = true;
        String input;
        Scanner scanner = new Scanner(System.in);
        MoviesData moviesData = new MoviesData();
        while(running){
            System.out.println("""
                    Select:
                    1 - add movie
                    2 - display movies
                    3 - terminate program
                    """);
            input = scanner.nextLine();
            if ("3".equals(input)){
                System.out.println("terminating program");
                running = false;
            } else if ("2".equals(input)) {
                System.out.println("you've chosen displaying movies");
                moviesData.getMovies();
            } else if ("1".equals(input)) {
                System.out.println(" you've chosen adding movie");
                System.out.println("set title");
                String title = scanner.nextLine();
                System.out.println("set year of production");
                int yearOfProduction = scanner.nextInt();
                System.out.println("set genre");
                String genre = scanner.nextLine();
                System.out.println("set score");
                int score = scanner.nextInt();

                moviesData.addMovie(new Movie(title,yearOfProduction,genre,score));
            } else {
                System.out.println("wrong input, try again");
            }

        }

    }

}
