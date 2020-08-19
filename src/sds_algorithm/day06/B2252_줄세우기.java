package sds_algorithm.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252_줄세우기 {
	static int N,M;
	static ArrayList<Integer>[] glist;
	static int[] incomming;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		
		glist=new ArrayList[N+1];
		for(int i=0; i<=N; i++) glist[i]=new ArrayList<>();
		incomming=new int[N+1];
		int a=0, b=0;
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			a=Integer.parseInt(token.nextToken());
			b=Integer.parseInt(token.nextToken());
			
			incomming[b]++;
			glist[a].add(b);
		}
		
		topologicalSort();
		
	}
	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(incomming[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node+" ");
			for(int i=0; i<glist[node].size(); i++) {
				int tmp=glist[node].get(i);
				incomming[tmp]--;
				if(incomming[tmp]==0) {
					q.add(tmp);
				}
			}
		}
	}

}
