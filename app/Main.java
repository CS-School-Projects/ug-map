package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;    

import app.algorithms.AStar;
import app.algorithms.DFS;
import app.algorithms.Dijkstra;
import app.graph.Edge;
import app.graph.Graph;
import app.graph.Node;


public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Nodes in the graph.
        Node gym = new Node("Gym");
        Node diaspora = new Node("Diaspora");
        Node ish = new Node("ISH");
        Node nightMarket = new Node("Night Market");
        Node sarbahHall = new Node("Sarbah Hall");
        Node commonWealth = new Node("Common Wealth");
        Node greatHall = new Node("Great Hall");        
        Node legonHall = new Node("Legon Hall");
        Node akuafoHall = new Node("Akuafo Hall");
        Node voltaHall = new Node("Volta Hall");
        Node balmeLibrary = new Node("Balme Library");
        Node cbas = new Node("CBAS");
        Node mainGate = new Node("Main Gate");
        Node jqb = new Node("JQ Building");
        Node lawSchool = new Node("Law School");
        Node busSchool = new Node("Business School");
        Node gcb = new Node("GCB");
        Node csdepartment = new Node("CS Department");
        Node polictialScienceDepartment = new Node("Political Science Department");
        Node nb = new Node("NB");
        Node nnb = new Node("NNB");

        graph.addEdge(new Edge(gym, diaspora, 500, 10)); 
        graph.addEdge(new Edge(gym, ish, 415, 8)); 
        graph.addEdge(new Edge(gym, nightMarket, 634, 9)); 
        
        graph.addEdge(new Edge(diaspora, ish, 400, 8)); 
        graph.addEdge(new Edge(ish, nightMarket, 214, 3)); 

        graph.addEdge(new Edge(nightMarket, commonWealth, 1025, 20)); 
        graph.addEdge(new Edge(nightMarket, legonHall, 914, 17)); 
        graph.addEdge(new Edge(nightMarket, sarbahHall, 350, 5)); 

        graph.addEdge(new Edge(commonWealth, greatHall, 515, 9)); 
        graph.addEdge(new Edge(commonWealth, voltaHall, 440, 5)); 
        graph.addEdge(new Edge(commonWealth, legonHall, 460, 5)); 

        graph.addEdge(new Edge(sarbahHall, legonHall, 630, 12)); 
        graph.addEdge(new Edge(sarbahHall, akuafoHall, 460, 8)); 

        graph.addEdge(new Edge(legonHall, akuafoHall, 583, 7)); 
        graph.addEdge(new Edge(legonHall, balmeLibrary, 530, 6)); 
        graph.addEdge(new Edge(legonHall, voltaHall, 260, 3)); 

        graph.addEdge(new Edge(akuafoHall, cbas, 385, 5)); 
        graph.addEdge(new Edge(akuafoHall, csdepartment, 780, 13)); 
        graph.addEdge(new Edge(akuafoHall, balmeLibrary, 580, 7)); 

        graph.addEdge(new Edge(cbas, mainGate, 624, 6)); 
        graph.addEdge(new Edge(cbas, jqb, 610, 9)); 
        graph.addEdge(new Edge(jqb, lawSchool, 466, 5)); 

        graph.addEdge(new Edge(lawSchool, csdepartment, 384, 4)); 

        graph.addEdge(new Edge(balmeLibrary, lawSchool, 960, 18)); 
        graph.addEdge(new Edge(balmeLibrary, busSchool, 203, 4)); 

        graph.addEdge(new Edge(voltaHall, busSchool, 390, 3)); 
        graph.addEdge(new Edge(voltaHall, balmeLibrary, 415, 5)); 

        graph.addEdge(new Edge(voltaHall, balmeLibrary, 415, 5)); 
        
        graph.addEdge(new Edge(busSchool, gcb, 433, 5)); 
        graph.addEdge(new Edge(busSchool, nb, 424, 5)); 
        graph.addEdge(new Edge(busSchool, csdepartment, 389, 4)); 
        
        graph.addEdge(new Edge(polictialScienceDepartment, csdepartment, 386, 4)); 
        graph.addEdge(new Edge(polictialScienceDepartment, nb, 204, 3)); 
        graph.addEdge(new Edge(nb, nnb, 330, 4)); 
        graph.addEdge(new Edge(nnb, gcb, 160, 3)); 

        // MAP GUI
        UgMap ugMap = new UgMap();  
        JFrame mapFrame =new JFrame();  
        mapFrame.add(ugMap);  
        mapFrame.setTitle("UG MAP");
        mapFrame.setSize(850,774);  
        mapFrame.setVisible(true);

        // GUI
        final int WINDOW_WIDTH = 800;
        final int WINDOW_HEIGHT = 600;

        String[] places = new String[graph.getNodeSize()];
        int index = 0;
        for(Node node: graph.getNodes()){
            places[index] = node.getName();
            index++;
        }

        JFrame frame = new JFrame();
        frame.setTitle("UG MAP: Controls UI");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        // Source
        JComboBox<String> sourceCombo = new JComboBox<String>(places);
        JLabel sourceLabel = new JLabel("CurrentLocation:");
        sourceLabel.setForeground(Color.MAGENTA);
        sourceLabel.setBounds(10,10,WINDOW_WIDTH/2-100,20);
        sourceCombo.setBounds(5,20,WINDOW_WIDTH/2-100,40);
        frame.add(sourceCombo);
        frame.add(sourceLabel);

        // Destination
        JComboBox<String> destinationCombo = new JComboBox<String>(places);
        JLabel detinationLabel = new JLabel("I'm going to:");
        detinationLabel.setForeground(Color.MAGENTA);
        detinationLabel.setBounds(WINDOW_WIDTH/2 + 50, 10, WINDOW_WIDTH/2-100,20);
        destinationCombo.setBounds(WINDOW_WIDTH/2+ 50, 20, WINDOW_WIDTH/2-100,40);
        frame.add(destinationCombo);
        frame.add(detinationLabel);

        // Find Button
        JButton btnFindShortestPath = new JButton("Find Shortest Route");
        btnFindShortestPath.setBounds(WINDOW_WIDTH/2 - 300 ,70,300,60);
        frame.add(btnFindShortestPath);

        // Find Button
        JButton btnFindFasterPath = new JButton("Find Fastest Route");
        btnFindFasterPath.setBounds(WINDOW_WIDTH/2 + 50, 70, 300, 60);
        frame.add(btnFindFasterPath);


        // Find
        JLabel shortestPathLabel = new JLabel("Best Routes: ");
        shortestPathLabel.setBounds(10,110,WINDOW_WIDTH/2-100,20);
        shortestPathLabel.setForeground(Color.MAGENTA);
        frame.add(shortestPathLabel);
      
        // Shortest Route Result
        JLabel shortestPathResultLabl = new JLabel();
        shortestPathResultLabl.setBounds(10,130,WINDOW_WIDTH - 10,20);
        frame.add(shortestPathResultLabl);

        // Shortest Distance Result
        JLabel shortestDistaneResultLabl = new JLabel();
        shortestDistaneResultLabl.setBounds(10,150,WINDOW_WIDTH - 10,20);
        frame.add(shortestDistaneResultLabl);


        // Landmarks
        JLabel landMarkResultLable = new JLabel("Land Marks:");
        landMarkResultLable.setBounds(10,170,WINDOW_WIDTH - 10,20);
        frame.add(landMarkResultLable);


        JSeparator sep = new JSeparator();  
        sep.setBounds(5,195,WINDOW_WIDTH - 5,10);
        frame.add(sep);  

        // Landmarks
        JLabel altPathLabel = new JLabel("Alternative Routes");
        altPathLabel.setForeground(Color.MAGENTA);
        altPathLabel.setBounds(10,220,WINDOW_WIDTH - 10,20);
        frame.add(altPathLabel);


        JTextArea area = new JTextArea();  
        JScrollPane pane = new JScrollPane();
        pane.getViewport ().setView(area);
        pane.setBounds(10,240,WINDOW_WIDTH - 20,200);
        frame.add(pane);  

        btnFindShortestPath.addActionListener(event->{
            String souceName = sourceCombo.getSelectedItem().toString();
            String destName = destinationCombo.getSelectedItem().toString();

            Node soucNode = graph.getNodeByName(souceName);
            Node destNode = graph.getNodeByName(destName);
            ArrayList<Node> shortestPath = Dijkstra.findShortestPath(graph, soucNode, destNode);

            shortestPathResultLabl.setText("The Shortest Route is: " + shortestPath.toString());
            shortestDistaneResultLabl.setText("Total Distance is: "+Dijkstra.getDistance(destNode));

            ArrayList<ArrayList<Node>> allPaths = DFS.findAllPaths(graph, soucNode, destNode);

            StringBuilder builder = new StringBuilder();
            for (ArrayList<Node> nodes :allPaths.subList(allPaths.size() - 6, allPaths.size()-1) ){
                String distance = String.format("%.3f",  graph.calculateDistance(nodes)/1000f) + "km";
                builder.append(nodes.toString() + ", " + distance+ "\n");
            }

            area.setText(builder.toString());
        });

        btnFindFasterPath.addActionListener(event->{
            String souceName = sourceCombo.getSelectedItem().toString();
            String destName = destinationCombo.getSelectedItem().toString();

            Node soucNode = graph.getNodeByName(souceName);
            Node destNode = graph.getNodeByName(destName);
            Dijkstra.findShortestPath(graph, soucNode, destNode);
            List<Node> fastesPath = AStar.findFastestPath(graph, soucNode, destNode);

            shortestPathResultLabl.setText("The Fastest Route is: " + fastesPath.toString());
            shortestDistaneResultLabl.setText("Total Distance is: "+Dijkstra.getDistance(destNode));

            ArrayList<ArrayList<Node>> allPaths = DFS.findAllPaths(graph, soucNode, destNode);

            StringBuilder builder = new StringBuilder();
            for (ArrayList<Node> nodes :allPaths.subList(allPaths.size() - 6, allPaths.size()-1) ){
                String distance = String.format("%.3f",  graph.calculateDistance(nodes)/1000f) + "km";
                builder.append(nodes.toString() + ", " + distance+ "\n");
            }

            area.setText(builder.toString());
        });

        frame.setLayout(null);
        frame.setVisible(true);

    }
}