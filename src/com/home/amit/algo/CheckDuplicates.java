package com.home.amit.algo;

//Find duplicate number in array in O(n) time and O(1) extra space
public class CheckDuplicates {
	public void hasDuplicates(int[] arrA) {

		for (int i = 0; i < arrA.length; i++) {
			// check if element is negative, if yes the we have found the duplicate
			if (arrA[Math.abs(arrA[i])] < 0) {
				System.out.println("Array has duplicates : " + Math.abs(arrA[i]));
			} else {
				arrA[Math.abs(arrA[i])] = arrA[Math.abs(arrA[i])] * -1;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 6, 3, 0, 1, 5, 4, 2};
		new CheckDuplicates().hasDuplicates(a);
	}
}
