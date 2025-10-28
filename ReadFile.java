import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        Graph<String> marvelGraph = new Graph<>();
        File actors = new File("six-degrees-of-imdb-ressursside/marvel_actors.tsv");
        

        //Read movies
        //readFile<>(movies);

        //Read actors and generate the graph
        //readFile(actors);

        //print info about the graph
        marvelGraph.countNodes();
        marvelGraph.countEdges();

        ArrayList<Movie> movieList = new ArrayList<Movie>();

        Map<String, Movie> movies = new Hashmap<>();
        {
            try (Scanner fileReader = new Scanner(new File("six-degrees-of-imdb-ressursside/marvel_actors.tsv"))) {
                while (fileReader.hasNextLine()) {
                    //store the data in fileData, continue if theres another line and remove spaces at the end
                    String[] parts = fileReader.nextLine().trim();
                    //if line is empty skip it
                    if (String.isEmpty()) continue;
                    String[] parts = line.split("\t");
                    String ttid = line.parts[0];
                    String titel = line.parts[1];
                    double rating = Double.parseDouble(parts[2]);
                    movies.put(ttid, new Movie(title, rating));
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file could not be read while reading movies");
                e.printStackTrace();
            }
        }
    }
}

    /*
    public static void readFile(File file){
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                String fileData = fileReader.nextLine();
                //if line is empty skip it
                if (fileData.isEmpty()) continue;
                //generate the graph
                System.out.println(fileData);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("The file could not be read while reading movies");
            e.printStackTrace();
        }
    }
}

     */
