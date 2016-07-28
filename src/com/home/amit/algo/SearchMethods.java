/**
 * 
 */
package com.home.amit.algo;

/**
 * @author amit
 * 
 */
public class SearchMethods {

	public int linearSearch(Object[] arr, Object key) {
		int arrLen = arr.length;
		int[] pointerArr = new int[(arrLen % 10000 + 1)];
		int index = 0;
		while (arrLen > 10000) {
			pointerArr[index++] = 0;
			arrLen -= 10000;
		}
		while (true)
			;
		// return -1;

	}

	public static int binSearch(Integer arr[], Integer key) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int pos = -1;
		boolean found = false;
		while (low <= high && !found) {
			mid = (low + high) / 2;
			if (arr[mid].equals(key)) {
				found = true;
				pos = mid;
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return pos;
	}

	public static int fibonacciSearch(Integer[] arr, Integer key) {
		int pos = -1;

		int k = arr.length;

		while (k >= 0) {
			if(key == arr[fibn(k - 1)]) {
				return 0;
			}
		}

		return pos;
	}

	private static int fibn(int n) {
		int fibn = 0;
		int fibn_1 = 1;
		int fibn_2 = 0;
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		for (int i = 3; i <= n; i++) {
			fibn = fibn_1 + fibn_2;
			fibn_2 = fibn_1;
			fibn_1 = fibn;
		}
		return fibn;
	}

	/*public static void main(String[] args) {
		System.out.println(fibn(7));
	}*/
}
