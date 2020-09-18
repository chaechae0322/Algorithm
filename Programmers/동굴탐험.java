package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Tree
 */
public class 동굴탐험 {

	public static void main(String[] args) {
		int[][] path= {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		//int[][] path= {{0,1}};
		int[][] order = {{6,4},{3,7}};
		System.out.println(solution(9, path, order));

	}
	static ArrayList<Integer> g[];
	static boolean[] visited;
	static int[] lock, key;
	public static boolean solution(int n, int[][] path, int[][] order) {
		g=new ArrayList[n];
		for(int i=0; i<n; i++) g[i]=new ArrayList<Integer>();
		visited=new boolean[n]; lock=new int[n]; key=new int[n];
		for(int i=0; i<path.length; i++) {
			g[path[i][0]].add(path[i][1]);
			g[path[i][1]].add(path[i][0]);
		}
		for(int i=0; i<order.length; i++) {
			lock[order[i][1]]=order[i][0]; // 1이 0번에 막혔다.
			key[order[i][0]]=order[i][1]; // 0이 1을 열수있다.
		}
		bfs();

		for(int i=0; i<n; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
	private static void bfs() {
		Queue<Integer> q=new LinkedList<>();
        if(lock[0]!=0) return;
		visited[0]=true;
		q.add(0);
		while(!q.isEmpty()) {
			int t=q.poll();
			for(int i=0; i<g[t].size(); i++) {
                if(visited[g[t].get(i)]) continue;
				if(lock[g[t].get(i)]!=0) continue;
				q.add(g[t].get(i));
				visited[g[t].get(i)]=true;
				if(key[g[t].get(i)]!=0 ) { // 열수있다.
					lock[key[g[t].get(i)]]=0;
					visited[key[g[t].get(i)]]=true;
					q.add(key[g[t].get(i)]);
				}
			}
		}
	}
}
