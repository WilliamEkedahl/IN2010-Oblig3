import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Graph<String> marvelGraph = new Graph<>();

        ArrayList<Movie> movieList = new ArrayList<Movie>();

        //Map<String, Movie> movies = new HashMap<>();

        try (Scanner fileReader = new Scanner(new File("six-degrees-of-imdb-ressursside/marvel_movies.tsv"))) {
            while (fileReader.hasNextLine()) {
                //store the data in line, continue if theres another line and remove spaces at the end
                String line = fileReader.nextLine().trim();
                String[] parts = line.split("\t");
                String ttid = parts[0];
                String title = parts[1];
                double rating = Double.parseDouble(parts[2]);
                Movie temp = new Movie(ttid, title, rating);
                movieList.add(temp);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be read while reading movies");
            e.printStackTrace();
        }
        for (Movie movie : movieList) {
            System.out.println(movie.toString());
        }

        ArrayList<Actor> actorList = new ArrayList<Actor>();
        try (Scanner fileReader = new Scanner(new File("six-degrees-of-imdb-ressursside/marvel_actors.tsv"))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                String[] parts = line.split("\t");
                String nmid = parts[0];
                String name = parts[1];
                ArrayList<String> ttid = new ArrayList<>();
                int j = 0;
                for (int i = 2; i <parts.length; i++) {
                    ttid.add(parts[i]);
                }
                //if (ttid)
                Actor temp = new Actor(nmid, name, ttid);
                actorList.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be read while reading actors");
            e.printStackTrace();
        }
        for (Actor actor : actorList) {
            System.out.println(actor.toString());
        }

        //print info about the graph
        //marvelGraph.countNodes();
        //marvelGraph.countEdges();
    }
}


