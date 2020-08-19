package sds_algorithm.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516_게임개발 {
	static int N;
	static ArrayList<Integer>[] glist;
	static int[] cost;
	static int[] incomming;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N=Integer.parseInt(token.nextToken());
		glist=new ArrayList[N+1];
		cost=new int[N+1];
		incomming=new int[N+1];
		for(int i=0; i<=N; i++) glist[i]=new ArrayList<>();
		int c=0, pre=0;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			c=Integer.parseInt(token.nextToken());
			cost[i+1]=c;
			
			while((pre=Integer.parseInt(token.nextToken()))!=-1) {
				incomming[i+1]++;
				glist[pre].add(i+1);
			}
		}
		topol();
	}
	private static void topol() {
		Queue<int[]> q=new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(incomming[i]==0) {
				q.add(new int[] {i, cost[i]});
			}
		}
		//q.add(new int[] {root, cost[root]});
		
		int[] ans=new int[N+1];
		for(int i=1; i<=N; i++) {
			ans[i]=cost[i];
		}
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			System.out.println(Arrays.toString(tmp));
			//ans[tmp[0]]=tmp[1];
			for(int i=0; i<glist[tmp[0]].size(); i++) {
				int t = glist[tmp[0]].get(i);
				if(incomming[t]>0) {
					
					
					incomming[t]--;
					System.out.println(t+"번째 시발 깎는다.  "+incomming[t]);
					ans[t]=Math.max(ans[t], tmp[1]+cost[t]);
					
					if(incomming[t]==0) {
						//ans[t]=Math.max(ans[t], cost[t]+tmp[1]);
						q.add(new int[] {t, ans[t]});
					}
				}
			}
			
			System.out.println(Arrays.toString(ans));
		}
		for(int i=1; i<=N; i++) {
			System.out.println(ans[i]);
		}
	}

}
