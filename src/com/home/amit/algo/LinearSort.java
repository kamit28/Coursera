/**
 * Algorithm - Linear (Histogram) sort
 */
package com.home.amit.algo;

import java.util.Arrays;
import java.util.Random;

/**
 * @author amit
 * 
 */
public class LinearSort {
	// class LinearSort
	public static void main(String[] args) {

		// init jvm
		new LinearSort().start(1000, 10000, 10000);
		new LinearSort().start(1000, 10000, 10000);

		// run performance comparison
		for (int maxInteger = 1000; maxInteger < 100000000; maxInteger *= 3) {
			for (int arrLength = 1000; arrLength < 100000000; arrLength *= 3) {
				System.gc();
				new LinearSort().start(arrLength, maxInteger, 10);
			}
		}
	}

	private Random rand = new Random();

	// stop watch for integer sort with *unknown* range. marked as Lin in the
	// plot
	private SimpleTimer linearStopWatch = new SimpleTimer();

	// stop watch for integer sort with known range. marked as Lin' in the plot
	private SimpleTimer linearKnownStopWatch = new SimpleTimer();

	private SimpleTimer qSortStopWatch = new SimpleTimer();

	private void start(int arrLength, int maxInteger, int times) {
		for (int count = 0; count < times; count++) {
			int[] list1 = new int[arrLength];
			for (int i = 0; i < arrLength; i++) {
				// do only allow positive integers until the specified
				// 'max'-value
				list1[i] = Math.abs(rand.nextInt(maxInteger));
			}
			linearStopWatch.start();
			LinearSort.sort(list1);
			linearStopWatch.pause();

			int[] list2 = Arrays.copyOf(list1, arrLength);
			qSortStopWatch.start();
			Arrays.sort(list2);
			qSortStopWatch.pause();

			list2 = Arrays.copyOf(list1, arrLength);
			linearKnownStopWatch.start();
			LinearSort.sort(list2, 0, maxInteger);
			linearKnownStopWatch.pause();
		}

		System.out.println(maxInteger + ";" + arrLength + ";" + linearStopWatch
				+ ";" + linearKnownStopWatch + ";" + qSortStopWatch); // + ";" +
		// qSortListStopWatch);
	}

	static int[] sort(int[] array, int min, int max) {
		// the range is useful to minmize the memory usage
		// countIntegers holds the number of each integer
		int[] countIntegers = new int[max - min + 1];

		for (int i = 0; i < array.length; i++) {
			countIntegers[array[i] - min]++;
		}

		int insertPosition = 0;
		// fill array in sorted order
		for (int i = min; i <= max; i++) {
			for (int j = 0; j < countIntegers[i - min]; j++) {
				array[insertPosition++] = i;
			}
		}
		return array;
	}

	static int[] sort(int[] array) {
		int min, max = min = array[0];
		// determine the max and min in the array
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];

			if (array[i] > max)
				max = array[i];
		}
		return sort(array, min, max);
	}

	// class SimpleTimer
	class SimpleTimer {
		private long lastStart = -1;
		private long time;

		public void start() {
			if (lastStart != -1)
				throw new IllegalStateException("Call stop before!");

			lastStart = System.currentTimeMillis();
		}

		public void pause() {
			if (lastStart < 0)
				throw new IllegalStateException("Call start before!");

			time = time + (System.currentTimeMillis() - lastStart);
			lastStart = -1;
		}

		public String toString() {
			return time / 1000f + "";
		}
	}
}
