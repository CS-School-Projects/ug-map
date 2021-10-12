package app;

import app.graph.Digraph;
import app.graph.Edge;
import app.graph.Node;

public class Main{
    public static void main(String[] args) {
        Digraph graph = new Digraph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(e);

        graph.addEdge(new Edge(a, b, 2));
        graph.addEdge(new Edge(a, c, 1));
        graph.addEdge(new Edge(a, d, 2));
        graph.addEdge(new Edge(b, d, 3));
        graph.addEdge(new Edge(c, d, 3));
        
    }
}