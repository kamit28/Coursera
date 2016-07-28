/**
 * 
 */
package com.home.amit.threading;

/**
 * @author Anshu
 *
 */
public class Account {
	private double balance = 10000;

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	public double withdraw(double value) {
		balance -= value;
		return balance;
	}

	public void deposit(double value) {
		balance += value;
	}

	public static void transfer(Account acct1, Account acct2, double amount) {
		acct1.withdraw(amount);
		acct2.deposit(amount);
	}
}
