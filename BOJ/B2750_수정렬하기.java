package BOJ;

import java.util.Arrays;
import java.util.Scanner;
/*
 * MergeSort
 */
public class B2750_수정렬하기 {
	static int[] arr, res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		arr=new int[n]; res=new int[n];
		for(int i=0; i<n; i++) arr[i]=sc.nextInt();
		if(n==1) {
			System.out.println(arr[0]);
			return;
		}
		mergeSort();

	}
	private static void mergeSort() {
		divide(0,arr.length-1);
		for(int t:res) System.out.println(t);
	}
	private static void divide(int left, int right) {
		if(left<right) {
			int mid=(left+right)/2;
			divide(left, mid);
			divide(mid+1, right);
			merge(left,mid,right);
		}

	}
	private static void merge(int left, int mid, int right) {
		int l=left, r=mid+1, cu=left;
		while(r<=right && l<=mid) {
			if(arr[l]>arr[r]) {
				res[cu]=arr[r++];
			}else {
				res[cu]=arr[l++];
			}
			cu++;
		}
		while(l<=mid) {
			res[cu++]=arr[l++];
		}
		while(r<=right) {
			res[cu++]=arr[r++];
		}
		for(int i=left; i<=right; i++) arr[i]=res[i];
	}

}
