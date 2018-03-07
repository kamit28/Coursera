package com.home.amit.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Topological sort in a graph represented by a sparse matrix.
public class TopologicalSort {

	public static void main(String[] args) {
		int[][] adj = { { 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } };

		List<Integer> sequence = topSort(adj);

		if (sequence.isEmpty()) {
			System.out.println("Cycle detected in the graph");
		} else {
			sequence.forEach(System.out::print);
		}
	}

	private static List<Integer> topSort(int[][] adj) {
		List<Integer> visited = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < adj.length && queue.isEmpty(); i++) {
			boolean hasInEdge = false;
			for (int j = 0; j < adj.length && !hasInEdge; j++) {
				if (adj[j][i] != 0) {
					hasInEdge = true;
				}
			}
			if (!hasInEdge) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int n = queue.poll();
			visited.add(n);

			for (int i = 0; i < adj.length; i++) {
				if (adj[n][i] != 0) {
					adj[n][i] = 0;
					boolean hasInEdge = false;
					for (int j = 0; j < adj.length && !hasInEdge; j++) {
						if (adj[j][i] != 0) {
							hasInEdge = true;
						}
					}
					if (!hasInEdge) {
						queue.offer(i);
					}
				}
			}
		}

		if (visited.size() != adj.length)
			visited.clear();
		return visited;
	}
}
