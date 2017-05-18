/**
 * 
 */
package com.home.amit.algo.recursive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import com.home.amit.ds.AdjacencyList;

/**
 * @author Amit
 *
 */
public class DFS {

	private boolean[] visited;

	public DFS(int numVertices) {
		visited = new boolean[numVertices + 1];
	}

	public void dfs(AdjacencyList graph, int s) {
		visited[s] = true;
		System.out.println(s + " has been visited.");
		Iterator<Integer> sListIter = graph.getEdge(s).iterator();
		while (sListIter.hasNext()) {
			int nextVertex = sListIter.next();
			if (!visited[nextVertex]) {
				dfs(graph, nextVertex);
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
			DFS dfs = new DFS(list.size());
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

}
