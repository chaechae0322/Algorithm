package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카엔3 {
	static double[] cracks;
	static int N, K;
	static double ans;
	static double max, min=Double.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		K=Integer.parseInt(token.nextToken());
		
		cracks = new double[N];
		
		for(int i=0; i<N; i++) {
			cracks[i]=Double.parseDouble(br.readLine());
			max=Math.max(max, cracks[i]);
			min=Math.min(min, cracks[i]);
		}
		
		search(0, max);
		System.out.println(ans);
	}
	static int cnt;
	private static void search(double start, double end) {
		if(start>=end) return;
		
		end = (Math.round(end*100.0)/100.0); //반올림
		start = (Math.round(start*100.0)/100.0); //반올림
		if(cnt>1000)
			return;
		cnt++;
		
		System.out.println("start:"+start+" end:"+end);
		
		/*if(min>=x) {
			return;
		}
		if(max<x) {
			return;
		}*/
		
		double ban = (end+start)/2;
		ban = (Math.round(ban*100.0)/100.0); //반올림
		
		int k=0;
		for(int i=0; i<N; i++) {
			k+=(cracks[i]/end);
		}
		System.out.println(k);
		
		if(k<K) { //-
			
			//if(ans<ban)
				search(start, ban);
		}else { //+
			ans = Math.max(ans, end);
			search(end, end+ban);
		}
		
	}

}
