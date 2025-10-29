import java.util.*;

public class Graph<T> {
    //Adjacency list: each node has a list of neighbours
    //private Map<Actor, List<adjecent actors> 
    private Map<T, List<Edge<T>>> map = new HashMap<>();

    //inner class for edges
    public static class Edge<T> {
        public T target;
        public String movieName;
        public Double rating; 

        public Edge(T target, String movieName, double rating){
            this.target = target;
            this.movieName = movieName;
            this.rating = rating; // må legges til ved vekting

        }
    }

    //add a new node (actor) each node is an actor (alla nm-id)
    public void addNode(T s) {
        map.putIfAbsent(s, new LinkedList<Edge<T>>());
    }

    //add a new edge
    public void addEdge(T source, T destination, double rating, String movieName) {
          addNode(source);
          addNode(destination);
       map.get(source).add(new Edge<>(destination, movieName, rating));
       map.get(destination).add(new Edge<>(source, movieName, rating));
   }

    //counts the number of nodes (actors)
    public void countNodes() {
        System.out.println("The graph has " + map.keySet().size() + " nodes.");
    }
    //counts the number of edges
    public void countEdges(){
        int count = 0;
        for (T v: map.keySet()) {
            count += map.get(v).size(); 
        }
        count = count/2; //divide by 2 since the graph is by directional or do we want to count both ways?
        System.out.println("The graph has " + count + " edges.");
    }

    //counts the number of edges
    public void printEdges(){
        //int count = 0;
        //list of adjecent actors, by movies (edge). 
        for (T actor: map.keySet()) {
            List<Edge<T>> v = map.get(actor);
            for (Edge<T> edge : v){
                //System.out.println("Edge/movie name: " + edge.movieName + ", Rating: "+Double.toString(edge.rating));
                System.out.println("=== [ " + edge.movieName + " " +Double.toString(edge.rating) + " ] ===> ");
            }
        }
    }
}



