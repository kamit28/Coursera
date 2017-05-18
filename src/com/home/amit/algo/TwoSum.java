/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Amit
 *
 */
public class TwoSum {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		ArrayList<Long> array = readNumbersArrayFromFile();
		Set<Long> set = new HashSet<Long>(array);

		int counter = 0;
		for (int i = -10000; i <= 10000; i++) {
			for (long j : array) {
				if (set.contains(j) && set.contains(i - j)) {
					counter++;
					break;
				}
			}
		}
		System.out.println("*** COUNTER => " + counter + " ***");
	}

	private static ArrayList<Long> readNumbersArrayFromFile() {
		ArrayList<Long> longArray = new ArrayList<Long>();
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(
					"/Users/Anshu/Downloads/algo1_programming_prob_2sum.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				longArray.add(Long.valueOf(line));
			}
			br.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(TwoSum.class.getName())
					.log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(TwoSum.class.getName())
					.log(Level.SEVERE, null, ex);
		} finally {
			try {
				fstream.close();
			} catch (IOException ex) {
				Logger.getLogger(TwoSum.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return longArray;
	}
}
