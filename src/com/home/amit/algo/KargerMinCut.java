/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.home.amit.ds.AdjacencyList;

/**
 * @author Amit
 *
 */
public class KargerMinCut {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Read the file and create adjacency list
		AdjacencyList list = new AdjacencyList(6);
		String sCurrentLine;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					"/Users/Anshu/Downloads/kargerMinCutSmall.txt")));
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

			// Get minCut

			System.out.println("Min Cut is: " + getMinCut(list));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
	}

	public static int getMinCut(AdjacencyList adjList) {
		while (adjList.size() > 2) {
			int nodeIndex = (int) (Math.random() * adjList.getVertices().size());
			Integer randomNode = (Integer) (adjList.getVertices().toArray()[nodeIndex]);
			int edgeIndex = (int) (Math.random() * adjList.getEdge(randomNode)
					.size());
			Integer randomEdge = adjList.getEdge(randomNode).get(edgeIndex);
			adjList.mergeVertices(randomNode, randomEdge);
		}
		return adjList.getEdge(1).size();
	}
}
