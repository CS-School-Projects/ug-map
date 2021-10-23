package app;


import app.algorithms.Dijkstra;
import app.graph.Digraph;
import app.graph.Edge;
import app.graph.Graph;
import app.graph.Node;


public class Main{
    public static void main(String[] args) {
        Digraph graph = new Digraph();
        // Graph graph = new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);

        graph.addEdge(new Edge(a, b, 2));
        graph.addEdge(new Edge(a, c, 4));

        graph.addEdge(new Edge(b, d, 8));
        graph.addEdge(new Edge(b, c, 3));

        graph.addEdge(new Edge(c, d, 2));
        graph.addEdge(new Edge(c, e, 5));

        graph.addEdge(new Edge(d, f, 1));
        graph.addEdge(new Edge(d, e, 9));

        graph.addEdge(new Edge(e, f, 22));

        graph.printGraph();

        Dijkstra.findShortestPath(graph, b,a);
        
    }
}