import java.util.*;

public class Graph<T> {
    //Adjacency list: each node has a list of neighbours
    private Map<T, List<Edge<T>>> map = new HashMap<>();

    //inner class for edges
    public static class Edge<T> {
        public T target;
        public String movieName;

        public Edge(T target, String movieName){
            this.target = target;
            this.movieName = movieName;
        }
    }

    //add a new node (actor) each node is an actor (alla nm-id)
    public void addNode(T s) {
        map.putIfAbsent(s, new LinkedList<Edge<T>>());
    }

    //add a new edge
    public void addEdge(T source, T destination, int rating, String movieName) {
          addNode(source);
          addNode(destination);
       map.get(source).add(new Edge<>(destination, movieName));
       map.get(destination).add(new Edge<>(source, movieName));
   }

    //counts the number of nodes (actors)
    public void countNodes() {
        System.out.println("The graph has " + map.keySet().size() + " nodes.");
    }
    //counts the number of edges
    public void countEdges(){
        int count = 0;
        for (T v: map.keySet()) {
            count += map.get(v).size()/2; //divide by 2 since the graph is by directional or do we want to count both ways?
        }
        System.out.println("The graph has " + count + " edges.");
    }
}



