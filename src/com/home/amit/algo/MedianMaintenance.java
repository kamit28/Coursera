/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

import com.home.amit.ds.MaxHeap;
import com.home.amit.ds.MinHeap;

/**
 * @author Anshu
 *
 */
public class MedianMaintenance {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		MinHeap minHeap = new MinHeap(10001);
		MaxHeap maxHeap = new MaxHeap(10001);

		String sCurrentLine;
		long sum = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					"/Users/Anshu/Downloads/Median.txt")));
			maxHeap.insert(1);
			minHeap.insert(20000);
			while ((sCurrentLine = br.readLine()) != null) {
				int val = Integer.parseInt(sCurrentLine.trim());
				if (val < maxHeap.peek()) {
					maxHeap.insert(val);
				} else {
					minHeap.insert(val);
				}
				if (minHeap.getSize() - maxHeap.getSize() > 1) {
					maxHeap.insert(minHeap.extractMin());
				}
				if (maxHeap.getSize() - minHeap.getSize() > 1) {
					minHeap.insert(maxHeap.extractMax());
				}
				sum += maxHeap.peek();
			}
			System.out.println(sum % 10000);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
	}
}
