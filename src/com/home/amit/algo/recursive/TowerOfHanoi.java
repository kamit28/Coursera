/**
 * 
 */
package com.home.amit.algo.recursive;


/**
 * @author amit
 * 
 */
public class TowerOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
		towerOfHanoi.init();

	}

	public void init() {
		int[] start = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41};
		int[] temp = new int[21];
		int[] goal = new int[21];
		
		for (Integer num : start) {
			System.out.println(num);
		}

		TOH(start.length - 1, start, temp, goal);

		for (Integer num : goal) {
			System.out.println(num);
		}
	}

	private void TOH(int size, int[] start, int[] temp,
			int[] goal) {
		if (size >= 0) {
			TOH(size - 1, start, temp, goal);
			move(start, goal, size);
			TOH(size - 1, temp, goal, start);
		}
	}

	private void move(int[] start, int[] goal, int size) {
		goal[size] = start[size];
		//start[size] = 0;
	}
}
