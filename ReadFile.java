import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException{
        Graph<String> marvelGraph = new Graph<>();
        File actors  = new File("six-degrees-of-imdb-ressursside/marvel_actors.tsv");
        File movies = new File("six-degrees-of-imdb-ressursside/marvel_movies.tsv");

        //Read movies
        readFile(movies);

        //Read actors and generate the graph
        readFile(actors);

        //print info about the graph
        marvelGraph.countNodes();
        marvelGraph.countEdges();

    }

    public static Map<String, Movie> readMovies(File file) throws FileNotFoundException {
        Map<String, Movie> movies = new Hashmap<>();
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                //store the data in fileData, continue if theres another line and remove spaces at the end
                String fileData = fileReader.nextLine().trim();
                //if line is empty skip it
                if (fileData.isEmpty()) continue;

                //to be done
                String[] parts = line.split("\t");
                String ttid = line.parts[0];
                String movieName = line.parts[1];
                double rating = Double.parseDouble(parts[2]);
                movies.put(ttid, new Movie(movieName, rating));
            }
        }   catch (FileNotFoundException e) {
            System.out.println("The file could not be read while reading movies");
            e.printStackTrace();
        }
    }



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
