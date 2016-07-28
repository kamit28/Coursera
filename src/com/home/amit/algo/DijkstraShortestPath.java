/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.home.amit.ds.WeightedAdjacencyList;
import com.home.amit.ds.WeightedEdge;

/**
 * @author Anshu
 *
 */
public class DijkstraShortestPath {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String sCurrentLine;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
			// "/Users/Anshu/Downloads/dijkstraData.txt")));
					"/Users/Anshu/Downloads/dijkstraSmall.txt")));
			WeightedAdjacencyList graph = new WeightedAdjacencyList(200);
			while ((sCurrentLine = br.readLine()) != null) {
				String[] tokens = sCurrentLine.split("\\t");
				String token;
				int sVertex = Integer.parseInt(tokens[0]);
				WeightedEdge edge;
				String[] edgeData;
				for (int i = 1; i < tokens.length; i++) {
					token = tokens[i];
					if (null == token || token.trim().length() == 0)
						continue;
					edgeData = token.split(",");
					edge = new WeightedEdge();
					
					//edge.getEndVertex(Integer.parseInt(edgeData[0]));
					edge.setWeight(Integer.parseInt(edgeData[1]));
					graph.setEdge(sVertex, edge);
				}
			}

			// Print the adjacency list
			// graph.print();

			dijkstra0(graph, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
	}

	/**
	 * 
	 * @param graph
	 * @param source
	 */

	public static void dijkstra0(WeightedAdjacencyList graph, int source) {
		Set<Integer> unvisited = new HashSet<Integer>();
		int[] dist = new int[graph.size() + 1];
		int[] previous = new int[graph.size() + 1];
		int UNDEFINED = -9999;
		int INFINITY = 1000000;
		dist[source] = 0;
		unvisited.add(source);
		Iterator<Integer> graphIter = graph.getVertices().iterator();
		int vertex;
		while (graphIter.hasNext()) {
			vertex = graphIter.next();
			if (vertex != source) {
				dist[vertex] = INFINITY;
				previous[vertex] = UNDEFINED;
				unvisited.add(vertex);
			}
		}
		WeightedEdge edge = null;
		int i = source;
		int alt;
		int u;
		while (!unvisited.isEmpty()) {
			u = getMinDistVertex(unvisited, dist);
			// edge = getMinUnvistedEdge(graph, unvisited, i);
			unvisited.remove(u);
			for (WeightedEdge neighbour : graph.getEdge(u)) {
				alt = dist[u] + neighbour.getWeight();
				if (alt < dist[neighbour.getEndVertex()]) {
					dist[neighbour.getEndVertex()] = alt;
					previous[neighbour.getEndVertex()] = u;
				}
			}
		}

		for (int count = 1; count < dist.length; count++) {
			System.out.println("Vertex: " + count + "\t Distance : "
					+ dist[count] + "\t Previous: " + previous[count]);
		}
		System.out.println();
	}

	public static void dijkstra(WeightedAdjacencyList graph, int source) {
		Set<Integer> visited = new HashSet<Integer>();
		int[] dist = new int[graph.size() + 1];
		Arrays.fill(dist, 1000000);
		String[] sequence = new String[graph.size() + 1];

		dist[source] = 0;
		sequence[source] = "" + source;
		WeightedEdge edge = null;
		visited.add(source);
		int i = source;
		int temp;
		while (visited.size() < graph.size()) {
			edge = getMinUnvistedEdge(graph, visited, i);
			if (edge != null) {
				temp = edge.getWeight() + dist[i];
				if (temp < dist[edge.getEndVertex()]) {
					dist[edge.getEndVertex()] = edge.getWeight() + dist[i];
					sequence[edge.getEndVertex()] = sequence[i] + ", "
							+ edge.getEndVertex();
				}
			}
			visited.add(edge.getEndVertex());
			i = edge.getEndVertex();
		}

		for (int count = 1; count < dist.length; count++) {
			System.out.print("(" + sequence[count] + ") : " + dist[count]
					+ "\t");
		}
		System.out.println();

	}

	private static WeightedEdge getMinUnvistedEdge(WeightedAdjacencyList graph,
			Set<Integer> unvisited, int i) {
		Iterator<WeightedEdge> iter = graph.getEdge(i).iterator();
		WeightedEdge minEdge = new WeightedEdge();
		minEdge.setWeight(10000000);
		WeightedEdge temp = null;
		while (iter.hasNext()) {
			temp = iter.next();
			if (unvisited.contains(temp.getEndVertex())) {
				if (temp.getWeight() < minEdge.getWeight()) {
					minEdge = temp;
				}
			}
		}

		return minEdge;
	}

	private static int getMinDistVertex(Set<Integer> unvisited, int[] dist) {
		Iterator<Integer> iter = unvisited.iterator();
		int min = 1000000;
		int vertex = 1;
		int temp;
		while (iter.hasNext()) {
			temp = iter.next();
			if (dist[temp] < min) {
				vertex = temp;
				min = dist[vertex];
			}
		}
		return vertex;
	}
}
