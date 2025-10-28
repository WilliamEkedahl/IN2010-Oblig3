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
        return "this is the list of movies %s %s %s%n"+ ttid+ title+ rating;
        
    }
}
