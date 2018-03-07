package com.home.amit.algo;

public class MatrixChainOrderOptimization {

	int[][] m;
	int[][] splits;

	public static void main(String[] args) {
		int[] dims = { 2, 3, 3, 4 };

		MatrixChainOrderOptimization optimizer = new MatrixChainOrderOptimization();

		optimizer.matrixChainOrdering(dims);
		optimizer.printOptimalParenthesizations();
	}

	public void matrixChainOrdering(int[] dims) {
		int n = dims.length - 1;
		m = new int[n][n];
		splits = new int[n][n];

		for (int lenMinusOne = 1; lenMinusOne < n; lenMinusOne++) {
			for (int i = 0; i < n - lenMinusOne; i++) {
				int j = i + lenMinusOne;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int cost = m[i][k] + m[k + 1][j] + dims[i] * dims[k + 1] * dims[j + 1];
					if (cost < m[i][j]) {
						m[i][j] = cost;
						splits[i][j] = k;
					}
				}
			}
		}
	}

	public void printOptimalParenthesizations() {
		char ch = 'A';
		printOptimalParenthesizations(splits, 0, splits.length - 1, ch);
	}

	void printOptimalParenthesizations(int[][] s, int i, int j, char ch) {
		if (i == j) {
			System.out.print(ch);

			return;
		}
		System.out.print("(");
		printOptimalParenthesizations(s, i, s[i][j], ++ch);
		printOptimalParenthesizations(s, s[i][j] + 1, j, ch);

		System.out.print(")");
	}

}
