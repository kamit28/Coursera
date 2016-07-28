package com.home.amit.algo.test;

import com.home.amit.algo.MergeSort;

public class MergeSortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr = { 7, 9, 15, 3, 21, 0, 1, 4 };

		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();

		MergeSort.mergeSort(arr, 0, arr.length);

		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();
	}
}
