
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class VogelApproximationMethod {
// 	int vertices;
// 	int[][] matrix;
// 	int[] rowPenalties;
// 	int[] columnPenalties;
// 	int solutionCost = 0; 
// 	LinkedList<Edge> provisionalRoute = new LinkedList<>();
// 	LinkedList<Edge> ordered = new LinkedList<Edge>();
	
// 	public VogelApproximationMethod(int vertices, int[][] matrix) {
// 		this.vertices = vertices;
// 		this.matrix = matrix;
// 		this.rowPenalties = new int[vertices];
// 		this.columnPenalties = new int[vertices];
// 	}
	
// 	public void calculatePenalties() {
// 		for(int i = 0; i < vertices; i++) {
			
// 			int rowSmallest = Integer.MAX_VALUE;
// 			int rowSecondSmallest = Integer.MAX_VALUE;
			
// 			//finding smallest row penalty
// 			List<Integer> a = new ArrayList<>();
// 			for(int j = 0; j < vertices; j++) {
// 				a.add(matrix[i][j]);
// 			}
// 			Collections.sort(a);
			
// 			for(int k = 0; k < a.size(); k++) {
// 				for(int j = 0; j < a.size(); j++) {
// 					if(a.get(j) == 0) {
// 						a.remove(j);
// 					}
// 				}
// 			}
			
// 			rowSmallest = a.get(0);
// 			if(a.size()<2) {
// 				rowSecondSmallest = a.get(0);
// 			}else {
// 				rowSecondSmallest = a.get(1);
// 			}
			
			
// 			//adding row difference to penalties array
// 			rowPenalties[i] = rowSecondSmallest - rowSmallest;
			
// 			//finding smallest column penalty
// 			int columnSmallest = Integer.MAX_VALUE;
// 			int columnSecondSmallest = Integer.MAX_VALUE;
			
// 			List<Integer> b = new ArrayList<>();
// 			for(int j = 0; j < vertices; j++) {
// 				b.add(matrix[j][i]);
// 			}
// 			Collections.sort(b);
			
// 			for(int k = 0; k < b.size(); k++) {
// 				for(int j = 0; j < b.size(); j++) {
// 					if(b.get(j) == 0) {
// 						b.remove(j);
// 					}
// 				}
// 			}
			
// 			columnSmallest = b.get(0);
// 			if(b.size()<2) {
// 				columnSecondSmallest = b.get(0);
// 			}else {
// 				columnSecondSmallest = b.get(1);
// 			}
			
			
// 			//adding column difference to penalties array
// 			columnPenalties[i] = columnSecondSmallest - columnSmallest;
			
// 		}

// 	}
	
// 	public void getProvisionalRoute() {
// 		int largestRowPenalty = 0;
// 		int largestColumnPenalty = 0;
// 		int largestRowPenaltyIndex = 0;
// 		int largestColumnPenaltyIndex = 0; 
// 		int largestPenaltyIndex = 0;
// 		int smallestPenaltyCost = Integer.MAX_VALUE;
// 		String largestPenaltySource = "";
// 		int cellRow = 0;
// 		int cellColumn = 0;
		
		
// 		//finding largest column and row penalty and 
// 		//the indexes they occurs at.
// 		for(int i = 0; i < vertices; i++) {
// 			if(rowPenalties[i] > largestRowPenalty) {
// 				largestRowPenalty = rowPenalties[i];
// 				largestRowPenaltyIndex = i;
// 			}
// 			if(columnPenalties[i] > largestColumnPenalty) {
// 				largestColumnPenalty = columnPenalties[i];
// 				largestColumnPenaltyIndex = i;
// 			}
// 		}
		
// 		//selecting larger penalty between rows and columns
// 		if(largestRowPenalty >= largestColumnPenalty) {
// 			largestPenaltySource = "Row";
// 			largestPenaltyIndex = largestRowPenaltyIndex;
// 		} else if(largestColumnPenalty > largestRowPenalty) {
// 			largestPenaltySource = "Column";
// 			largestPenaltyIndex = largestColumnPenaltyIndex;
// 		}
		
		
// 		//finding smallest cost from the row or column with
// 		//largest penalty
// 		for(int i = 0; i < vertices; i++) {
// 			if(largestPenaltySource == "Row") {
// 				if(matrix[largestPenaltyIndex][i] > 0 && matrix[largestPenaltyIndex][i] < smallestPenaltyCost) {
// 					smallestPenaltyCost = matrix[largestPenaltyIndex][i];
// 					cellRow = largestPenaltyIndex;
// 					cellColumn = i;
// 				}
// 			}
// 			if(largestPenaltySource == "Column") {
// 				if(matrix[i][largestPenaltyIndex] > 0 && matrix[i][largestPenaltyIndex] < smallestPenaltyCost) {
// 					smallestPenaltyCost = matrix[i][largestPenaltyIndex];
// 					cellRow = i;
// 					cellColumn = largestPenaltyIndex;
// 				}
// 			}
// 		}
		
// 		Edge edge = new Edge(cellRow, cellColumn, matrix[cellRow][cellColumn]);
		
// 		provisionalRoute.add(edge);
// 		LinkedList<Edge> ordered = new LinkedList<>();
		
// 		this.sortRoute();
// 		this.ordered = ordered;
		
// 		//crossing out potential multi-ring problem cells
// 		for(int i = 0; i < vertices; i++) {
// 			matrix[cellRow][i] = 0;
// 			matrix[i][cellColumn] = 0;
// 		}
// 		matrix[cellColumn][cellRow]=0;
		
// 		for(int i = 0; i < this.ordered.size(); i++) {
// 			matrix[(Integer)this.ordered.get(0).source][(Integer)this.ordered.get(i).destination] = 0;
// 			matrix[(Integer)this.ordered.get(i).destination][(Integer)this.ordered.get(0).source] = 0;
// 		}
		
// 		for(int i = 0; i < provisionalRoute.size(); i++) {
// 			for(int j = 0; j < provisionalRoute.size(); j++) {
// 				if(provisionalRoute.get(i).source == provisionalRoute.get(j).destination && provisionalRoute.get(i).destination == provisionalRoute.get(j).source) {
// 					provisionalRoute.remove(j);
// 				}
// 			}
// 		}
// 	}
	
// 	public void sortRoute() {
		
// 		for(int i = 0; i < this.provisionalRoute.size(); i++) {
// 			Edge current = this.provisionalRoute.get(i);
			
// 			for(int j = 0; j < this.provisionalRoute.size(); j++) {
// 				if(current.source == this.provisionalRoute.get(j).destination) {
// 					this.provisionalRoute.add(i, this.provisionalRoute.remove(j));
// 				}
// 				else if(current.destination == this.provisionalRoute.get(j).source) {
// 					if(j == this.provisionalRoute.size()-1) {
// 						this.provisionalRoute.addLast(this.provisionalRoute.remove(j));
// 					}else {
// 						this.provisionalRoute.add(i+1, this.provisionalRoute.remove(j));
// 					}
// 				}
// 			}
// 			break;
// 		}
// 	}
	
// 	public void getSolutionCost() {
// 		for(Edge e : provisionalRoute) {
// 			solutionCost+= e.weight;
// 		}
// 		System.out.println("Approximate Solution Cost from Vogel Approximation: "+solutionCost +" meters");
// 	}
	
// 	public void printGraph() {
// 		System.out.println("Graph: (Adjacency Matrix)");
// 		for(int i = 0; i < vertices; i++) {
// 			System.out.println(Arrays.toString(matrix[i]));
// 		}
// 		System.out.println();
// //		for (int i = 0; i < vertices; i++) {
// //			System.out.println("Vertex " + i + " is connected to: ");
// //			for(int j = 0; j < vertices; j++) {
// //				if(matrix[i][j]>0) {
// //					System.out.print(j + " ");
// //				}
// //			}
// //			System.out.println();
// //		}
// 	}
}
