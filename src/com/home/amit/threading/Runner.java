/**
 * 
 */
package com.home.amit.threading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Amit
 *
 */
public class Runner {

	private int count = 0;

	private Lock lock = new ReentrantLock();

	private Condition cond = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++)
			count++;
	}

	public void firstThread() throws InterruptedException {
		lock.lock();

		System.out.println("Waiting.....");
		cond.await();
		System.out.println("Done waiting.....");

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Press the return key!");
		Scanner in = new Scanner(System.in);
		in.nextLine();
		in.close();
		cond.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}

}
