package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.home.amit.ds.AdjacencyList;

public class Kosaraju_ConnectedComponents {

	public static void main(String[] args) throws IOException {
		AdjacencyList list = new AdjacencyList(875714);
		//AdjacencyList list = new AdjacencyList(11);
		String sCurrentLine;
		BufferedReader br = null;
		try {
			// br = new BufferedReader(new FileReader(new File(
			// "/Users/Anshu/Desktop/Amit/DFSDirected.txt")));
			br = new BufferedReader(new FileReader(new File(
					//"/Users/Anshu/Downloads/SCCSmall1.txt")));
					"/Users/Anshu/Downloads/SCC.txt")));
			while ((sCurrentLine = br.readLine()) != null) {
				// String[] tokens = sCurrentLine.split("\\t");
				String[] tokens = sCurrentLine.split(" ");
				int sVertex = Integer.parseInt(tokens[0].trim());
				int dVertex = Integer.parseInt(tokens[1].trim());
				list.setEdge(sVertex, dVertex);
			}

			// Print the adjacency list
			// list.print();
			boolean[] visited = new boolean[list.size() + 1];
			List<Integer> order = new ArrayList<Integer>();
			Iterator<Integer> iter = list.getVertices().iterator();
			while (iter.hasNext()) {
				int s = iter.next();
				if (!visited[s]) {
					dfs_kosaraju(list, visited, order, s);
				}
			}

			AdjacencyList revGraph = list.getReversedGraph(list);
			// revGraph.print();

			Arrays.fill(visited, false);
			List<List<Integer>> sccs = new ArrayList<List<Integer>>();
			Collections.reverse(order);

			for (int u : order) {
				if (!visited[u]) {
					List<Integer> scc = new ArrayList<Integer>();
					dfs_kosaraju(revGraph, visited, scc, u);
					sccs.add(scc);
				}
			}

			/*for (List<Integer> scc : sccs) {
				for (int i : scc) {
					System.out.print(i + ", ");
				}
				System.out.println();
			}*/
			Collections.sort(sccs, new ListSizeComparator());
			Collections.reverse(sccs);
			for (int i = 0, j = 0; i < sccs.size() && j < 5; i++, j++) {
					System.out.print(sccs.get(i).size() + ",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}

	}

	public static void dfs_kosaraju(AdjacencyList graph,
			boolean[] visited, List<Integer> order, int s) {
		visited[s] = true;
		// System.out.println(s + " has been visited.");
		Iterator<Integer> sListIter = graph.getEdge(s).iterator();
		while (sListIter.hasNext()) {
			int nextVertex = sListIter.next();
			if (!visited[nextVertex]) {
				dfs_kosaraju(graph, visited, order, nextVertex);
			}
		}
		order.add(s);
	}

}
