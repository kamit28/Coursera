package com.home.amit.algo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalinCheck {
	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.next();
		String ans = "NO";
		ans = canHavePalindrome(inputString.trim()) ? "YES" : "NO";
		System.out.println(ans);
		myScan.close();
	}

	private static boolean canHavePalindrome(String str) {
		char c;
		Set<Character> chars = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (chars.contains(c)) {
				chars.remove(c);
			} else {
				chars.add(c);
			}
		}
		if (chars.size() > 1) {
			return false;
		}
		return true;
	}
}
