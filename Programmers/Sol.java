package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sol {

	public static void main(String[] args) {
		int[][] t = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}, {4, 10},
				{4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}};
		solution(19, t);

	}
	static ArrayList<Integer> g[];
	public static int solution(int n, int[][] edges) {
		int answer=0;
		g=new ArrayList[n]; cut = new int[51];
		Arrays.fill(cut, 100);
		for(int i=0; i<n; i++) g[i]=new ArrayList<>();
		for(int i=0; i<edges.length; i++) {
			g[edges[i][0]].add(edges[i][1]);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		dfs(0, 1, q);
		System.out.println(ans);
		return answer;
	}
	static int cut[], cnt, ans;
	private static int dfs(int pos, int cnt, Queue<Integer> q) {
		//cut[cnt] = Math.min(q.size(), cut[cnt]);
		int res = 0;
		System.out.println("q:"+q);
		int qsize=q.size();
		Queue<Integer> nq = new LinkedList<Integer>();
		for(int i=0; i<qsize; i++) {
			int t=q.poll();
			for(int j=0; j<g[t].size(); j++) {
				nq.add(g[t].get(j));
			}
			q.add(t);
		}
		System.out.println("nq:"+nq);
		qsize = nq.size();
		int min = Integer.MAX_VALUE;
		System.out.println("qsize:"+qsize);
		for(int i=0; i<qsize; i++) {
			System.out.println(nq);
			int t=nq.poll();
			min = Math.min(dfs(pos, cnt ,nq), min);
			nq.add(t);
		}
		System.out.println("return:"+res);
		return nq.size()-1+min;
	}


}
