import java.util.Scanner;

public class Menu {
    public void startMenu() {
        boolean running = true;
        String input;
        Scanner scanner = new Scanner(System.in);
        while(running){
            System.out.println("""
                    Select:
                    1 - add movie
                    2 - display movies
                    3 - terminate program
                    """);
            input = scanner.nextLine();

            switch (input){
                case "1":
                    System.out.println(" you've chosen adding movie");
                    System.out.println("set title");
                    String title = scanner.nextLine();
                    System.out.println("set year of production");
                    int yearOfProduction = scanner.nextInt();
                    System.out.println("set genre");
                    scanner.nextLine();
                    String genre = scanner.nextLine();
                    System.out.println("set rate");
                    int score = scanner.nextInt();
                    scanner.nextLine();
                    if (MovieValidator.validateMovie(new Movie(title,yearOfProduction,genre,score))){
                        MoviesData.getInstance().addMovie(new Movie(title,yearOfProduction,genre,score));
                    } else {
                        System.out.println("wrong input");
                    }
                    break;
                case "2":
                    System.out.println("you've chosen displaying movies");
                    MoviesData.getInstance().getMovies();
                    break;
                case "3":
                    System.out.println("terminating program");
                    running = false;
                    break;
                default:
                    System.out.println("wrong input, try again");

            }
        }

    }



}
