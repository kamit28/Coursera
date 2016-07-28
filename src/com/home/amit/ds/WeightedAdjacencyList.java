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
public class WeightedAdjacencyList {

	private Map<Integer, List<WeightedEdge>> graph;

	/**
	 * @param adjacencyList
	 */
	public WeightedAdjacencyList(int numberOfvertices) {
		this.graph = new HashMap<Integer, List<WeightedEdge>>(numberOfvertices);
		for (int i = 0; i < numberOfvertices; i++) {
			this.graph.put(i + 1, new LinkedList<WeightedEdge>());
		}
	}

	public void setEdge(int u, WeightedEdge v) {
		if (!this.graph.containsKey(u)
				|| !this.graph.containsKey(v.getEndVertex())) {
			throw new IllegalArgumentException(
					"The vertex entered is not present in the graph");
		}
		List<WeightedEdge> slist = this.graph.get(u);
		slist.add(v);
	}

	public List<WeightedEdge> getEdge(int source) {
		if (!this.graph.containsKey(source)) {
			throw new IllegalArgumentException(
					"The vertex entered is not present in the graph");
		}
		return this.graph.get(source);
	}

	public void removeEdge(int u, WeightedEdge v) {
		if (!this.graph.containsKey(u) || !this.graph.containsKey(v)) {
			throw new IllegalArgumentException(
					"The vertex entered is not present in the graph");
		}
		List<WeightedEdge> slist = this.graph.get(u);
		remove(slist, v);
	}

	private void remove(List<WeightedEdge> list, WeightedEdge v) {
		Iterator<WeightedEdge> iter = list.iterator();
		while (iter.hasNext()) {
			if (iter.next().getEndVertex() == v.getEndVertex()) {
				iter.remove();
				break;
			}
		}
	}

	public void print() {
		for (int i = 0; i < this.graph.size(); i++) {
			System.out.print(i + 1 + "->");
			List<WeightedEdge> edgeList = getEdge(i + 1);
			if (edgeList != null && edgeList.size() > 0) {
				for (int j = 1;; j++) {
					if (j != edgeList.size()) {
						System.out.print(edgeList.get(j - 1).getEndVertex() + ","
								+ edgeList.get(j - 1).getWeight() + " -> ");
					} else {
						System.out.print(edgeList.get(j - 1).getEndVertex() + ","
								+ edgeList.get(j - 1).getWeight());
						break;
					}
				}
				
			}
			System.out.println();
		}
	}

	public int size() {
		return this.graph.size();
	}

	public Set<Integer> getVertices() {
		return graph.keySet();
	}
}
