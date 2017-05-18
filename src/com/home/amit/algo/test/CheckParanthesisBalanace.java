/**
 * 
 */
package com.home.amit.algo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Amit
 *
 */
public class CheckParanthesisBalanace {

	public static void main(String[] argh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Stack<Character> parenStack = new Stack<Character>();
		Deque<Character> parenStack = new ArrayDeque<Character>();
		char val;
		char val1;
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			parenStack.push(input.charAt(i));
		}
		// Stack<Character> tempStack = new Stack<Character>();
		Deque<Character> tempStack = new ArrayDeque<Character>();
		while (!parenStack.isEmpty()) {
			val = parenStack.pop();
			if (!parenStack.isEmpty()) {
				val1 = parenStack.peek();
				if ((val == ')' && val1 == '(') || (val == '}' && val1 == '{')
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
		System.out.println(tempStack.isEmpty() ? "True" : "False");
	}
}
