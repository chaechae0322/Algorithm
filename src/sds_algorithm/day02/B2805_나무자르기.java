package sds_algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[] arr=new int[N];
		int high=0;
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
			high=Math.max(high, arr[i]);
		
		}
		int low=0;
		int mid=0;
		int pre=0;
		while(low<=high) {
			mid=(low+high)/2;
			long sum=0;
			for(int i=0; i<N; i++) {
				sum+= arr[i] >= mid ? (long)arr[i]-mid : 0L; 
			}
			System.out.println(mid+" "+sum);
			if(sum==(long)M) {
				pre=mid;
				break;
			}else if(sum>(long)M) {
				pre=mid;
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		System.out.println(pre);
	}

}
