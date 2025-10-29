import java.io.*;
import java.util.*;

public class Movie {
    String ttid;
    String title;
    Double rating;

    public Movie(String ttid, String title, double rating){
        this.ttid = ttid;
        this.title = title;
        this.rating = rating;
    } 

    @Override
    public String toString(){
        return String.format("this is the list of movies %s  %s %f", ttid, title, rating);
        
    }
}
