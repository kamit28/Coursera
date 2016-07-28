/**
 * 
 */
package com.home.amit.algo.test;

import com.home.amit.algo.BubbleSort;

/**
 * @author Anshu
 *
 */
public class SortAlgosTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = {"Amit", "Sumit", "Anshu", "Ashi", "Vrishali", "Ravi", "Zeus", "Sandeep", "George"};
		BubbleSort<String> sorter = new BubbleSort<String>();
		arr = sorter.bubbleSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

}
