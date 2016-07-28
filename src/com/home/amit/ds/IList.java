/**
 * 
 */
package com.home.amit.ds;

/**
 * Generic iterable List interface
 * 
 * @author amit
 * 
 */
public interface IList<E> extends Iterable<E> {

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param o
	 *            Object to be appended to the list.
	 * @return <tt>true</tt>
	 */
	public boolean add(E o);

	/**
	 * 
	 * @param pos
	 * @param o
	 */
	public void add(int pos, E o);

	public boolean addAll(IList<E> aList);

	/**
	 * @param index
	 * @param aList
	 */
	public boolean addAll(int index, IList<E> aList);

	/**
	 * Clears the list. The list will be empty after this call returns.
	 */
	public void clear();

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
	public boolean contains(Object o);

	public boolean equals(Object o);

	/**
	 * Returns the element at given position.
	 * 
	 * @param position
	 *            The position in the list.
	 * 
	 * @return the element at the position.
	 */
	public E get(int position);

	public int hashCode();

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
	public int indexOf(Object o);

	/**
	 * Returns <tt>true</tt> if the list has zero elements.
	 * 
	 * @return <tt>true</tt> if the list has zero elements.
	 */
	public boolean isEmpty();

	public java.util.Iterator<E> iterator();

	public int lastIndexOf(Object o);

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
	public E remove(int position);

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present. If the list does not contain the element, it is unchanged.
	 * 
	 * @param o
	 *            Element to be removed.
	 * @return <tt>true</tt> if o found in list, <tt>false</tt> otherwise.
	 */
	public boolean remove(Object o);

	public E set(int position, E o);

	/**
	 * Returns size of the list.
	 * 
	 * @return The size of the list.
	 */
	public int size();

	public IList<E> subList(int start, int end);

}
