package com.home.amit.ds;

public class StackArrayImpl<E> extends ListArrayImpl<E> implements IStack<E> {

	/**
	 * The Serial version UID
	 */
	private static final long serialVersionUID = -6415133007703489821L;

	private int top;

	public StackArrayImpl() {
		super(10);
	}

	public StackArrayImpl(int capacity) {
		super(capacity);
		top = -1;
	}

	@Override
	public E pop() {
		return remove(top--);
	}

	@Override
	public E peek() {
		return getElement(top);
	}

	@Override
	public void push(E element) {
		add(element);
		top++;
	}

	@Override
	public boolean isFull() {
		return super.isFull();
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
