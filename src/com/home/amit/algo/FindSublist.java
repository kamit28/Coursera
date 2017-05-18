package com.home.amit.algo;

import java.io.IOException;
import java.util.Scanner;

public class FindSublist {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int res;

		int _list_size = Integer.parseInt(in.nextLine()), _list_i;
		String _list_item;
		LinkedListNode _list = null;
		for (_list_i = 0; _list_i < _list_size; _list_i++) {
			try {
				_list_item = in.nextLine();
			} catch (Exception e) {
				_list_item = null;
			}
			_list = _insert_node_into_singlylinkedlist(_list, _list_item);
		}

		int _sublist_size = Integer.parseInt(in.nextLine()), _sublist_i;
		String _sublist_item;
		LinkedListNode _sublist = null;
		for (_sublist_i = 0; _sublist_i < _sublist_size; _sublist_i++) {
			try {
				_sublist_item = in.nextLine();
			} catch (Exception e) {
				_sublist_item = null;
			}
			_sublist = _insert_node_into_singlylinkedlist(_sublist,
					_sublist_item);
		}
		in.close();

		res = find(_list, _sublist);
		System.out.println(res);
	}

	public static class LinkedListNode {
		String val;
		LinkedListNode next;

		LinkedListNode(String node_value) {
			val = node_value;
			next = null;
		}
	};

	public static LinkedListNode _insert_node_into_singlylinkedlist(
			LinkedListNode head, String val) {
		if (head == null) {
			head = new LinkedListNode(val);
		} else {
			LinkedListNode end = head;
			while (end.next != null) {
				end = end.next;
			}
			LinkedListNode node = new LinkedListNode(val);
			end.next = node;
		}
		return head;
	}

	static int find(LinkedListNode list, LinkedListNode sublist) {
    	if (list == null || sublist == null) {
			return -1;
		}
		
		LinkedListNode ptrList = list;
		LinkedListNode ptrSub = sublist;
		
		int pos = 0;
		int numMatched = 0;
		while(ptrList!= null && ptrSub != null) {
			while(ptrList!= null && !ptrList.val.equals(ptrSub.val)) {
				pos++;
				ptrList = ptrList.next;
			}
			while(ptrList!= null && ptrSub != null && ptrList.val.equals(ptrSub.val)) {
				ptrList = ptrList.next;
				ptrSub = ptrSub.next;
				numMatched++;
			}
			if(ptrSub == null) {
				return pos;
			} else if(ptrList != null) {
				ptrSub = sublist;
				pos += numMatched;
			} else {
				return -1;
			}
		}
		return -1;
    }
}

class LinkedListNode {
	String val;
	LinkedListNode next;
};
