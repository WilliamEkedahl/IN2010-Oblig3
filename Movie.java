import java.io.*;
import java.util.*;

public class Movie {

    String titel;
    String rating;

    public static void movie(String ttid, String titel, double rating){
        this.ttid = ttid;
        this.titel = titel;
        this.rating = rating;
    }

   ArrayList<Movie> movies = new ArrayList<Movie>();

    @Ovveride
    public String toString(String ttid, String titel, double rating){
        String movie = System.out.printf("this is the list of movies %s %s %s%n", ttid, titel, rating);
        return movie;
    }
}
