/**
 * 
 */
package com.home.amit.algo;

/**
 * @author Anshu
 *
 */
public class GCD_Euclid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 32, b = 56;

		int x = a;
		int y = b;
		while (!(x == 0 || y == 0)) {
			if (x >= y) {
				x = x - y;
			} else {
				y = y - x;
			}
		}
		System.out.println("GCD [" + a + ", " + b + "] is: "
				+ ((x == 0) ? y : x));

		// Method 2
		x = a;
		y = b;
		while (!(x == 0 || y == 0)) {
			if (x >= y) {
				x %= y;
			} else {
				y %= x;
			}
		}
		System.out.println("GCD [" + a + ", " + b + "] is: "
				+ ((x == 0) ? y : x));
	}

}
