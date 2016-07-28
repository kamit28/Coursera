/**
 * 
 */
package com.home.amit.ds;

/**
 * @author amit
 * 
 */
public class StackLinkImpl<E> extends ListLinkImpl<E> implements IStack<E> {

	/**
	 * The serial version UID
	 */
	private static final long serialVersionUID = 685560699333916457L;

	private int top;

	public StackLinkImpl() {
		super();
		top = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IStack#pop()
	 */
	@Override
	public E pop() {
		return super.remove(top);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IStack#peek()
	 */
	@Override
	public E peek() {
		return super.get(top);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IStack#push(java.lang.Object)
	 */
	@Override
	public void push(E element) {
		super.add(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IStack#isFull()
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public int size() {
		return super.size();
	}
}
