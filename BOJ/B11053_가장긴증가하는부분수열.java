package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 이분탐색
 * LinkedList
 */
public class B11053_가장긴증가하는부분수열 {
	static int label[], N, arr[], list[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		arr=new int[N]; label=new int[N]; list=new int[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
		}
		for(int i=0; i<N; i++) {
			label[i]=binary(arr[i]);
		}
		System.out.println(idx);
	}
	static int idx;
	private static int binary(int x) {
		int l=0, r=idx-1, mid=0;
		if(idx==0) {
			list[idx++]=x;
			return 1;
		}
		
		while(l<=r) {
			mid=(l+r)/2;
			if(list[mid]==x) {
				return mid;
			}else if(list[mid]>x) {
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		if(l==idx) {
			list[idx++]=x;
		}else {
			list[l]=x;
		}
		return l+1;
	}

}
