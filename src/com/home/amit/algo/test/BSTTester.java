package com.home.amit.algo.test;

import com.home.amit.ds.BinarySearchTree;

public class BSTTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();

		myTree.insertElement(50);
		myTree.insertElement(80);
		myTree.insertElement(25);
		myTree.insertElement(12);
		myTree.insertElement(35);
		myTree.insertElement(90);
		myTree.insertElement(100);
		myTree.insertElement(70);

		System.out.println(myTree.searchElement(90) ? "Element found"
				: "Element not found");
		System.out.println(myTree.searchElement(40) ? "Element found"
				: "Element not found");

	}

}
