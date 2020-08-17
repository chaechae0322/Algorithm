package sds_algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B7453_합이0인네정수 {

	static int N;
	static int[][] map;
	static int[] subA;
	static int[] subB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][4];
		StringTokenizer token;
		
		//long maxabs=0;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
		//		maxabs=Math.max(maxabs, Math.abs(map[i][j]));
			}
		}
		
		// subA
		subA=new int[N*N];
		subB=new int[N*N];
		int alength=0, blength=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				subA[alength++]=map[i][0]+map[j][1];
				subB[blength++]=map[i][2]+map[j][3];
			}
		}
		
		Arrays.sort(subB); // 오름차순 정렬
		Arrays.sort(subA);
		System.out.println("subA: "+Arrays.toString(subA));
		System.out.println("subB: "+Arrays.toString(subB));
		
		long res=0;
		long ans=0;
		ans=search(subA[0], blength);
		res=ans;
		for(int i=1; i<alength; i++) {
			if(subA[i-1] == subA[i]) {
				System.out.println("했던거");
				ans+=res;
			}else {
				res=search(subA[i], blength);
				ans+=res;
			}
		}
		
		//System.out.println(m);
		
		System.out.println(ans);
	}

	private static long search(int num, int limit) {
		int target=0-num;
		System.out.println("target:"+target);
		int upper = upperBound(0, limit, target);
		int lower = lowerBound(0, limit, target);
		System.out.println("lower:"+lower+" upper:"+upper);
		return upper-lower;
	}

	private static int lowerBound(int left, int right, int num) {
		int mid;
		while(left<right) {
			mid=(left+right)/2;
			if(subB[mid]>=num) {
				right=mid;
			}else {
				left=mid+1;
			}
		}
		return right;
	}

	private static int upperBound(int left, int right, int num) {
		int mid;
		while(left<right) {
			mid=(left+right)/2;
			if(subB[mid]<=num) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return right;
	}

}
