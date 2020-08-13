package sds_algorithm.day02;

import java.util.Arrays;

public class MergeSortTest {
	static int[] nums = { 2, 8, 10, 7, 1, 9, 4, 15 };
	static int[] temp = new int[nums.length];

	public static void main(String[] args) {
		mergeSort(0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	static void mergeSort(int s, int e) {
		if(s<e) {
			int mid = (s+e)/2;
			mergeSort(s,mid);
			mergeSort(mid+1, e);
			merge(s,mid,e);
		}
	}
	static void merge(int s, int m, int e) {
		System.out.println("s:"+s+" e:"+e);
		for(int i=s; i<=e; i++) {
			System.out.println(nums[i]);
		}
		int p1=s;
		int p2=m+1;
		int k=s;
		while(p1<=m&&p2<=e) {
			if(nums[p1]<=nums[p2]) {
				temp[k++]=nums[p1++];
			}else {
				temp[k++]=nums[p2++];
			}
		}
		while(p1<=m) {
			temp[k++]=nums[p1++];
		}
		while(p2<=e) {
			temp[k++]=nums[p2++];
		}
		for(int i=s; i<=e; i++)
			nums[i]=temp[i];
	}
}
