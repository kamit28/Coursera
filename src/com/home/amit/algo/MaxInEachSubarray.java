package com.home.amit.algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaxInEachSubarray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t;
		t = s.nextInt();
		while (t > 0) {
			int n, k;
			n = s.nextInt();
			k = s.nextInt();
			int i;
			int arr[] = new int[n];
			for (i = 0; i < n; i++)
				arr[i] = s.nextInt();
			printKMax(arr, n, k);
			t--;
		}
		s.close();
	}

	static void printKMax(int arr[], int n, int k) {
		Deque<Integer> d = new ArrayDeque<>(k);
		int i = 0;
		for (; i < k; i++) {
			while(!d.isEmpty() && arr[i] >= arr[d.peekLast()]) {
				d.pollLast();
			}
			d.push(i);
		}
		
		for (; i < n; i++) {
			System.out.print(arr[d.peekFirst()] + " ");
			
			while(!d.isEmpty() && d.peekFirst() <= i - k) {
				d.pollFirst();
			}
			
			while(!d.isEmpty() && arr[i] >= arr[d.peekLast()]) {
				d.pollLast();
			}
			d.offerLast(i);
		}
		System.out.print(arr[d.pollFirst()] + " ");
	}
}
