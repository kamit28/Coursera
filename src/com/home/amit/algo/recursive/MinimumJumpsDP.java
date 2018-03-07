package com.home.amit.algo;

import java.util.HashMap;
import java.util.Map;

//Program to find minimum jump path to get to the end of the array - using dynamic programming
public class MinimumJumpsDP {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int findJumps(int[] arr, int start) {
		// we are at the end of the array, we are done
		if (start == arr.length - 1) {
			return 0;
		}

		if (map.containsKey(start)) {
			return map.get(start);
		}

		// we encountered 0, can't find a path anymore, return MAX
		if (arr[start] == 0) {
			return Integer.MAX_VALUE;
		}

		int size = arr.length;
		int remaining = size - start;

		// next step will take us to end.
		if (remaining <= arr[start]) {
			return 1;
		}

		int jumps = Integer.MAX_VALUE;

		for (int i = 1; i <= arr[start]; i++) {
			int temp = findJumps(arr, start + i);

			if (temp != Integer.MAX_VALUE) {
				jumps = Math.min(jumps, 1 + temp);
			}
		}
		map.put(start, jumps);
		return jumps;
	}

	public static void main(String[] args) {

		MinimumJumpsDP m = new MinimumJumpsDP();
		int arr[] = { 2, 5, 8, 9, 2, 6, 7, 6, 1, 2, 5, 8, 9, 2, 6, 7, 6, 8, 9, 1, 1, 6, 8, 9, 1, 1, 1 };

		// int arr[] = { 1, 3, 4, 8, 9 };
		long startTime = System.currentTimeMillis();
		System.out.println("Minimum Jumps required: " + m.findJumps(arr, 0));
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - startTime) + " milli-seconds");
	}
}
