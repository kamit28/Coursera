/**
 * 
 */
package com.home.amit.algo;

import java.lang.reflect.Array;

/**
 * @author amit
 * 
 */
public class MergeSort {

	public static <E extends Comparable<? super E>> void mergeSort(E[] arr,
			int low, int high) {
		int mid;

		if (high > low) {
			mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, (mid + 1), high);
			mergeLists(arr, low, high);
		}
	}

	@SuppressWarnings("unchecked")
	private static <E extends Comparable<? super E>> void mergeLists(E[] arr,
			int low, int high) {
		int mid = (low + high) / 2;
		int l_low = low;
		int r_low = mid + 1;
		int index = 0;
		E[] mergeLists = (E[]) Array.newInstance(arr.getClass()
				.getComponentType(), (high - low + 1));

		while (l_low <= mid && r_low <= high) {
			if (arr[l_low].compareTo(arr[r_low]) < 0) {
				mergeLists[index++] = arr[l_low++];
			} else {
				mergeLists[index++] = arr[r_low++];
			}
		}
		while (l_low <= mid) {
			mergeLists[index++] = arr[l_low++];
		}
		while (r_low <= high) {
			mergeLists[index++] = arr[r_low++];
		}
		System.arraycopy(mergeLists, 0, arr, low, mergeLists.length);
	}
}
