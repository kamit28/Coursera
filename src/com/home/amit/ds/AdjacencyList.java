/**
 * 
 */
package com.home.amit.ds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Anshu
 *
 */
public class AdjacencyList {

	private Map<Integer, List<Integer>> adjacencyList;

	/**
	 * @param adjacencyList
	 */
	public AdjacencyList(int numberOfvertices) {
		this.adjacencyList = new HashMap<Integer, List<Integer>>(
				numberOfvertices);
		for (int i = 0; i < numberOfvertices; i++) {
			this.adjacencyList.put(i + 1, new LinkedList<Integer>());
		}
	}

	public void setEdge(int u, int v) {
		if (!this.adjacencyList.containsKey(u)
				|| !this.adjacencyList.containsKey(v)) {
			throw new IllegalArgumentException(
					"The vertex entered is not present in the graph");
		}
		List<Integer> slist = this.adjacencyList.get(u);
		slist.add(v);
	}

	public List<Integer> getEdge(int source) {
		if (!this.adjacencyList.containsKey(source)) {
			throw new IllegalArgumentException(
					"The vertex entered is not present in the graph");
		}
		return this.adjacencyList.get(source);
	}

	public void removeEdge(int u, int v) {
		if (!this.adjacencyList.containsKey(u)
				|| !this.adjacencyList.containsKey(v)) {
			throw new IllegalArgumentException(
					"The vertex entered is not present in the graph");
		}
		List<Integer> slist = this.adjacencyList.get(u);
		remove(slist, v);
	}

	private void remove(List<Integer> list, int vertex) {
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			if (iter.next() == vertex) {
				iter.remove();
				break;
			}
		}
	}

	public void mergeVertices(int u, int v) {
		if (!this.adjacencyList.containsKey(u)
				|| !this.adjacencyList.containsKey(v)) {
			throw new IllegalArgumentException(
					"The vertex entered is not present in the graph");
		}
		List<Integer> slist = this.adjacencyList.get(u);
		List<Integer> dlist = this.adjacencyList.get(v);
		slist.addAll(dlist);

		this.adjacencyList.remove(v);

		Iterator<Integer> it = this.getVertices().iterator();
		while (it.hasNext()) {
			Integer currentKey = (Integer) it.next();
			List<Integer> currentItemList = getEdge(currentKey);
			for (Integer i : currentItemList) {
				if (i == v) {
					currentItemList.set(currentItemList.indexOf(i), u);
				}
			}
		}

		// remove self loops
		Iterator<Integer> iter = slist.iterator();
		while (iter.hasNext()) {
			int val = iter.next();
			if (val == u) {
				iter.remove();
			}
		}
	}

	public void print() {
		for (int i = 0; i < this.adjacencyList.size(); i++) {
			System.out.print(i + 1 + "->");
			List<Integer> edgeList = getEdge(i + 1);
			for (int j = 1;; j++) {
				if (j != edgeList.size()) {
					System.out.print(edgeList.get(j - 1) + "->");
				} else {
					System.out.print(edgeList.get(j - 1));
					break;
				}
			}
			System.out.println();
		}
	}

	public int size() {
		return this.adjacencyList.size();
	}

	public Set<Integer> getVertices() {
		return adjacencyList.keySet();
	}
	
	public AdjacencyList getReversedGraph(AdjacencyList graph) {
		if(graph == null) return null;
		
		AdjacencyList reversedGraph = new AdjacencyList(graph.size());
		Iterator<Integer> iter = graph.getVertices().iterator();
		int vertex;
		List<Integer> edgesList;
		while(iter.hasNext()) {
			vertex = iter.next();
			edgesList = graph.getEdge(vertex);
			for(int i : edgesList) {
				reversedGraph.setEdge(i, vertex);
			}
		}
		return reversedGraph;
	}

}
