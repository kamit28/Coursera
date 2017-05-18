/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * @author Amit
 *
 */
public class CountInversions {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// int[] arr = { 8,7,6,5,4,3,2,1};
		int[] arr = new int[100000];
		String sCurrentLine;
		int i = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					"/Users/Anshu/Downloads/integerInversionCount")));
			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				arr[i++] = Integer.parseInt(sCurrentLine);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		long totalInversions = mergeSort(arr, 0, arr.length - 1);
		System.out.println(totalInversions);

		/*for (int val : arr) {
			System.out.print(val + "\t");
		}*/
		System.out.println();
	}

	public static long mergeSort(int[] arr, int low, int high) {
		int mid;
		long total = 0;

		if (high > low) {
			mid = (low + high) / 2;
			total += mergeSort(arr, low, mid);
			total += mergeSort(arr, (mid + 1), high);
			total += mergeLists(arr, low, high);
		}
		return total;
	}

	private static long mergeLists(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int l_low = low;
		int r_low = mid + 1;
		int index = 0;
		long total = 0;
		int[] mergeLists = (int[]) Array.newInstance(arr.getClass()
				.getComponentType(), (high - low + 1));

		while (l_low <= mid && r_low <= high) {
			if (arr[l_low] < (arr[r_low])) {
				mergeLists[index++] = arr[l_low++];
			} else {
				mergeLists[index++] = arr[r_low++];
				total += (mid - l_low + 1);
			}
		}
		while (l_low <= mid) {
			mergeLists[index++] = arr[l_low++];
		}
		while (r_low <= high) {
			mergeLists[index++] = arr[r_low++];
		}
		System.arraycopy(mergeLists, 0, arr, low, mergeLists.length);
		return total;
	}
}
