/**
 * 
 */
package com.home.amit.algo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.home.amit.ds.UnionFind;

/**
 * @author Anshu
 *
 */
class Edge1 implements Comparable<Edge1> {
	int src;
	int dest;
	int weight;

	public Edge1(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge: " + src + " - " + dest + " | " + "  Weight: " + weight;
	}

	@Override
	public int compareTo(Edge1 another) {
		return this.weight - another.weight;
	}
}

/**
 * problem statement: What is the maximum spacing of a K-clustering
 * 
 * @author r.prateek
 *
 */
public class MaxSpacingKClustering {

	private int mNumVertices; // Number of vertices in the graph
	private int mNumEdges; // Number of edges in the graph
	private int maxClusterDistance; // for K cluster

	// Input Edge List
	private List<Edge1> mEdgeList;

	public MaxSpacingKClustering(int numVertices, int numEdges) {
		this.mNumVertices = numVertices;
		this.mNumEdges = numEdges;

		this.mEdgeList = new ArrayList<Edge1>(mNumEdges);
	}

	public int getMaxSpacing(int clusterCount) {

		Collections.sort(mEdgeList);

		UnionFind uf = new UnionFind(mNumVertices);

		if (clusterCount > uf.getCount()) {
			try {
				throw new Exception("Cluster counter is lesser than input");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		else {
			for (int i = 0; i < mNumVertices; i++) {
				Edge1 edge = mEdgeList.get(i);

				// if parents do not match, consider edge list for MST and ,
				// union the two vertex
				if (!uf.isConnected(edge.src, edge.dest)) {
					if (uf.getCount() == clusterCount) {
						uf.printCluster1();
						return maxClusterDistance = edge.weight;
					}

					int v1 = uf.Find(edge.src); // parent vertex for source
					int v2 = uf.Find(edge.dest); // parent vertex for
													// destinition
					uf.Union(v1, v2);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int numEdges = 0;
		Scanner in = null;
		MaxSpacingKClustering graph = null;
		try {
			in = new Scanner(new File("/Users/Anshu/Downloads/clustering1.txt"));
			int totalNodes = in.nextInt();
			graph = new MaxSpacingKClustering(totalNodes, 124750);
			int vertex1;
			int vertex2;
			int cost;
			while (in.hasNext()) {
				vertex1 = in.nextInt();
				vertex2 = in.nextInt();
				cost = in.nextInt();
				graph.mEdgeList.add(new Edge1(vertex1-1, vertex2-1, cost));
				numEdges++;
			}
			graph.mNumEdges = numEdges;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

		int k = 4;
		graph.maxClusterDistance = graph.getMaxSpacing(k);
		if (graph.maxClusterDistance != -1)
			System.out.println("Maximum Cluster Spacing for " + k
					+ " cluster is " + graph.maxClusterDistance);
		else
			System.out.println("Something went Wrong");

	}

	public void helper() {
		/*
		 * mEdgeList.add(new Edge1(1, 2, 4)); mEdgeList.add(new Edge1(2, 3, 8));
		 * mEdgeList.add(new Edge1(3, 4, 7)); mEdgeList.add(new Edge1(4, 5, 9));
		 * mEdgeList.add(new Edge1(5, 6, 10)); mEdgeList.add(new Edge1(6, 3,
		 * 4)); mEdgeList.add(new Edge1(6, 7, 2)); mEdgeList.add(new Edge1(7, 8,
		 * 1)); mEdgeList.add(new Edge1(18, 1, 8)); mEdgeList.add(new Edge1(8,
		 * 2, 11)); mEdgeList.add(new Edge1(8, 0, 7)); mEdgeList.add(new
		 * Edge1(0, 3, 2)); mEdgeList.add(new Edge1(0, 7, 6));
		 */

	}
}
