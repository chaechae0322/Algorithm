package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * QuickSort
 */
public class B11399_ATM {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int n=Integer.parseInt(br.readLine());
		arr=new int[n];
		token=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i]=Integer.parseInt(token.nextToken());

		quickSort(0, arr.length-1);
		long answer=0, sum=0;
		for(int i=0; i<n; i++) {
			sum+=arr[i];
			answer+=sum;
		}
		System.out.println(answer);
	}
	private static void quickSort(int left, int right) {
		if(left>=right) return;
		
		int pivot = right;
		int l=left-1, r=right;
		while(l<=r) {
			while(++l<=right && arr[l]<=arr[pivot]);
			while(--r>=left && arr[r]>=arr[pivot]);
			if(l<r) {
				int t=arr[l];
				arr[l]=arr[r];
				arr[r]=t;
			}else {
				if(l>right) l=right;
				int t=arr[l];
				arr[l]=arr[pivot];
				arr[pivot]=t;

			}
		}
		quickSort(left, l-1);
		quickSort(l+1,right);
	}

}
