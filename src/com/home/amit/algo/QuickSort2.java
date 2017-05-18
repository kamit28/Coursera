package com.home.amit.algo;

import java.util.Scanner;

public class QuickSort2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = in.nextInt();
		}
		in.close();

		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] a, int low, int high) {
		if (low < high) {

			int pivot = partition(a, low, high);

			sort(a, low, pivot - 1);
			sort(a, pivot + 1, high);
		} else {
			return;
		}
	}

	private static void swap(int[] a, int x, int y) {
		int temp = a[y];
		a[y] = a[x];
		a[x] = temp;
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (a[j] < pivot) {
				swap(a, i, j);
				i++;
			}
		}
		swap(a, i, high);
		for (int val : a) {
			System.out.print(val + " ");
		}
		System.out.println();
		return i;
	}
}
