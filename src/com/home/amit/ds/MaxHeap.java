/**
 * 
 */
package com.home.amit.ds;

/**
 * @author Amit
 *
 */
public class MaxHeap {

	private int[] heap;

	/**
	 * @param heap
	 * @param size
	 */
	public MaxHeap(int size) {
		this.heap = new int[size];
		this.size = 0;
	}

	private int size;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(10);
		int[] arr = { 6, 4, 2, 1, 7, 8, 5, 9, 0, 3 };
		for (int i = 0; i < 10; i++) {
			maxHeap.insert(arr[i]);
		}

		while (maxHeap.getSize() > 0) {
			System.out.println(maxHeap.extractMax());
		}
	}

	/**
	 * @return the heap
	 */
	public int[] getHeap() {
		return heap;
	}

	/**
	 * @param heap
	 *            the heap to set
	 */
	public void setHeap(int[] heap) {
		this.heap = heap;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public void insert(int data) {
		heap[size] = data;
		int currPos = size;
		while (data > heap[currPos / 2] && currPos >= 0) {
			swap(currPos, currPos / 2);
			currPos /= 2;
		}
		size++;
	}

	public int extractMax() {
		int val = heap[0];
		heap[0] = heap[size - 1];
		size--;
		int left, right;
		for (int i = 0; (2 * (i + 1)) < size && heap[i] < heap[2 * (i + 1)];) {
			left = 2 * (i + 1) - 1;
			right = 2 * (i + 1);
			if (heap[left] < heap[right]) {
				swap(i, right);
				i = right;
			} else {
				swap(i, left);
				i = left;
			}
		}
		return val;
	}

	private void swap(int currPos, int i) {
		int temp = heap[currPos];
		heap[currPos] = heap[i];
		heap[i] = temp;
	}

	public int peek() {
		return heap[0];
	}

}
