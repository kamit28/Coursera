/**
 * 
 */
package com.home.amit.algo;

/**
 * @author amit
 * 
 */
public class SubstringFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "this is the main string";
		String sub = "the";
		int pos = findSub(str, sub);
		System.out.println("String "
				+ (pos == -1 ? "not found." : "found at " + pos));

	}

	private static int findSub(String str, String sub) {
		if (str == null || sub == null) {
			return -1;
		}
		int srcLen = str.length();
		int substrLen = sub.length();

		if (srcLen < substrLen) {
			return -1;
		}

		if (srcLen == substrLen) {
			if (str.equals(sub)) {
				return 0;
			} else {
				return -1;
			}
		}
		int subPos = 0;
		int pos = -1;
		for (int i = 0; i < srcLen - substrLen && subPos < substrLen;) {
			if (str.charAt(i) != sub.charAt(subPos)) {
				subPos = 0;
				pos = -1;
				i++;
			} else {
				subPos++;
				pos = i;
				i++;
			}
		}
		return pos - substrLen + 1;
	}
}
