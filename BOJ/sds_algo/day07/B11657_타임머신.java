package BOJ.sds_algo.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 *  bellman-ford 최단 거리구하기 
 *  음수의 가중치 존재
 *  음수 사이클 판별 
 *  
 */
public class B11657_타임머신 {
	static int N,M;
	static int[][] glist;
	//static int[][] dist;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		glist=new int[M][3];
		dist=new int[N+1];
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(token.nextToken());
			int b= Integer.parseInt(token.nextToken());
			int c= Integer.parseInt(token.nextToken());
			glist[i][0]=a; glist[i][1]=b; glist[i][2]=c; 
		}
		if(N==1) return;
		bellman();
	}
	private static void bellman() {
		//for(int i=0; i<)
		
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[1]=0;
		int[] copy=dist.clone();
		int src=0, dst=0, cost=0;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				src=glist[j][0]; dst=glist[j][1]; cost=glist[j][2];
				if(dist[src]!=Integer.MAX_VALUE && dist[dst]>dist[src]+cost) {
					copy[dst]=dist[src]+cost;
				}
			}
			if(i<N) {for(int j=1; j<=N; j++) dist[j]=copy[j];}
		}
		for(int i=1; i<=N; i++) {
			if(copy[i]!=dist[i]) { // copy가 N번째 돌린거
				System.out.println(-1);
				return;
			}
		}
		for(int i=2; i<=N; i++) {
			if(dist[i]!=Integer.MAX_VALUE) System.out.println(dist[i]);
			else System.out.println(-1);
		}
	}
}
