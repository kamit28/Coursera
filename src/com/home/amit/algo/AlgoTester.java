package com.home.amit.algo;

public class AlgoTester {
	
	public static void main(String[] args) {
		Integer[] intArr = new Integer[10000];
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = i + 2;
		}
		
		System.out.println(SearchMethods.binSearch(intArr, 500));
		System.out.println(SearchMethods.binSearch(intArr, 501));
		System.out.println(SearchMethods.binSearch(intArr, 502));
		System.out.println(SearchMethods.binSearch(intArr, 1));
	}
}
