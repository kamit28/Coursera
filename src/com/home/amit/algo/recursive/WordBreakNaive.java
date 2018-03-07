package com.home.amit.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Program to break a large word into a sentence based on input dictionary - Naive approach
public class WordBreakNaive {

	public void wordBreak(String s, Set<String> hs) {
		if (find(s, hs, "")) {
		} else {
			System.out.println("Cant Break");
		}
	}

	public boolean find(String s, Set<String> dict, String answer) {
		// System.out.println(s + " " + answer);
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else {
			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);// add one char at a time
				// check if word exists in dictionary
				if (dict.contains(word)) {
					// add word to the answer and make a recursive call
					if (find(s.substring(index + 1), dict, answer + word + " ")) {
						return true;
					} else {
						// System.out.println(word + " backtrack");
						index++;
					}
				} else {
					index++;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.addAll(Arrays.asList(new String[] { "my", "amit", "kumar", "i", "a", "am", "is" }));
		String str = "iamamit";
		WordBreakNaive wb = new WordBreakNaive();
		wb.wordBreak(str, dict);
	}

}
