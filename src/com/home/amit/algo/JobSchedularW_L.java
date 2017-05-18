/**
 * 
 */
package com.home.amit.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Amit
 *
 */
public class JobSchedularW_L {

	/**
	 * 
	 */
	public JobSchedularW_L() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("/Users/Anshu/Downloads/jobstest2.txt"));
		int totalJobs = in.nextInt();
		Job jobArr[] = new Job[totalJobs];
		for (int i = 0; i < totalJobs; i++) {
			jobArr[i] = new Job(in.nextInt(), in.nextInt());
		}
		in.close();
		Arrays.sort(jobArr, new WeightLengthDistanceComparator());
		long sumCompletion = 0;
		long score = 0;
		for (Job job : jobArr) {
			sumCompletion += job.getLength();
			score += (job.getWeight() * sumCompletion);
		}
		System.out.println(score);

		Arrays.sort(jobArr, new WeightLengthRatioComparator());
		sumCompletion = 0;
		score = 0;
		for (Job job : jobArr) {
			sumCompletion += job.getLength();
			score += (job.getWeight() * sumCompletion);
		}
		System.out.println(score);
	}
}

class Job { // implements Comparable<Job> {
	private int weight;
	private int length;

	Job() {
	}

	Job(int weight, int length) {
		this.weight = weight;
		this.length = length;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/*
	 * @Override public int compareTo(Job other) { if ((this.weight -
	 * this.length) < (other.getWeight() - other .getLength())) { return 1; }
	 * else if ((this.weight - this.length) == (other.getWeight() - other
	 * .getLength())) { if (this.weight < other.getWeight()) { return 1; } else
	 * if (this.weight == other.getWeight()) { return 0; } else return -1; }
	 * else return -1; }
	 */
}

class WeightLengthRatioComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		double ratio1 = o1.getLength() == 0 ? o1.getWeight() : ((double) o1
				.getWeight() / (double) o1.getLength());
		double ratio2 = o2.getLength() == 0 ? o2.getWeight() : ((double) o2
				.getWeight() / (double) o2.getLength());
		if (ratio1 < ratio2) {
			return 1;
		} else if (ratio1 == ratio2) {
			if (o1.getWeight() < o2.getWeight()) {
				return 1;
			} else if (o1.getWeight() == o2.getWeight()) {
				return 0;
			} else
				return -1;
		} else
			return -1;
	}
}

class WeightLengthDistanceComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		if ((o1.getWeight() - o1.getLength()) < (o2.getWeight() - o2
				.getLength())) {
			return 1;
		} else if ((o1.getWeight() - o1.getLength()) == (o2.getWeight() - o2
				.getLength())) {
			if (o1.getWeight() < o2.getWeight()) {
				return 1;
			} else if (o1.getWeight() == o2.getWeight()) {
				return 0;
			} else
				return -1;
		} else
			return -1;
	}
}
