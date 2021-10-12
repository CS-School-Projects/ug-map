package app.graph;

import java.util.ArrayList;

public class Edge {
    private Node source;
    private Node destination;
    private long time;
    private long distance;
    private ArrayList<String> landMarks = new ArrayList<>();

    public Edge(Node source, Node destination, long distance){
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = -1;
    }

    public Edge(Node source, Node destination, long distance,  long time){
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }

    public Node getDestination() {
        return destination;
    }

    public Node getSource() {
        return source;
    }

    public long getDistance() {
        return distance;
    }
    
    public long getTime() {
        return time;
    }

}
