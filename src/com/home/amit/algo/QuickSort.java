/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Anshu
 *
 */
public class QuickSort {

	private static long numComparisons = 0;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// int[] arr = { 10, 7, 5, 1, 9, 6, 4, 3, 8, 2 };

		int[] arr = new int[10000];
		String sCurrentLine;
		int i = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					"/Users/Anshu/Downloads/QuickSort.txt")));
			while ((sCurrentLine = br.readLine()) != null) { //
				System.out.println(sCurrentLine);
				arr[i++] = Integer.parseInt(sCurrentLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}

		sort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();
		System.out.println("Number of comparisons: " + numComparisons);

	}

	private static void sort(int[] a, int low, int high) {
		if (high <= low) {
			return;
		} else {
			numComparisons += (high - low);
		}
		int medianPos = medianOf3(a, low, high);
		swap(a, low, medianPos);
		int pivot = partition3(a, low, high);
		// int pivot = partition1(a, low, high);

		sort(a, low, pivot - 1);
		sort(a, pivot + 1, high);
	}

	private static void swap(int[] a, int x, int y) {
		int temp = a[y];
		a[y] = a[x];
		a[x] = temp;
	}

	@SuppressWarnings("unused")
	private static int partition1(int[] a, int low, int high) {
		int pivot = a[low];
		int i = low;
		int temp;
		for (int j = low + 1; j <= high; j++) {
			if (a[j] < pivot) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i, low);

		return i;
	}

	@SuppressWarnings("unused")
	private static int partition2(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (a[j] < pivot) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i, high);

		return i;
	}

	private static int partition3(int[] a, int low, int high) {
		int pivot = a[low];
		int i = low;

		for (int j = low + 1; j <= high; j++) {
			if (a[j] < pivot) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i, low);

		return i;
	}

	private static int medianOf3(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int x = arr[low];
		int y = arr[high];
		int z = arr[mid];
		int medianPos = 0;
		int median = Math.max(Math.min(x, y), Math.min(Math.max(x, y), z));
		if (median == x)
			medianPos = low;
		else if (median == y)
			medianPos = high;
		else
			medianPos = mid;
		return medianPos;
	}
}
