package app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Digraph {
    protected HashMap<Node, ArrayList<Node>> graph = new HashMap<>();
    protected ArrayList<Edge> edges = new ArrayList<>();
    private int nodeSize = 0;


    public void addNode(Node node){
        if (!graph.containsKey(node)){
            graph.put(node, new ArrayList<>());
            nodeSize++;
        }
    }

    public void addEdge(Edge edge){
        if(edges.contains(edge)) return;

        this.edges.add(edge);
        for(Node source : graph.keySet()){
            if (source == edge.getSource()){
                graph.get(source).add(edge.getDestination());
            }
        }
    }

    public ArrayList<Edge> getDestinationEdges(Node source){
        ArrayList<Edge> destinations = new ArrayList<>();
        for (Edge edge: this.edges){
            if (edge.getSource() == source){
                 destinations.add(edge);
            }
        }
        return destinations;
    }

    public Edge getEdge(Node source, Node destination) {
       for (Edge edge: this.edges){
           if (edge.getSource() == source && edge.getDestination() == destination){
               return edge;
           }
       }
       return null;
    }

    public Node getNodeByName(String name){
        for(Node node : graph.keySet()){
            if (node.getName().equals(name)){
                return node;
            }
        }
        return null;
    }

    public Set<Node> getNodes(){
        return this.graph.keySet();
    }

    public int getNodeSize() {
        return nodeSize;
    }

}
