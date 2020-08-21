package BOJ;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2660_회장뽑기 {
	static int[][] graph;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		graph=new int[n+1][n+1];
		int a=0, b=0;
		while(true) {
			a=sc.nextInt();
			b=sc.nextInt();
			if(a==-1&&b==-1) break;
			graph[a][b]=1;
			graph[b][a]=1;
		}
		
		ArrayList<Integer> list=new ArrayList<>();
		int num=0; int dis=Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			
			int tmp = bfs(i);
			if(dis==tmp) {
				list.add(i);
				num++;
			}
			else if(dis>tmp) {
				list.clear();
				num=1;
				list.add(i);
				dis=tmp;
			}
		}
		
		System.out.println(dis+" "+num);
		for(int i : list) {
			System.out.print(i+" ");
		}
	}

	private static int bfs(int src) {
		boolean[] visited=new boolean[n+1];
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {src, 0});
		visited[src]=true;
		int max=0;
		
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			for(int i=1; i<=n; i++) {
				if(graph[tmp[0]][i]==1 && !visited[i]) {
					max=Math.max(tmp[1]+1, max);
					visited[i]=true;
					q.add(new int[] {i, tmp[1]+1});
				}
			}
		}
		
		
		
		return max;
	}

}
