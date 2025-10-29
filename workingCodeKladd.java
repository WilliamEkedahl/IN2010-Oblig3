import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WorkingCodeKladd {



    


    public static void main(String args[]) {
        File movies = new File("six-degrees-of-imdb-ressursside/marvel_actors.tsv");
        File actors = new File("six-degrees-of-imdb-ressursside/marvel_movies.tsv");

        try (Scanner fileReader = new Scanner(movies) ) {
            while (fileReader.hasNextLine()) {
                String fileData = fileReader.nextLine();
                //generate the graph for now print
                System.out.println(fileData);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be read while reading movies");
            e.printStackTrace();
        }
    }
} 
