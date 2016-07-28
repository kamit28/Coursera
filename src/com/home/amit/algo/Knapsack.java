package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Knapsack {

	static int numItems;
	static int W;// size of knapsack

	static class Item {
		int v; // value
		int w; // weight

		public Item(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][];

		Path p = Paths.get("/Users/Anshu/Downloads/knapsack_big.txt");
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			BufferedReader br = Files.newBufferedReader(p,
					StandardCharsets.UTF_8);
			String line = br.readLine();
			numItems = Integer.parseInt(line.split(" ")[1]);
			W = Integer.parseInt(line.split(" ")[0]);
			while ((line = br.readLine()) != null) {
				int v = Integer.parseInt(line.split(" ")[0]);
				int w = Integer.parseInt(line.split(" ")[1]);
				items.add(new Item(v, w));
			}
			A = new int[2][W + 1];
			for (int x = 0; x < W + 1; x++) {
				A[0][x] = 0;
			}
			for (int i = 0; i < numItems; i++) {
				for (int x = 0; x < W + 1; x++) {
					int j = 0;
					if (x < items.get(i).w) {
						A[1][x] = A[j][x];
					} else {
						A[1][x] = Math.max(A[j][x], A[j][x - items.get(i).w]
								+ items.get(i).v);
					}
				}
				// copy A[1] to A[0]
				for (int k = 0; k < W + 1; k++)
					A[0][k] = A[1][k];
			}

			System.out.println("Answer :: " + A[1][W]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
