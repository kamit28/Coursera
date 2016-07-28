/**
 * 
 */
package com.home.amit.ds;

import java.io.Serializable;

/**
 * @author amit
 * 
 */
public interface IStack<E> extends Cloneable, Serializable {

	public E pop();

	public E peek();

	public void push(E element);

	public boolean isFull();

	public boolean isEmpty();
	
	public int size();
}
