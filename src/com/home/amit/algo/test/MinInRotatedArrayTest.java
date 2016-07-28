/**
 * 
 */
package com.home.amit.algo.test;

import com.home.amit.algo.MinInRotatedArray;

/**
 * @author amit
 * 
 */
public class MinInRotatedArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 14, 2, 3, 4, 5, 8, 10, 11 };

		System.out.println(MinInRotatedArray.findMin(arr));
		System.out.println(MinInRotatedArray.findMin_binarySearch(arr));
	}
}
