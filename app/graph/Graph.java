// package app.graph;

// public class Graph extends Digraph {
    
//     @Override
//     public void addEdge(Edge edge){
//         if(edges.contains(edge)) return;

//         this.edges.add(edge);
//         for(Node node : graph.keySet()){
//             if (node == edge.getSource()){
//                 graph.get(node).add(edge.getDestination());
//             }
//         } 

//         for(Node node : graph.keySet()){
//             if (node == edge.getDestination()){
//                 graph.get(node).add(edge.getSource());
//             }
//         } 
//     }
// }
