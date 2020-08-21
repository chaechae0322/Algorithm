package BOJ.sds_algo.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(token.nextToken());
		int S=Integer.parseInt(token.nextToken());
		int[] arr=new int[N];
		token=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(token.nextToken());
		}
		
		int low=0, high=0, ans=Integer.MAX_VALUE;
		int sum=arr[0];
		while(high<N) {
			if(sum>=S) {
				ans=Math.min(ans, high-low+1);
				sum-=arr[low++];
			}else {
				if(high==N-1) break;
				sum+=arr[++high];
			}
			//System.out.println(low+" "+high+" "+sum);
		}
		if(ans==Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
	}

}
