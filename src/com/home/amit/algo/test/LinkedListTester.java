package com.home.amit.algo.test;

import com.home.amit.ds.IList;
import com.home.amit.ds.ListLinkImpl;

public class LinkedListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IList<Integer> myList = new ListLinkImpl<Integer>();
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
