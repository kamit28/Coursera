/**
 * 
 */
package com.home.amit.algo;

/**
 * @author amit
 * 
 */
public class MinInRotatedArray {
	public static int findMin(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return arr[i + 1];
			}
		}
		return arr[0];
	}

	public static int findMin_binarySearch(int[] arr) {
		int start = 0, end = arr.length - 1, mid;

		// array of size 1 or Unrotated case
		if (arr.length == 1 || arr[start] < arr[end]) {
			return arr[start];
		}

		while (start < end - 1) {
			mid = (start + end) >> 1;
			if (arr[start] > arr[mid]) {
				end = mid;
			} else {
				start = mid;
			}
		}

		return arr[start] < arr[end] ? arr[start] : arr[end];
	}
}
