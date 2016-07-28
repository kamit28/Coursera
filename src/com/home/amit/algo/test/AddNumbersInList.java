/**
 * 
 */
package com.home.amit.algo.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Anshu
 *
 */
public class AddNumbersInList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> number1 = new LinkedList<Integer>();
		number1.add(1);
		number1.add(8);
		number1.add(6);
		number1.add(9);
		List<Integer> number2 = new LinkedList<Integer>();
		number2.add(7);
		number2.add(4);
		number2.add(8);
		//number2.add(8);
		
		Iterator<Integer> iter1 = number1.iterator();
		while (iter1.hasNext()) {
			System.out.print(iter1.next() + "\t");
		}
		System.out.println();
		Iterator<Integer> iter2 = number2.iterator();
		while (iter2.hasNext()) {
			System.out.print(iter2.next() + "\t");
		}
		System.out.println();

		iter1 = number1.iterator();
		iter2 = number2.iterator();

		List<Integer> number3 = new LinkedList<Integer>();
		int rem = 0;
		int num = 0;
		while (iter1.hasNext() && iter2.hasNext()) {
			num = iter1.next() + iter2.next() + rem;
			number3.add(num > 9 ? num - 10 : num);
			rem = num > 9 ? 1 : 0;
		}
		while (iter1.hasNext()) {
			num = iter1.next() + rem;
			number3.add(num > 9 ? num - 10 : num);
			rem = num > 9 ? 1 : 0;
		}

		while (iter2.hasNext()) {
			num = iter2.next() + rem;
			number3.add(num > 9 ? num - 10 : num);
			rem = num > 9 ? 1 : 0;
		}

		if (rem == 1) {
			number3.add(1);
		}

		Iterator<Integer> iter3 = number3.iterator();
		while (iter3.hasNext()) {
			System.out.print(iter3.next() + "\t");
		}
		System.out.println();
	}
}
