package sds_algorithm.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2757_보이는점의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		
//		System.out.println(eulerPie(100));
		
		for(int test=0; test<K; test++) {
			int N=Integer.parseInt(br.readLine());
			System.out.println("N:"+N);
			
			int result=0;
			for(int i=2; i<=N; i++) {
				result += eulerPie(i);
			}
			System.out.println(2*result+3);
		}

	}
	public static int eulerPie (int N) {
		int pie=1;
		for(int p=2; p*p<=N; p++) {
			int pm=1;
			while(N%p==0) {
				//System.out.println("약수 :"+p);
				//in=true;
				N/=p;
				// pie
				pm*=p;
				//pm++;
			}
			if(pm>1) {
				//System.out.println("약수:"+p+" 승수:"+pm);
				//pie *= (Math.pow(p, pm) - Math.pow(p, pm-1));
				pie *= (pm-pm/p);
			}
		}
		if(N!=1) pie *= N-1;
		return pie;
	}

}
