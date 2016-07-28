/**
 * 
 */
package com.home.amit.algo.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Anshu
 *
 */

public class CheckParanthesisBalanace {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> parenStack = new Stack<Character>();
		char val;
		char val1;
		while (sc.hasNext()) {
			String input = sc.next();
			for (int i = 0; i < input.length(); i++) {
				val = input.charAt(i);
				parenStack.push(val);
			}
			Stack<Character> tempStack = new Stack<Character>();
			while (!parenStack.isEmpty()) {
				val = parenStack.pop();
				if (!parenStack.isEmpty()) {
					val1 = parenStack.peek();
					if ((val == ')' && val1 == '(')
							|| (val == '}' && val1 == '{')
							|| (val == ']' && val1 == '[')) {
						parenStack.pop();
						while (!tempStack.isEmpty()) {
							parenStack.push(tempStack.pop());
						}
					} else
						tempStack.push(val);
				} else {
					tempStack.push(val);
				}
			}
			System.out.println(tempStack.isEmpty());
		}
		sc.close();
	}
}
