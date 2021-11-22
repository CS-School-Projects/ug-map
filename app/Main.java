package app;

import javax.swing.*;

import app.algorithms.AStar;
import app.algorithms.BFS;
import app.algorithms.Dijkstra;
import app.graph.Edge;
import app.graph.Graph;
import app.graph.Node;


public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node mainGate = new Node("Main Gate");
        Node greatHall = new Node("Great Hall");
        Node newNBlock = new Node("New N Block");
        Node jqb = new Node("JQ Building");
        Node legon = new Node("Legon");
        Node cc = new Node("CC");
        Node diaspora = new Node("Diaspora");
        Node blameLibrary = new Node("Balme Library");

        graph.addNode(mainGate);
        graph.addNode(greatHall);
        graph.addNode(newNBlock);
        graph.addNode(jqb);
        graph.addNode(cc);
        graph.addNode(legon);
        graph.addNode(diaspora);
        graph.addNode(blameLibrary);

        graph.addEdge(new Edge(mainGate, greatHall, 200));
        graph.addEdge(new Edge(mainGate, newNBlock, 400));
        graph.addEdge(new Edge(mainGate, blameLibrary, 800));
        graph.addEdge(new Edge(mainGate, legon, 800));

        graph.addEdge(new Edge(greatHall, jqb, 800));
        graph.addEdge(new Edge(greatHall, newNBlock, 100));

        graph.addEdge(new Edge(newNBlock, jqb, 200));
        graph.addEdge(new Edge(newNBlock, cc, 500));

        graph.addEdge(new Edge(jqb, diaspora, 100));
        graph.addEdge(new Edge(jqb, cc, 900));

        graph.addEdge(new Edge(cc, diaspora, 2200));
        graph.addEdge(new Edge(cc, blameLibrary, 100));
        graph.addEdge(new Edge(blameLibrary, cc, 100));

        graph.printGraph();

        System.out.println("Please choose your current location:");
        graph.listPlaces(null);


        // String place = scanner.nextLine();
        // Node source = graph.getNodeByName(place);

        // System.out.println("\nPlease choose your destination:");
        // String place2 = scanner.nextLine();
        // Node destination = graph.getNodeByName(place2);
        // Dijkstra.findShortestPath(graph, source, destination);

        // AStar.findShortestPath(graph, source,destination);

        // GUI
        String places[] = {"Great Hall", "Balme Library", "CC", "New N Block", "Diaspora", "JQ Building"};
        JFrame frame = new JFrame();

        JComboBox<String> sourceCombo = new JComboBox<String>(places);
        sourceCombo.setBounds(10,10,400,40);
        frame.add(sourceCombo);
        JComboBox<String> destinationCombo = new JComboBox<String>(places);
        destinationCombo.setBounds(10,50,400,40);
        frame.add(destinationCombo);

        JButton btnFindShortestPath = new JButton("Find Shortest Path");
        btnFindShortestPath.setBounds(10,90,400,40);
        frame.add(btnFindShortestPath);

        btnFindShortestPath.addActionListener(event->{
            String souceName = sourceCombo.getSelectedItem().toString();
            String destName = destinationCombo.getSelectedItem().toString();

            Node soucNode = graph.getNodeByName(souceName);
            Node destNode = graph.getNodeByName(destName);
            Dijkstra.findShortestPath(graph, soucNode, destNode);

            BFS.findAllPaths(graph, soucNode, destNode);
        });

        frame.setLayout(null);
        frame.setSize(800,600);
        frame.setVisible(true);

    }
}