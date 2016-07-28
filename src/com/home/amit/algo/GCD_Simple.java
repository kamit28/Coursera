/**
 * 
 */
package com.home.amit.algo;

/**
 * @author Anshu
 *
 */
public class GCD_Simple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a = 32;
		double b = 56;
		double dividend = 0;
		double divisor = 0;
		double gcd = 0;

		if (a < b) {
			divisor = a;
			dividend = b;
		} else {
			divisor = b;
			dividend = a;
		}
		do {
			gcd = dividend % divisor;
			dividend = divisor;
			divisor = gcd;
		} while (gcd > 0);

		System.out.println("GCD [" + a + ", " + b + "] is: " + dividend);
	}

}
