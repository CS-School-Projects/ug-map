package app.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import app.graph.Digraph;
import static app.utils.Functions.*;
import app.graph.Edge;
import app.graph.Node;

public class Dijkstra {
    private static ArrayList<Node> Q = new ArrayList<>();
    private static HashMap<Node, Long> dist = new HashMap<>();
    private static HashMap<Node, Node> prev = new HashMap<>();

    public static void findShortestPath(Digraph graph, Node source, Node destination){
        for(Node node: graph.getNodes()){
            dist.put(node, Long.MAX_VALUE);
            prev.put(node, null);
            Q.add(node);
        }
        dist.put(source, 0L);

        while(Q.size() > 0){
            Node u = findVertextWithMinDist();
            Q.remove(u);
            ArrayList<Edge> edges = graph.getDestinationEdges(u);
            for(Edge edge : edges){
                if(Q.contains(edge.getDestination())){
                    long alt = dist.get(u) + edge.getDistance();
                    if (alt < dist.get(edge.getDestination())){
                        dist.put(edge.getDestination(), alt);
                        prev.put(edge.getDestination(), u);
                    }
                }
                printPrevious();
            }
        }    

        println("DONE");
        printPrevious();
    }
    
    private static void printDistances(){
        println("*****************************");
        for (HashMap.Entry<Node, Long> entry : dist.entrySet()) {
            Node node = entry.getKey();
            long d = entry.getValue();
            println(node.getName() + " --> " + d);
        }
    }

    private static void printPrevious(){
        println("*****************************");
        for (HashMap.Entry<Node, Node> entry : prev.entrySet()) {
            Node node = entry.getKey();
            Node prev = entry.getValue();
            if(prev != null)
            println(node.getName() + " --> " + prev.getName());
            else{
                println(  node.getName() + " --> " +"Nope");
            }
        }
    }

    private static Node findVertextWithMinDist() {
        Node minNode = null;
        long minDistance = Long.MAX_VALUE;

        for (HashMap.Entry<Node, Long> entry : dist.entrySet()) {
            Node node = entry.getKey();
            Long distance = entry.getValue();
           if(Q.contains(node) && distance < minDistance){
                minDistance = distance;
                minNode = node;
           }
        }
        return minNode;
    }
}
