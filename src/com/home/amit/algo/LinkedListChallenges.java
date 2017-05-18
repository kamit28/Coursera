/**
 * 
 */
package com.home.amit.algo;

/**
 * @author Amit
 *
 */
public class LinkedListChallenges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node();
		head.data = 1;
		head.next = null;

		int data = getNode2(head, 0);
		System.out.println(data);
	}

	static int getNode(Node head, int n) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		Node end = head;
		Node prev = head;
		if (head.next == null && n == 0)
			return head.data;

		while (end.next != null)
			end = end.next;

		for (int count = 0; count < n; count++) {
			prev = head;
			while (prev.next != end)
				prev = prev.next;
			end = prev;
		}

		return prev.data;
	}

	static int getNode2(Node head, int n) {
		Node curr = head;
		int size = 0;
		if (head.next == null && n == 0)
			return head.data;

		while (curr != null) {
			curr = curr.next;
			size++;
		}
		curr = head;
		for (int count = 0; size - count == n; count++, curr = curr.next)
			;

		return curr.data;

	}

}

class Node {
	int data;
	Node next;
}
