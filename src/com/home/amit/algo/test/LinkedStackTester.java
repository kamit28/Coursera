package com.home.amit.algo.test;

import com.home.amit.ds.IStack;
import com.home.amit.ds.StackLinkImpl;

public class LinkedStackTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IStack<Integer> myStack = new StackLinkImpl<Integer>();
		int i = 0;
		while (myStack.size() < 10) {
			myStack.push(i++);
		}
		System.out.println("Size is: " + myStack.size());

		System.out.println(myStack.pop());

		System.out.println("Size is: " + myStack.size());

		while (!myStack.isEmpty()) {
			System.out.print(myStack.pop() + "\t");
		}
		System.out.println();

		System.out.println("Size is: " + myStack.size());
	}
}
