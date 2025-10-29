import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Graph<String> marvelGraph = new Graph<>();

        ArrayList<Movie> movieList = new ArrayList<Movie>();

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

        //Debug - print ut list of movies-----
        for (Movie movie : movieList) {
            //System.out.println(movie.toString());          //-----------------------------------
        }

        //alla actors skal med oavsett om det spelar i en film som vi inte har data om
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
                Actor temp = new Actor(nmid, name, ttid);
                actorList.add(temp);
                //adds actors who are the only actors in a specific movie / no connections commponents of size 1
                marvelGraph.addNode(nmid);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be read while reading actors");
            e.printStackTrace();
        }

        //Debug - print ut list of actors-----
        for (Actor actor : actorList) {
            //System.out.println(actor.toString());    // ---------------------------------
        }

        for (Movie movie : movieList) {
            String movieId = movie.getTtid();
            String movieTitle = movie.getTitle();
            double movieRating = movie.getRating();

            //find all actors for each Movie and add into a new smaller arrayList
            ArrayList<Actor> actorsInMovie = new ArrayList<>();
            for (Actor actor : actorList) {
                //System.out.println(actor.toString());
                if (actor.getTtids().contains(movieId)) {
                    actorsInMovie.add(actor);
                    //System.out.println(actor.toString());
                }
            }

            //connect all actors in the movie to each other
            for (int i = 0; i < actorsInMovie.size(); i++) {
                for (int j = i + 1; j < actorsInMovie.size(); j++) {
                    Actor a1 = actorsInMovie.get(i);
                    Actor a2 = actorsInMovie.get(j);
                    // Add edges between all the different actors
                    marvelGraph.addEdge(a1.getNmid(), a2.getNmid(), (int) movieRating, movieTitle);
                }
            }
        }

        //print info about the graph
        marvelGraph.countNodes();
        marvelGraph.countEdges();
        marvelGraph.printEdges();      //Funker!



    }
}


//for each movie in Movie
//for each ttid in actor that matches the ttid in movie
//store in a new array
//make edges and connections with all of the tts in that graph
//marvelGraph.addEdge(Anmid, Anmid, title, rating);

// if nmid 1 + nmid 2 has the same ttid make a new edge
//marvelGraph.addEdge

