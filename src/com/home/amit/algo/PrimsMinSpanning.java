/**
 * 
 */
package com.home.amit.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.home.amit.ds.WeightedEdge;

/**
 * @author Amit
 *
 */
public class PrimsMinSpanning {

	/**
	 * 
	 */
	public PrimsMinSpanning() {
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = null;
		in = new Scanner(new File("/Users/Anshu/Downloads/edges.txt"));

		// MSTProblem problem = new MSTProblem();
		// problem.setInput(new FileInputStream(new
		// File("/Users/Anshu/Downloads/edges.txt")));
		// problem.run();
		//
		// System.exit(0);

		int totalNodes = in.nextInt();
		int totalEdges = in.nextInt();
		List<List<WeightedEdge>> graph = new ArrayList<List<WeightedEdge>>();
		for (int i = 0; i < totalNodes; i++) {
			graph.add(new ArrayList<WeightedEdge>());
		}
		int vertex1;
		int vertex2;
		int cost;
		for (int i = 0; i < totalEdges; i++) {
			vertex1 = in.nextInt();
			vertex2 = in.nextInt();
			cost = in.nextInt();

			graph.get(vertex1 - 1).add(
					new WeightedEdge(vertex1 - 1, vertex2 - 1, cost));
			graph.get(vertex2 - 1).add(
					new WeightedEdge(vertex2 - 1, vertex1 - 1, cost));
		}
		in.close();
		// Print the adjacency list
		// graph.print();

		primSpanningtree(graph, totalNodes);

	}

	private static void primSpanningtree(List<List<WeightedEdge>> graph,
			int numNodes) {
		Set<Integer> X = new HashSet<Integer>();
		X.add(graph.get(0).get(0).getStartVertex());
		Set<WeightedEdge> T = new HashSet<WeightedEdge>();
		WeightedEdge cheapestEdge = null;

		while (!(X.size() == numNodes)) {
			cheapestEdge = findCheapestEdge(graph, X);
			T.add(cheapestEdge);
			X.add(cheapestEdge.getEndVertex());
		}

		long sumCost = 0;
		for (WeightedEdge edge : T) {
			sumCost += edge.getWeight();
		}

		System.out.println(sumCost);
	}

	private static WeightedEdge findCheapestEdge(
			List<List<WeightedEdge>> graph, Set<Integer> x) {
		Iterator<Integer> iter = x.iterator();
		List<WeightedEdge> edges = new ArrayList<WeightedEdge>();
		do {
			edges.addAll(graph.get(iter.next()));
		} while (iter.hasNext());

		Collections.sort(edges);
		for (WeightedEdge edge : edges) {
			if (!x.contains(edge.getEndVertex())) {
				return edge;
			}
		}
		return null;
	}
}
