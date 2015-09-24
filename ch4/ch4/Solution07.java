package ch4;

import java.util.ArrayList;
import java.util.List;

class TopoNode {
	char val;
	ArrayList<TopoNode> neighbours;
	int indegree;

}

public class Solution07 {
	public List<TopoNode> findOrder(TopoNode[] allNodes) {
		/*
		 * While ( not all nodes are visited ) {
		 * 
		 * 1. Find the node with zero indegree
		 * 
		 * 2. Print the node
		 * 
		 * 3. For all its neighbours
		 * 
		 * 3.1 Reduce the indegree by 1
		 * 
		 * 4. Mark cur node visited.
		 * 
		 * }
		 */
		return null;
	}

	public static void main(String[] args) {

		/*
		 * Input : Projects and Dependency pairs
		 * 
		 * 1. Create a node for every project. and add their dependencies to
		 * neighbours
		 * 
		 * 2. Loop through every node and calculate indegree by incrementing
		 * everytime we see a node as someone's neighbour
		 * 
		 * Lastly call function findOrder
		 * 
		 */
	}
}
