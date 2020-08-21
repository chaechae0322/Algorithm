package BOJ.sds_algo.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14476_최대공약수하나빼기 {

	static int N;
	static int[] arr;
	static int[] gcdL, gcdR;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		arr=new int[N];
		gcdL=new int[N];
		gcdR=new int[N];
		int pre=gcdL[0];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
			gcdL[i]=gcd(arr[i], pre);
			pre=gcdL[i];
		}
		//System.out.println(Arrays.toString(gcdL));
		pre=gcdR[0];
		for(int i=N-1; i>=0; i--) {
			gcdR[i]=gcd(arr[i], pre);
			pre=gcdR[i];
		}
		//System.out.println(Arrays.toString(gcdR));
		
		// 최대 구하기
		int max=0, res=0;
		int K=0;
		boolean success=false;
		for(int i=0; i<N; i++) {
			
			//success = false;
			
			if(i==0) {
				res = gcdR[1];
			}else if(i==N-1) {
				res = gcdL[N-1];
			}
			else {
				res = gcd(gcdL[i-1], gcdR[i+1]);
			}
			
			System.out.println("K:"+arr[i]+" res:"+res);
			
			if(arr[i]%res!=0) {
				success=true;
				max=Math.max(res, max);
				K=arr[i];
			}
		}
		if(!success) System.out.println(-1);
		else System.out.println(max+" "+K);
	}
	private static int gcd(int a, int b) {
		while(b!=0) {
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}

}
