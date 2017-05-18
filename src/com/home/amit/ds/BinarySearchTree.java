/**
 * 
 */
package com.home.amit.ds;

import java.util.Comparator;

/**
 * @author amit
 * 
 */
public class BinarySearchTree<E> {

	private TreeNode<E> root;

	private Comparator<? super E> comparator;

	public BinarySearchTree() {
		root = null;
		comparator = null;
	}

	public void insertElement(E element) {
		TreeNode<E> node = new TreeNode<E>(element, null, null);
		TreeNode<E> temp = null;
		TreeNode<E> prev = null;
		// If tree is empty
		if (root == null) {
			root = node;
		} else {
			for (temp = root; temp != null;) {
				prev = temp;
				if (comparator.compare(temp.getData(), element) > 0) {
					temp = temp.getLeft();
				} else if (comparator.compare(temp.getData(), element) < 0) {
					temp = temp.getRight();
				} else {
					System.out
							.println("Can not insert in tree. Object already exists.");
				}
			}
			if (comparator.compare(prev.getData(), element) > 0) {
				prev.setLeft(node);
			} else if (comparator.compare(prev.getData(), element) < 0) {
				prev.setRight(node);
			}
		}
	}

	public boolean searchElement(E element) {
		TreeNode<E> temp = root;

		while (temp != null) {
			if (comparator.compare(temp.getData(), element) == 0) {
				return true;
			} else if (comparator.compare(temp.getData(), element) > 0) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
		}
		return false;
	}
}
