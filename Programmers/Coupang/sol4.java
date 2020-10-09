package Programmers.Coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class sol4 {

	public static void main(String[] args) {
		
	}
	static HashMap<String, Integer> citymap;
	static int n;
	static ArrayList<Integer>[] g;
	public static int solution(String depar, String hub, String dest, String[][] edge) {
		int answer = -1;
		n=1;
		for(int i=0; i<edge.length; i++) {
			if(!citymap.containsKey(edge[i][0])) {
				citymap.put(edge[i][0], n++);
			}
			if(!citymap.containsKey(edge[i][1])) {
				citymap.put(edge[i][1], n++);
			}
		}
		
		g=new ArrayList[n+1];
		for(int i=0; i<=n; i++) g[i]= new ArrayList<Integer>();
		for(int i=0; i<edge.length; i++) {
			int src = citymap.get(edge[i][0]);
			int dst = citymap.get(edge[i][1]);
			g[src].add(dst);
		}
		int front = bfs(depar, hub);
		int back = bfs(hub, dest);
		
		answer = (front*back)%10007;
		return answer;
	}
	private static int bfs(String src, String dst) {
		int res = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(citymap.get(src));
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0; i<g[tmp].size(); i++) {
				if(g[tmp].get(i)==citymap.get(dst)) {
					res = (res+1)%10007;
					continue;
				}
				q.add(g[tmp].get(i));
			}
		}
		return res;
	}

}
