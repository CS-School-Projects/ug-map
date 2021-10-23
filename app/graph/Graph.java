package app.graph;
import static app.utils.Functions.*;

import java.util.ArrayList;

public class Graph extends Digraph {
    
    @Override
    public void addEdge(Edge edge){
        if(edges.contains(edge)) return;

        this.edges.add(edge);
        this.edges.add(new Edge(edge.getDestination(), edge.getSource(), edge.getDistance()));
        for(Node node : graph.keySet()){
            if (node == edge.getSource()){
                graph.get(node).add(edge.getDestination());
            }
        } 

        for(Node node : graph.keySet()){
            if (node == edge.getDestination()){
                graph.get(node).add(edge.getSource());
            }
        } 
    }
}
