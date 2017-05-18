package com.home.amit.algo;

import java.util.Scanner;

public class InsertionSort {
	public static void insertionSortPart2(int[] ar) {
		int temp;
		for (int i = 1; i < ar.length; i++) {
			temp = ar[i];
			for (int j = i - 1; j >= 0 && ar[j] > temp; j--) {
				ar[j + 1] = ar[j];
				ar[j] = temp;
			}
			printArray(ar);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		insertionSortPart2(ar);

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
