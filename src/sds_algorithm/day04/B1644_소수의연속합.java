package sds_algorithm.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1644_소수의연속합 {
	static int[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		if(N==1 || N==4) {
			System.out.println(0);
			return;
		}
		
		map=new int[N+1];
		for(int i=2; i<=N; i++) {
			if(map[i]==0) {
				for(int j=2; i*j<=N; j++) {
					if(map[j*i]==0) map[i*j]=1;
				}
			}
		}
		
		int left=2, right=2;
		int sum=2;
		int ans=0;
		while(left<=right) {
			System.out.println(left+" "+right+" sum:"+sum);
			if(sum==N) {
				System.out.println("what?");
				ans++;
				while(++right<=N && map[right]==1);
				sum+=right;
			}else if(sum<N) {
				System.out.println("???");
				while(++right<=N && map[right]==1);
				sum+=right;
			}else {
				sum-=left;
				while(++left<=N && map[left]==1);
				
			}
		}
		System.out.println(ans);
	}

}
