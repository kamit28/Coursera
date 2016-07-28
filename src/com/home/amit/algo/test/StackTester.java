package com.home.amit.algo.test;

import com.home.amit.ds.IStack;
import com.home.amit.ds.StackArrayImpl;

public class StackTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IStack<Integer> myStack = new StackArrayImpl<Integer>(10);
		int i = 0;
		while (!myStack.isFull()) {
			myStack.push(i++);
		}
		System.out.println("Size is: " + myStack.size());

		myStack.pop();

		System.out.println("Size is: " + myStack.size());

		while (!myStack.isEmpty()) {
			System.out.print(myStack.pop() + "\t");
		}
		System.out.println();

		System.out.println("Size is: " + myStack.size());
	}
}
