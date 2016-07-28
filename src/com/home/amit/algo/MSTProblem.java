package com.home.amit.algo;

public class MSTProblem extends Problem {

	@Override
	public void run() {
		UndirectedWeightedGraph graph = readGraph();
		SpanningTree result = Prims.execute(graph);
		out.print(result.cost());
		out.flush();
	}

	private UndirectedWeightedGraph readGraph() {
		int n = scanner.nextInt();
		UndirectedWeightedGraph graph = new UndirectedWeightedGraph(n);

		int m = scanner.nextInt();

		for (int i = 0; i < m; i++) {
			int v = scanner.nextInt();
			int u = scanner.nextInt();
			int weight = scanner.nextInt();

			graph.addEdge(v - 1, u - 1, weight);
		}

		return graph;
	}

}
