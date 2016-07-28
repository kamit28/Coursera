package com.home.amit.algo.test;

import com.home.amit.ds.IList;
import com.home.amit.ds.ListArrayImpl;

public class ListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IList<Integer> myList = new ListArrayImpl<Integer>();
		System.out.println(myList.size());
		myList.add(20);
		System.out.println(myList.size());
		myList.add(30);
		myList.add(40);
		System.out.println(myList.size());
		myList.remove(2);
		System.out.println(myList.size());
		myList.remove(1);
		System.out.println(myList.size());
	}

}
