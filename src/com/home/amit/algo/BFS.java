/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.home.amit.ds.AdjacencyList;
import com.home.amit.ds.IQueue;
import com.home.amit.ds.QueueArrayImpl;

/**
 * @author Amit
 *
 */
public class BFS {

	/**
	 * 
	 */
	public BFS() {
	}

	public void bfs(AdjacencyList graph, int s) {
		assert (graph != null);

		IQueue<Integer> queue = new QueueArrayImpl<Integer>(graph.getVertices()
				.size() + 1);
		boolean[] visited = new boolean[graph.getVertices().size() + 1];

		queue.enqueue(s);

		int vertex;
		List<Integer> neighbours = null;
		while (!queue.isEmpty()) {
			vertex = queue.dequeue();
			if (!visited[vertex]) {
				visited[vertex] = true;
				System.out.println(vertex + " has been visited");
			}

			neighbours = graph.getEdge(vertex);
			for (int neighbour : neighbours) {
				if (!visited[neighbour]) {
					queue.enqueue(neighbour);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BFS bfs = new BFS();
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
			bfs.bfs(list, 1);
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
