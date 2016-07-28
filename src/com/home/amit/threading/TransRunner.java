/**
 * 
 */
package com.home.amit.threading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Anshu
 *
 */
public class TransRunner {

	private Account acct1 = new Account();
	private Account acct2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void acquireLocks(Lock firstLock, Lock secondLock)
			throws InterruptedException {
		while (true) {
			boolean gotFirst = false;
			boolean gotSecond = false;

			try {
				gotFirst = firstLock.tryLock();
				gotSecond = secondLock.tryLock();
			} finally {
				if (gotFirst && gotSecond) {
					return;
				}
				if (gotFirst) {
					firstLock.unlock();
				}
				if (gotSecond) {
					secondLock.unlock();
				}
			}
			Thread.sleep(1);
		}
	}

	public void firstThread() throws InterruptedException {
		Random random = new Random();
		acquireLocks(lock1, lock2);

		try {
			Account.transfer(acct1, acct2, random.nextInt(100));
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		Random random = new Random();
		acquireLocks(lock2, lock1);

		try {
			Account.transfer(acct2, acct1, random.nextInt(100));
		} finally {
			lock1.unlock();
			lock2.unlock();
		}
	}

	public void finished() {
		System.out.println("Account1 balance is: " + acct1.getBalance());
		System.out.println("Account2 balance is: " + acct2.getBalance());
		System.out.println("Total balance is: "
				+ (acct1.getBalance() + acct2.getBalance()));
	}
}
