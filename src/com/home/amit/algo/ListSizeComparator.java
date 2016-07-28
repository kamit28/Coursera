/**
 * 
 */
package com.home.amit.algo;

import java.util.Comparator;
import java.util.List;

/**
 * @author Anshu
 *
 */
public class ListSizeComparator implements Comparator<List<Integer>> {

	@Override
	public int compare(List<Integer> o1, List<Integer> o2) {
		if (o1 == null)
			return -1;
		if (o2 == null)
			return 1;

		return o1.size() == o2.size() ? 0 : (o1.size() > o2.size() ? 1 : -1);
	}

}
