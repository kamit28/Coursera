/**
 * 
 */
package com.home.amit.ds;

import java.io.Serializable;

/**
 * @author Amit
 *
 */
public interface IQueue<E> extends Cloneable, Serializable {

	public E dequeue();

	public E peek();

	public void enqueue(E element);

	public boolean isFull();

	public boolean isEmpty();

	public int size();

}
