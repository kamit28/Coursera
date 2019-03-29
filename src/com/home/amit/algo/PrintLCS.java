package com.home.amit.algo;

import java.util.Arrays;

public class PrintLCS {
	public static char[] find(char[] a, char[] b) {
		int[][] LCS = new int[a.length + 1][b.length + 1];

		for (int i = 0; i <= a.length; i++) {
			for (int j = 0; j <= b.length; j++) {
				if (i == 0 || j == 0)
					LCS[i][j] = 0;
				else if (a[i - 1] == b[j - 1])
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
			}
		}

		int index = LCS[a.length][b.length];

		int temp = index;
		char[] result = new char[index + 1];

		for (int i = a.length, j = b.length; i > 0 && j > 0;) {
			if (a[i - 1] == b[j - 1]) {
				result[index - 1] = a[i - 1];
				i--;
				j--;
				index--;
			} else if (LCS[i - 1][j] > LCS[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		return Arrays.copyOfRange(result, 0, temp);
	}

	public static void main(String[] args) {

		//String A = "tutorialhorizon";
		//String B = "dynamictutorialProgramming";

		 String A = "amit";
		 String B = "sumity";
		System.out.println("LCS : " + new String(find(A.toCharArray(), B.toCharArray())));
	}
}
