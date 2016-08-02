/**
 * 
 */
package com.home.amit.ds;

/**
 * Represents an edge of a weighted graph.
 * 
 * @author Amit
 *
 */
public class WeightedEdge implements Comparable<WeightedEdge> {

	private int startVertex;
	private int endVertex;
	private int weight;

	/**
	 * 
	 */
	public WeightedEdge() {
	}

	/**
	 * @param startVertex
	 * @param endVertex
	 * @param weight
	 */
	public WeightedEdge(int startVertex, int endVertex, int weight) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}

	/**
	 * @return the startVertex
	 */
	public int getStartVertex() {
		return startVertex;
	}

	/**
	 * @param startVertex
	 *            the startVertex to set
	 */
	public void setStartVertex(int startVertex) {
		this.startVertex = startVertex;
	}

	/**
	 * @return the endVertex
	 */
	public int getEndVertex() {
		return endVertex;
	}

	/**
	 * @param endVertex
	 *            the endVertex to set
	 */
	public void setEndVertex(int endVertex) {
		this.endVertex = endVertex;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(WeightedEdge o) {
		if (this.getWeight() > o.getWeight())
			return 1;
		else if (this.getWeight() == o.getWeight())
			return 0;
		else
			return -1;
	}
}
