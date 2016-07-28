/**
 * 
 */
package com.home.amit.ds;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/**
 * @author amit
 * 
 */
public class ListArrayImpl<E> implements IList<E>, RandomAccess, Serializable {

	/**
	 * The Serial vesion UID
	 */
	private static final long serialVersionUID = -3763495195581696780L;

	/**
	 * The container for list elements.
	 */
	private Object[] elements;

	/**
	 * The number of elements in the list.
	 */
	private int size;

	/**
	 * The max capacity of the list.
	 */
	private final int capacity;

	/**
	 * Keeps modification count to the list
	 */
	private transient int modCount = 0;

	/**
	 * The default capacity if capacity is not provided in constructor.
	 */
	private static final int DEFAULT_INITIAL_CAPACITY = 10;

	/**
	 * Class implementing iterator for this array based list.
	 * 
	 * @author amit
	 * 
	 * @param <E>
	 */
	private class ListIter implements Iterator<E> {
		int cursor;
		int lastPos = -1;
		int expectedModCount = modCount;

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			checkForConModification();
			int i = cursor;
			if (i >= size) {
				throw new NoSuchElementException();
			}
			Object[] arr = ListArrayImpl.this.elements;
			if (i >= arr.length) {
				throw new ConcurrentModificationException();
			}
			cursor = i + 1;
			return (E) arr[lastPos = i];
		}

		@Override
		public void remove() {
			if (lastPos < 0) {
				throw new IllegalStateException();
			}
			checkForConModification();
			try {
				ListArrayImpl.this.remove(lastPos);
				cursor = lastPos;
				lastPos = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException(e);
			}

		}

		private void checkForConModification() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}
		}
	}

	public ListArrayImpl() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public ListArrayImpl(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal List size: " + capacity);
		}

		elements = new Object[capacity];
		this.capacity = capacity;
	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param o
	 *            Object to be appended to the list.
	 * @return <tt>true</tt>
	 */
	@Override
	public boolean add(E o) {
		ensureCapacity(1);
		elements[size++] = o;
		modCount++;
		return true;
	}

	/**
	 * Appends the specified element at the given position in this list. All the
	 * elements will be right shifted by one place.
	 * 
	 * @param position
	 *            The position at which the new element will be inserted.
	 * @param o
	 *            Object to be appended to the list.
	 */
	@Override
	public void add(int position, E o) {
		rangeCheckForAdd(position);
		System.arraycopy(elements, position, elements, position + 1, size
				- position);
		elements[position] = o;
		modCount++;
		size++;
	}

	@Override
	public boolean addAll(IList<E> aList) {
		return addAll(this.size, aList);
	}

	@Override
	public boolean addAll(int index, IList<E> aList) {
		if (null != aList && aList.size() > 0) {
			rangeCheckForAdd(index);
			int numElem = aList.size();
			int movedElem = size - index;
			ensureCapacity(numElem);
			if (index != size) {
				System.arraycopy(elements, index, elements, (index + numElem),
						movedElem);
			}
			System.arraycopy(aList, 0, elements, index, numElem);
			size += numElem;
			return true;
		}
		return false;
	}

	/**
	 * Clears the list. The list will be empty after this call returns.
	 */
	@Override
	public void clear() {
		for (int index = 0; index < size; index++) {
			elements[index] = null;
		}

		size = 0;
		modCount++;
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element. More
	 * formally, returns <tt>true</tt> if and only if this list contains at
	 * least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 * 
	 * @param o
	 *            element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	@Override
	public boolean contains(Object o) {
		return indexOf(0) >= 0;
	}

	/**
	 * Returns the element at given position.
	 * 
	 * @param position
	 *            The position in the list.
	 * 
	 * @return the element at the position.
	 */
	@Override
	public E get(int position) {
		rangeCheck(position);
		return getElement(position);
	}

	/**
	 * Returns the index of o in list if found, -1 otherwise.
	 * 
	 * @param o
	 *            the element to be searched.
	 * 
	 * @return Returns the index of the first occurrence of the specified
	 *         element in this list, or -1 if this list does not contain the
	 *         element. More formally, returns the lowest index <tt>i</tt> such
	 *         that
	 *         <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
	 *         , or -1 if there is no such index.
	 * 
	 */
	@Override
	public int indexOf(Object o) {
		if (null == o) {
			for (int index = 0; index < size(); index++) {
				if (elements[index] == null) {
					return index;
				}
			}
		} else {
			for (int index = 0; index < size(); index++) {
				if (elements[index].equals(o)) {
					return index;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns <tt>true</tt> if the list is full.
	 * 
	 * @return <tt>true</tt> if the list is full.
	 */
	public boolean isFull() {
		return size == capacity;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIter();
	}

	@Override
	public int lastIndexOf(Object o) {
		if (null == o) {
			for (int index = size - 1; index >= 0; index--) {
				if (elements[index] == null) {
					return index;
				}
			}
		} else {
			for (int index = size - 1; index >= 0; index--) {
				if (elements[index].equals(o)) {
					return index;
				}
			}
		}
		return -1;
	}

	/**
	 * Removes the element at position and right shifts all the elements at
	 * right, if any.
	 * 
	 * @param position
	 *            The position in the list from where the elements to be
	 *            removed.
	 * @return element at position being removed.
	 * @throws IndexOutOfBoundsException
	 *             if position out of range.
	 */
	@Override
	public E remove(int position) {
		rangeCheck(position);
		E element = getElement(position);
		fastRemove(position);
		return element;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present. If the list does not contain the element, it is unchanged.
	 * 
	 * @param o
	 *            Element to be removed.
	 * @return <tt>true</tt> if o found in list, <tt>false</tt> otherwise.
	 */
	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index >= 0) {
			fastRemove(index);
			return true;
		}
		return false;
	}

	@Override
	public E set(int position, E o) {
		rangeCheck(position);
		E oldVal = getElement(position);
		elements[position] = o;
		return oldVal;
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list.
	 */
	@Override
	public int size() {
		return size;
	}

	@Override
	public IList<E> subList(int start, int end) {
		subListRangeCheck(start, end);
		IList<E> subList = new ListArrayImpl<E>(end - start + 1);
		for (int i = start; i <= end; i++) {
			subList.add(getElement(i));
		}
		return subList;
	}

	private void ensureCapacity(int numElements) {
		if (isFull() || (size + numElements) > capacity) {
			throw new IllegalArgumentException("The list can't accomodate "
					+ numElements + " new element(s). Current Size: " + size);
		}
	}

	/*
	 * Private remove method that skips bounds checking and does not return the
	 * value removed.
	 */
	private void fastRemove(int index) {
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		elements[--size] = null;
		modCount++;
	}

	/**
	 * Constructs an IndexOutOfBoundsException detail message. Of the many
	 * possible refactorings of the error handling code, this "outlining"
	 * performs best with both server and client VMs.
	 * 
	 * @param index
	 *            The index to be printed,
	 * @return message for IndexOutOfBoundsException
	 */
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	private void rangeCheck(int position) {
		if (position >= size) {
			throw new IndexOutOfBoundsException("Index: " + position
					+ ", Size: " + size);
		}

	}

	/**
	 * A version of rangeCheck used by add and addAll.
	 */
	private void rangeCheckForAdd(int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private void subListRangeCheck(int start, int end) {
		if (!(end >= start && start >= 0 && end < size)) {
			throw new IndexOutOfBoundsException(
					"Illegal index for subList - Start: " + start + " End: "
							+ end);
		}
	}

	// Positional Access Operations
	@SuppressWarnings("unchecked")
	E getElement(int index) {
		return (E) elements[index];
	}
}
