package app.algorithms;

import java.util.ArrayList;

import app.graph.Digraph;
import app.graph.Node;

public class BFS {
    public static ArrayList<ArrayList<Node>> ALL_PATHS = new ArrayList<>();

    public static void dfs(Digraph graph, Node source, Node destination, ArrayList<Node> visited, ArrayList<Node> path){
        if (source == destination) {
            ALL_PATHS.add(new ArrayList<>(path));
            return;
        }

        visited.add(source);
        
        for(Node node : graph.getNeighbourNodes(source)){
            if (!visited.contains(node)) {
                // store current node
                path.add(node);

                dfs(graph, node, destination, visited, path);
                path.remove(node);
            }
        }
 
        // Mark the current node
        visited.remove(source);
    }


    public static void findAllPaths(Digraph graph, Node source, Node destination){
        ArrayList<Node> visited = new ArrayList<>();
        ArrayList<Node> path = new ArrayList<>();
        path.add(source);
        dfs(graph, source, destination, visited, path);
        System.out.println("Done " + ALL_PATHS.toString());
    }

}
