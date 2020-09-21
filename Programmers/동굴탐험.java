package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * Tree
 */
public class 동굴탐험 {

	public static void main(String[] args) {
		int[][] path= {{0,1},{0,2},{0,3},{1,7},{8,7},{7,9},{10,8},{4,3},{3,5},{4,6},{5,11},{12,11}};
		//int[][] path= {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		int[][] order = {{9,1},{2,3},{4,7}};
		//int[][] order = {{8,5},{6,7},{4,1}};
		System.out.println(solution(13, path, order));

	}
	static ArrayList<Integer> g[];
	static boolean[] visited;
	static int lock[], key[], idx=-1, p[];
	public static boolean solution(int n, int[][] path, int[][] order) {
		g=new ArrayList[n];
		for(int i=0; i<n; i++) g[i]=new ArrayList<Integer>();
		visited=new boolean[n]; lock=new int[n]; key=new int[n];
		p=new int[n];
		for(int i=0; i<path.length; i++) {
			g[path[i][0]].add(path[i][1]);
			g[path[i][1]].add(path[i][0]);
		}
		for(int i=0; i<order.length; i++) {
			lock[order[i][1]]=order[i][0]; // 1이 0번에 막혔다.
			key[order[i][0]]=order[i][1]; // 0이 1을 열수있다.
		}
		euler=new int[n][2];
		visited[0]=true;
		travers(0);
		for(int i=0; i<n; i++) {
			System.out.println(i+": "+euler[i][0]+" - "+euler[i][1]);
		}
		System.out.println(Arrays.toString(p));
		visited=new boolean[n];
		bfs();

		for(int i=0; i<n; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
	private static void travers(int pos) {
		idx++;
		euler[pos][0]=idx;
		for(int i=0; i<g[pos].size(); i++) {
			if(visited[g[pos].get(i)]) continue;
			visited[g[pos].get(i)]=true;
			p[g[pos].get(i)]=pos;
			travers(g[pos].get(i));
		}
		euler[pos][1]=idx;
	}
	static int[][] euler;
	private static void bfs() {
		Queue<Integer> q=new LinkedList<>();
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (euler[o1][1]-euler[o1][0])-(euler[o2][0]-euler[o2][1]);
			}
		});
		if(lock[0]!=0) return;
		visited[0]=true;
		pq.add(0);
		int qsize=0;
		while(!pq.isEmpty()) {
			q.add(pq.poll());
			while(!q.isEmpty()) {
				int t=q.poll();
				System.out.println("t:"+t);
				for(int i=0; i<g[t].size(); i++) {

					if(visited[g[t].get(i)]) continue;
					if(lock[g[t].get(i)]!=0) continue;
					if(euler[g[t].get(i)][0]<euler[t][0]) continue;

					System.out.println("자식 "+g[t].get(i));

					q.add(g[t].get(i));
					visited[g[t].get(i)]=true;
					if(key[g[t].get(i)]!=0) { // 열수있다.
						if(euler[g[t].get(i)][0]>=euler[key[g[t].get(i)]][0] && euler[g[t].get(i)][1]<=euler[key[g[t].get(i)]][1]) { // 부모꺼 못연다
							System.out.println("부모꺼 못연다"); continue;
						}


						lock[key[g[t].get(i)]]=0;
						visited[key[g[t].get(i)]]=true;
						//q.add(key[g[t].get(i)]);
						pq.add(key[g[t].get(i)]);
					}
				}
			}

		}
	}
}
