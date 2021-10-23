package app.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import app.graph.Digraph;
import app.graph.Edge;
import app.graph.Node;

public class Dijkstra2 {
    public static void findShortestPath(Digraph graph, Node source, Node destination){
        ArrayList<Node> visitedNodes  = new ArrayList<>();

        for (Node node: graph.getNodes()){
            if(node == source){
                visitedNodes.add(node);
                // distances.put(node, 0L);
                break;
            }
            // else{
            //     distances.put(node, Long.MAX_VALUE);
            // }
        }

        while(visitedNodes.size() != graph.getNodeSize()){

            HashMap<Node, Long> distances = new HashMap<>();

            for(Edge edge: graph.getEdges(visitedNodes.get(visitedNodes.size()-1))){
                distances.put(edge.getDestination(), edge.getDistance());
            }
            
            Node nodeWithMinDistance = null;
            long minDistance = Long.MAX_VALUE;
            for (HashMap.Entry<Node, Long> entry : distances.entrySet()) {
                Node node = entry.getKey();
                Long distance = entry.getValue();
               if(!visitedNodes.contains(node) && distance < minDistance){
                    minDistance = distance;
                    nodeWithMinDistance = node;
               }
            }
            visitedNodes.add(nodeWithMinDistance);
        }

        for(Node node: visitedNodes){
            if(node != null)
            System.out.print(node.getName() + " -> ");
        }
        System.out.println(" ");
    }
}
