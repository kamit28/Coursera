/**
 * 
 */
package com.home.amit.ds;

import java.io.Serializable;

/**
 * @author amit
 * 
 */
public class Node<E> implements Cloneable, Serializable {

	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = -1949949459505599848L;

	private E data;

	private Node<E> next;

	private Node<E> previous;

	public Node() {
		this(null, null, null);
	}

	public Node(E data, Node<E> next, Node<E> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	public Node(Node<E> node) {
		this.data = node.data;
		this.next = node.next;
		this.previous = node.previous;
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
	 * @return the next
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}

	/**
	 * @return the previous
	 */
	public Node<E> getPrevious() {
		return previous;
	}

	/**
	 * @param previous
	 *            the previous to set
	 */
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
}
