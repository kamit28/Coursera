package com.home.amit.algo;

import java.util.Scanner;

public class CountingSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] arr = new int[s];
		for (int i = 0; i < s; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		int[] count = sort(arr);
		for (int x : count) {
			System.out.print(x + " ");
		}
	}

	public static int[] sort(int[] input) {
		int[] output = new int[input.length];

		// find max
		int k = max(input);
		int[] count = new int[k + 1];

		// calculate the histogram of key frequencies:
		for (int x : input) {
			count[x]++;
		}

		int total = 0;
		int oldCount = 0;
		for (int i = 0; i <= k; i++) {
			oldCount = count[i];
			count[i] = total;
			total += oldCount;
		}

		for (int x : input) {
			output[count[x]] = x;
			count[x]++;
		}

		return output;
	}

	private static int max(int[] arr) {
		int max = -1;
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
}
