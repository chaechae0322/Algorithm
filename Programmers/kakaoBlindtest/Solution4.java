package Programmers.kakaoBlindtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution4 {

	public static void main(String[] args) {
		int[][] fare= {
				//{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
				//{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}
				{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}
		};
		System.out.println(solution(6, 4, 5, 6, fare));

	}
	static class Node{
		int d, c;

		public Node(int d, int c) {
			super();
			this.d = d;
			this.c = c;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [d=" + d + ", c=" + c + "]";
		}
		
	}
	static ArrayList<Node>[] g;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int sdist[]=new int[n+1], adist[]=new int[n+1], bdist[]=new int[n+1]; 
        g=new ArrayList[n+1];
        for(int i=0; i<=n; i++) g[i]=new ArrayList<Node>();
        for(int i=0; i<fares.length; i++) {
        	g[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
        	g[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }
        dijkstra(a, adist);
        dijkstra(b, bdist);
        dijkstra(s, sdist);
        System.out.println(Arrays.toString(adist));
        System.out.println(Arrays.toString(bdist));
        System.out.println(Arrays.toString(sdist));
        
        int res=0;
        for(int i=1; i<=n; i++) {
        	res=0;
        	res+=adist[i];
        	res+=bdist[i];
        	res+=sdist[i];
        	answer=Math.min(answer, res);
        }
        
        return answer;
    }
	private static void dijkstra(int a, int[] adist) {
		PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(Node::getC));
		Arrays.fill(adist, Integer.MAX_VALUE);
		adist[a]=0;
		pq.add(new Node(a, 0));
		while(!pq.isEmpty()) {
			Node t=pq.poll();
			for(int i=0; i<g[t.d].size(); i++) {
				Node tt=g[t.d].get(i);
				if(adist[tt.d]>adist[t.d]+tt.c) {
					adist[tt.d]=adist[t.d]+tt.c;
					pq.add(new Node(tt.d, adist[t.d]+tt.c));
				}
			}
		}
	}

}
