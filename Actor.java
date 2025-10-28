import java.io.*;
import java.util.*;

public class Actor {
    String nmid;
    String navn;
    ArrayList<String> ttids = new ArrayList<String>();

    public Actor(String nmid, String navn, ArrayList<String> ttids){
        this.nmid = nmid;
        this.navn = navn;
        this.ttids = ttids;
    } 

    @Override
    public String toString(){
        return "this is the list of movies %s %s %s%n"+ nmid+ navn+ ttids;  // ttids skriver ut minneverdi
        
    }
}

