/**
 * 
 */
package com.home.amit.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * @author Anshu
 *
 */
public class CountInversions {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// int[] arr = { 8,7,6,5,4,3,2,1};
		int[] arr = new int[100000];
		String sCurrentLine;
		int i = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					"/Users/Anshu/Downloads/integerInversionCount")));
			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				arr[i++] = Integer.parseInt(sCurrentLine);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		long totalInversions = mergeSort(arr, 0, arr.length - 1);
		System.out.println(totalInversions);

		/*for (int val : arr) {
			System.out.print(val + "\t");
		}*/
		System.out.println();
	}

	public static long mergeSort(int[] arr, int low, int high) {
		int mid;
		long total = 0;

		if (high > low) {
			mid = (low + high) / 2;
			total += mergeSort(arr, low, mid);
			total += mergeSort(arr, (mid + 1), high);
			total += mergeLists(arr, low, high);
		}
		return total;
	}

	private static long mergeLists(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int l_low = low;
		int r_low = mid + 1;
		int index = 0;
		long total = 0;
		int[] mergeLists = (int[]) Array.newInstance(arr.getClass()
				.getComponentType(), (high - low + 1));

		while (l_low <= mid && r_low <= high) {
			if (arr[l_low] < (arr[r_low])) {
				mergeLists[index++] = arr[l_low++];
			} else {
				mergeLists[index++] = arr[r_low++];
				total += (mid - l_low + 1);
			}
		}
		while (l_low <= mid) {
			mergeLists[index++] = arr[l_low++];
		}
		while (r_low <= high) {
			mergeLists[index++] = arr[r_low++];
		}
		System.arraycopy(mergeLists, 0, arr, low, mergeLists.length);
		return total;
	}
	/**
	 * 
	 Source #include <iostream> #include <cstdlib> using namespace std; int
	 * count=0; void merge_sort(int *p,int init, int final) { if(final-init==0)
	 * return; else { //t mid=(iit+final) int mid=(init+final)/2; int *t=new
	 * int[final-init+1];
	 * 
	 * merge_sort(p,init,mid); merge_sort(p,mid+1,final); int i=0,j=init,
	 * k=mid+1;
	 * 
	 * for(i=0;i<final-init+1&&j<=mid&&k<=final; i++) { if(p[j]<=p[k]) {
	 * t[i]=p[j]; j++; } else { t[i]=p[k]; k++; //count incremented because
	 * remaining elements in the left //array are bigger than the current
	 * element of the right //array and we get a mid-j+1 cases of inversion
	 * count=count+mid-j+1; } }
	 * 
	 * if(i<final-init+1) { if(j<=mid) { while(i<final-init+1) { t[i]=p[j]; i++;
	 * j++; } } else { while(i<final-init+1) { t[i]=p[k]; i++; k++; }
	 * 
	 * } }
	 * 
	 * for(i=0;i<final-init+1;i++) { p[init+i]=t[i]; } } }
	 * 
	 * int main() { // your code goes here //this code implements merge-sort int
	 * a[]={3,2,5,1,9,7}; //int a[]={4,5,6,1,2,3}; int n=sizeof(a)/sizeof(a[0]);
	 * int i=0; merge_sort(a, 0, n-1); /*for(i=0;i<n;i++) { cout<<a[i]<<endl; }
	 * cout<<count;
	 * 
	 * return 0; }
	 */
}
