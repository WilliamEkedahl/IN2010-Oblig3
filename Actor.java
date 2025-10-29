import java.io.*;
import java.util.*;

public class Actor {
    String nmid;
    String name;
    ArrayList<String> ttids = new ArrayList<String>();

    public Actor(String nmid, String name, ArrayList<String> ttids){
        this.nmid = nmid;
        this.name = name;
        this.ttids = ttids;
    } 

    @Override
    public String toString(){
        String ttidsFormatted = String.join(", ", ttids);
        return String.format("this is the list of Actors %s %s %s", nmid ,name, ttids);  // ttids skriver ut minneverdi
        
    }

    public String getNmid(){
        return nmid;
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getTtids(){
        return ttids;
    }
}

