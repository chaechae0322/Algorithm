package sds_algorithm.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1722_순열의순서 {
	static int N;
	static long[] perm;
	static boolean[] check;
	static int[] ansarr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());

		

		if(N!=1) {
		check = new boolean[N+1];
		perm=new long[N];
		perm[1]=1;
		for(int i=2; i<N; i++) {
			perm[i]=perm[i-1]*i;
		}
		}


		token = new StringTokenizer(br.readLine());
		int sel=Integer.parseInt(token.nextToken());
		if(sel==1) {
			long k = Long.parseLong(token.nextToken());
			
			if(N==1) {
				System.out.println(1);
				return;
			}
			ansarr=new int[N];
			getArray(k);
		}else {
			int[] arr= new int[N];
			for(int j=0; j<N; j++) {
				arr[j]=Integer.parseInt(token.nextToken());
			}
			
			if(N==1) {
				System.out.println(1);
				return;
			}
			getNumber(arr);
		}

	}

	private static void getNumber(int[] arr) {

		long order = 0;
		for(int i=0; i<N-1; i++) {

			int cnt=0;
			for(int j=1; j<arr[i]; j++) {
				if(!check[j]) cnt++; 
			}

			order+=perm[N-i-1]*cnt;

			check[arr[i]]=true;
		}
		order+=1L;
		System.out.println(order);
	}

	private static void getArray(long k) {
		for(int i=N-1; i>0; i--) {

			for(int j=1; j<=N; j++) {
				if(check[j]) continue;
				
				if(k > perm[i]) {
					k-=perm[i];
				}else {
					
				}
			}
			//k-=moc*perm[i];

			//System.out.println(Arrays.toString(ansarr));
		}
		for(int i=1; i<=N; i++) {
			if(!check[i]) ansarr[N-1]=i;
		}

		for(int tt : ansarr) {
			System.out.print(tt+" ");
		}
	}

}
