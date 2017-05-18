package com.home.amit.algo;

import java.util.Arrays;
import java.util.Scanner;

public class RuntimeOfSort {
	private static int qSortCount = 0;
	private static int insertionSortCount = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		int[] ar2 = Arrays.copyOf(ar, ar.length);
		quickSort(ar, 0, s - 1);
		insertionSort(ar2);
		System.out.println(insertionSortCount - qSortCount);
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (end > start) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = left;
		int temp = arr[right];
		for (int i = left; i < right; i++) {
			if (arr[i] < temp) {
				swap(arr, i, pivot);
				pivot++;
				qSortCount++;
			}
		}
		swap(arr, right, pivot);
		qSortCount++;
		return pivot;
	}

	private static void swap(int[] arr, int i, int j) {
		if (i != j) {
			int temp;
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public static void insertionSort(int[] ar) {
		int temp;
		for (int i = 1; i < ar.length; i++) {
			temp = ar[i];
			int j = i - 1;
			for (; j >= 0 && ar[j] > temp; j--) {
				ar[j + 1] = ar[j];
				insertionSortCount++;
			}
			ar[j + 1] = temp;
		}
	}
}
