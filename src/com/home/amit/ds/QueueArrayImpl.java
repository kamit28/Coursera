/**
 * 
 */
package com.home.amit.ds;

/**
 * @author Anshu
 *
 */
public class QueueArrayImpl<E> implements IQueue<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1811933281468880382L;

	private int front;
	private int rear;
	private int capacity;
	private Object[] elements;

	/**
	 * 
	 */
	public QueueArrayImpl() {
		this(10);
	}

	/**
	 * @param capacity
	 */
	public QueueArrayImpl(int capacity) {
		elements = new Object[capacity];
		front = rear = -1;
		this.capacity = capacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IQueue#dequeue()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E dequeue() {
		Object value = elements[front];
		elements[front] = null;
		if (front + 1 == rear) {
			front = rear = -1;
		} else {
			front++;
		}
		return (E) value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IQueue#peek()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		return (E) elements[front];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IQueue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(E element) {
		if (isEmpty()) {
			front = rear = 0;
		} else {
			++rear;
		}
		elements[rear] = element;
	}

	@Override
	public boolean isFull() {
		return size() == capacity;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		if(rear == -1) {
			return 0;
		}
		return rear - front + 1;
	}
}
