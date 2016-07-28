/**
 * 
 */
package com.home.amit.ds;

import java.io.Serializable;

/**
 * @author amit
 * 
 */
public class TreeNode<E> implements Serializable {

	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The data object
	 */
	private E data;

	/**
	 * Pointer to the left subtree
	 */
	private TreeNode<E> left;

	/**
	 * Pointer to the right subtree
	 */
	private TreeNode<E> right;

	/**
	 * The default constructor. Creates a TreeNode object with data object set
	 * to null, left and right subtrees set to null.
	 */
	public TreeNode() {
		this(null, null, null);
	}

	public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the left subtree
	 */
	public TreeNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left subtree to set
	 */
	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the right subtree
	 */
	public TreeNode<E> getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right subtree to set
	 */
	public void setRight(TreeNode<E> right) {
		this.right = right;
	}
}
