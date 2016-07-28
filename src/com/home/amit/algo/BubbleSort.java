/**
 * 
 */
package com.home.amit.algo;

/**
 * @author Anshu
 *
 */
public class BubbleSort<T extends Comparable<T>> {

	public T[] bubbleSort(T[] arr) {
		T temp;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j< arr.length; j++) {
				if(arr[i].compareTo(arr[j]) > 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

}
