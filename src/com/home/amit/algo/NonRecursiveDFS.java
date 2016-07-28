/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.home.amit.ds.AdjacencyList;
import com.home.amit.ds.IStack;
import com.home.amit.ds.StackArrayImpl;
import com.home.amit.ds.StackLinkImpl;

/**
 * @author Anshu
 *
 */
public class NonRecursiveDFS {

	private boolean[] visited;

	public NonRecursiveDFS(int numVertices) {
		visited = new boolean[numVertices + 1];
	}

	public void dfs(AdjacencyList graph, int s) {
		IStack<Integer> stack = new StackArrayImpl<Integer>(graph.size() + 1);

		// push in stack
		stack.push(s);
		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				// visit it
				System.out.println(node + " has been visited");
				visited[node] = true;
			}
			Iterator<Integer> edgeIter = graph.getEdge(node).iterator();
			while (edgeIter.hasNext()) {
				int neighbor = edgeIter.next();
				// this neighbor has not been visited yet
				if (!visited[neighbor]) {
					stack.push(neighbor);
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		AdjacencyList list = new AdjacencyList(11);
		String sCurrentLine;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					"/Users/Anshu/Desktop/Amit/DFSDirected.txt")));
			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				String[] tokens = sCurrentLine.split("\\t");
				String token;
				int sVertex = Integer.parseInt(tokens[0]);
				int dVertex;
				for (int i = 1; i < tokens.length; i++) {
					token = tokens[i];
					if (null == token || token.trim().length() == 0)
						continue;
					dVertex = Integer.parseInt(token);
					list.setEdge(sVertex, dVertex);
				}
			}

			// Print the adjacency list
			list.print();

			// Traverse the graph
			NonRecursiveDFS dfs = new NonRecursiveDFS(list.size());
			dfs.dfs(list, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
	}

	void dfs1(AdjacencyList graph, int s) {
		// sanity check
		if (graph == null) {
			return;
		}

		// use a hash set to mark visited nodes
		Set<Integer> set = new HashSet<Integer>();

		// use a stack to help depth-first traversal
		IStack<Integer> stack = new StackLinkImpl<Integer>();
		stack.push(s);

		while (!stack.isEmpty()) {
			int curr = stack.pop();

			// current node has not been visited yet
			if (!set.contains(curr)) {
				// visit the node
				System.out.println(curr + " has been visited.");

				// mark it as visited
				set.add(curr);
			}
			Iterator<Integer> edgeIter = graph.getEdge(curr).iterator();
			while (edgeIter.hasNext()) {
				int neighbor = edgeIter.next();
				// this neighbor has not been visited yet
				if (!set.contains(neighbor)) {
					stack.push(neighbor);
				}
			}
		}
	}
}
