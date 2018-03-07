package com.home.amit.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Program to break a large word into a sentence based on input dictionary
// This is an improvement on the naive approach using DP to reduce
// the number of subproblems by memoisation
public class WordBreakDP {

	public void wordBreak(String s, Set<String> dict, Set<String> memo) {
		if (find(s, dict, memo, "")) {
		} else {
			System.out.println("Cant Break");
		}
	}

	public boolean find(String s, Set<String> dict, Set<String> memo, String answer) {
		// System.out.println(s + " " + answer);
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else if (memo.contains(s)) {
			return false;
		} else {
			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);// add one char at a time
				// check if word exists in dictionary
				if (dict.contains(word)) {
					// add word to the answer and make a recursive call
					if (find(s.substring(index + 1), dict, memo, answer + word + " ")) {
						return true;
					} else {
						index++;
					}
				} else {
					index++;
				}
			}
			memo.add(s);
			return false;
		}
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		Set<String> memo = new HashSet<>();
		dict.addAll(Arrays.asList(new String[] { "my", "amit", "kumar", "i", "a", "am", "is" }));
		String str = "iamamit";
		WordBreakDP wb = new WordBreakDP();
		wb.wordBreak(str, dict, memo);
	}

}
