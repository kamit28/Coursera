/**
 * 
 */
package com.home.amit.ds;

import java.util.Iterator;

/**
 * @author amit
 * 
 */
public class ListLinkImpl<E> implements IList<E> {

	private Node<E> head;

	private int size;

	public ListLinkImpl() {
		head = null;
		size = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#add(java.lang.Object)
	 */
	@Override
	public boolean add(E o) {
		Node<E> node = new Node<E>(o, null, null);
		if (!isEmpty()) {
			node.setNext(head);
		}
		head = node;
		size++;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int pos, E o) {
		rangeCheck(pos);
		Node<E> newNode = new Node<E>(o, null, null);
		Node<E> tempNode = head;
		Node<E> prevNode = null;
		int index = 0;
		while (index < pos) {
			prevNode = tempNode;
			tempNode = tempNode.getNext();
			++index;
		}
		newNode.setNext(tempNode);
		prevNode.setNext(newNode);
		++size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#addAll(com.home.amit.ds.IList)
	 */
	@Override
	public boolean addAll(IList<E> aList) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#addAll(int, com.home.amit.ds.IList)
	 */
	@Override
	public boolean addAll(int index, IList<E> aList) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#clear()
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		Node<E> start = head;
		if (o == null) {
			while (start != null) {
				if (null == start.getData()) {
					return true;
				}
				start = start.getNext();
			}
		} else {
			while (start != null) {
				if (o.equals(start.getData())) {
					return true;
				}
				start = start.getNext();
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#get(int)
	 */
	@Override
	public E get(int position) {
		rangeCheck(position);
		return getElement(position);
	}

	private E getElement(int position) {
		Node<E> temp = head;
		int index = 0;
		if (null != temp) {
			while (index < position) {
				temp = temp.getNext();
				++index;
			}
			return temp.getData();
		} else {
			throw new IndexOutOfBoundsException("List is empty!");
		}
	}

	private void rangeCheck(int position) {
		if (position < 0 || position >= size) {
			throw new IndexOutOfBoundsException("Invalid index in list: "
					+ position + ", Current size: " + size);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object o) {
		Node<E> start = head;
		int index = 0;
		if (o == null) {
			while (start != null) {
				if (null == start.getData()) {
					return index;
				}
				++index;
				start = start.getNext();
			}
		} else {
			while (start != null) {
				if (o.equals(head.getData())) {
					return index;
				}
				++index;
				start = start.getNext();
			}
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return null == head;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#lastIndexOf(java.lang.Object)
	 */
	@Override
	public int lastIndexOf(Object o) {
		Node<E> start = head;
		int index = 0;
		int position = -1;
		if (o == null) {
			while (start != null) {
				if (null == start.getData()) {
					position = index;
				}
				++index;
				start = start.getNext();
			}
		} else {
			while (start != null) {
				if (o.equals(head.getData())) {
					position = index;
				}
				++index;
				start = start.getNext();
			}
		}
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#remove(int)
	 */
	@Override
	public E remove(int position) {
		rangeCheck(position);
		E tempData;
		Node<E> tempNode = head;
		Node<E> prevNode = null;
		if (position == 0) {
			tempData = head.getData();
			head = head.getNext();
		} else {
			int index = 0;
			while (index < position) {
				prevNode = tempNode;
				tempNode = tempNode.getNext();
				++index;
			}
			tempData = tempNode.getData();
			prevNode.setNext(tempNode.getNext());
			tempNode = null;
		}
		--size;
		return tempData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		Node<E> start = null;
		Node<E> prevHolder = null;
		if (o == null) {
			if (head.getData() == null) {
				prevHolder = head;
				head = head.getNext();
				prevHolder = null;
				size--;
				return true;
			} else {
				start = head.getNext();
				prevHolder = head;
				while (start != null) {
					if (start.getData() == null) {
						prevHolder.setNext(start.getNext());
						start = null;
						size--;
						return true;
					}
					prevHolder = start;
					start = start.getNext();
				}
			}
		} else {
			if (o.equals(head.getData())) {
				prevHolder = head;
				head = head.getNext();
				prevHolder = null;
				size--;
				return true;
			} else {
				start = head.getNext();
				prevHolder = head;
				while (start != null) {
					if (o.equals(head.getData())) {
						prevHolder.setNext(start.getNext());
						start = null;
						size--;
						return true;
					}
					prevHolder = start;
					start = start.getNext();
				}
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#set(int, java.lang.Object)
	 */
	@Override
	public E set(int position, E o) {
		rangeCheck(position);
		E tempData;
		Node<E> tempNode = head;
		int index = 0;
		while (index < position) {
			tempNode = tempNode.getNext();
			++index;
		}
		tempData = tempNode.getData();
		tempNode.setData(o);
		return tempData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.home.amit.ds.IList#subList(int, int)
	 */
	@Override
	public IList<E> subList(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
}
