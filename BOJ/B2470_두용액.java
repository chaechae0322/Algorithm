package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 이분 탐색
 */
public class B2470_두용액 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(br.readLine());
		arr=new int[n];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
		}
		Arrays.sort(arr);
		int tar=0, res=0;
		int[] ans=new int[2]; ans[0]=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			tar=-arr[i];
			res=search(tar, i);
			if(Math.abs(ans[0]+ans[1])>Math.abs(arr[i]+res)) {
				if(arr[i]>res) {
					ans[0]=res; ans[1]=arr[i];
				}else {
					ans[0]=arr[i]; ans[1]=res;
				}
			}
		}
		System.out.println(ans[0]+" "+ans[1]);
	}
	
	private static int search(int tar, int idx) {
		long l=0, r=arr.length-1, mid=0;
		while(l<=r) {
			if(l==idx)l+=1;
			else if(r==idx)r-=1;
			mid=(l+r)/2;
			if(arr[(int)mid]==tar) {
				return arr[(int)mid];
			}else if(arr[(int)mid]>tar) {
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		if(l<0||l==arr.length||l==idx) {
			return arr[(int)r];
		}
		if(r<0||r==arr.length||r==idx) {
			return arr[(int)l];
		}
		
		if(Math.abs(tar-arr[(int)r])>Math.abs(tar-arr[(int)l])) {
			return arr[(int)l];
		}else {
			return arr[(int)r];
		}
	}

}
