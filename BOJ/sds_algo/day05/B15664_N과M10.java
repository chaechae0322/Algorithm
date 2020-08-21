package BOJ.sds_algo.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B15664_N과M10 {
	static int N,M;
	static ArrayList<Integer> numList;
	static int[] numCount;
	static StringBuilder anssb;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		numList=new ArrayList<>();
		numCount=new int[10001];
		visited=new boolean[N];
		ans=new int[M];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp=Integer.parseInt(token.nextToken());
			if(!numList.contains(tmp)) {
				numList.add(tmp);
			}
			numCount[tmp]++;
		}
		Collections.sort(numList);
		
		sb=new StringBuilder();
		anssb=new StringBuilder();
		select(0, 0);
		
		System.out.println(anssb.toString());
	}
	static boolean[] visited;
	static StringBuilder sb;
	private static void select(int pos, int cnt) {
		if(cnt==M) {
			
			for(int r : ans) {
				anssb.append(r);
				anssb.append(" ");	
			}
			anssb.append("\n");
			return;
		}
		
		if(pos==numList.size()) return;
		
		for(int i=pos; i<numList.size(); i++) {
			if(numCount[numList.get(i)]>0) {
				//visited[i]=true;
				numCount[numList.get(i)]--;
				ans[cnt]=numList.get(i);
				select(i, cnt+1);
				numCount[numList.get(i)]++;
				//visited[i]=false;
				
				//if()
			}
		}
	}

}
