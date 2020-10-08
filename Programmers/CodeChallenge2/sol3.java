package Programmers.CodeChallenge2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class sol3 {

	public static void main(String[] args) {
		int[][] edge = {{1,2},{2,3},{3,4}};
		//int[][] edge = {{1,4},{1,5},{1,2},{6,7},{5,6},{2,3}};
		System.out.println(solution(7, edge));

	}
	static ArrayList<Integer>[] g;
	static int[] visited;
    public static int solution(int n, int[][] edges) {
        int answer = 0;
        g=new ArrayList[n+1]; visited=new int[n+1]; 
        for(int i=0; i<=n; i++) g[i]=new ArrayList<Integer>();
        for(int i=0; i<edges.length; i++) {
        	g[edges[i][0]].add(edges[i][1]);
        	g[edges[i][1]].add(edges[i][0]);
        }
        bfs(1);
        int maxnode1=0, maxdist=0;
        for(int i=1; i<=n; i++) {
        	if(maxdist<visited[i]) {
        		maxdist=visited[i];
        		maxnode1=i;
        	}
        }
        visited = new int[n+1];
        bfs(maxnode1);
        int maxnode2=0; maxdist=0;
        for(int i=1; i<=n; i++) {
        	if(maxdist<visited[i]) {
        		maxdist=visited[i];
        		maxnode2=i;
        	}
        }
        // from maxnode1
        visited=new int[n+1];
        visited[maxnode2]=-1;
        bfs(maxnode1);
        int secondmaxnode=0, secondmaxdist=0;
        for(int i=1; i<=n; i++) {
        	if(secondmaxdist<visited[i]) {
        		secondmaxdist=visited[i];
        		secondmaxnode=i;
        	}
        }
        // from maxnode2
        visited=new int[n+1];
        visited[maxnode1]=-1;
        bfs(maxnode2);
        for(int i=1; i<=n; i++) {
        	if(secondmaxdist<visited[i]) {
        		secondmaxdist=visited[i];
        		secondmaxnode=i;
        	}
        }
        answer = secondmaxdist-1;
        return answer;
    }
	private static void bfs(int root) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {root, 1});
		visited[root]=1;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<g[tmp[0]].size(); i++) {
				if(visited[g[tmp[0]].get(i)]==0) {
					q.add(new int[] {g[tmp[0]].get(i), tmp[1]+1});
					visited[g[tmp[0]].get(i)]=tmp[1]+1;
				}
			}
		}
	}

}
