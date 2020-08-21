package SWEA;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class DfsAndBfs {
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int connect=sc.nextInt();
		int start=sc.nextInt();
		
		
	
		//bfs
		Gragh graph=new Gragh(n+1);
		visited=new boolean[n+1];
		
		for(int i=0; i<connect; i++) {
			int ver=sc.nextInt();
			int idx=sc.nextInt();
			
			graph.adjAdd(ver, idx);
			graph.adjAdd(idx, ver);
		}
		
		graph.print(graph);
		
		graph.dfs(start,visited);

		System.out.println();
		for(int i=0; i<visited.length; i++)
			visited[i]=false;
		
		graph.bfs(start,visited);
		System.out.println();
		sc.close();
	}
	


}

class Gragh{
	
	int ver;
	Queue<Integer>[] q=null;	
	
	Gragh(int ver){
		this.ver=ver;

		q=new PriorityQueue[ver];
		
		for(int i=0; i<ver; i++) {
			q[i]=new PriorityQueue();
		}
	}
	
	void print(Gragh g) {
		for(int i=0; i<g.q.length; i++) {
			System.out.println(i + "=>"+g.q[i]);
		}
		
	}
	
	
	void dfs(int start, boolean[] visited) {
		
		visited[start]=true;
		System.out.print(start+" ");
		
		Iterator<Integer> it=q[start].iterator();
		
		while(it.hasNext()) {
			int idx=it.next();
			if(visited[idx]==false) {
				
				dfs(idx, visited);
			}
		}
	}
	
	void bfs(int start, boolean[] visited) {

		Queue<Integer> qq=new LinkedList<>();
		qq.offer(start);
		visited[start]=true;
		
		while(!qq.isEmpty()) {
			int index=qq.poll();
			System.out.print(index+" ");
			//visited[index]=true;
			
			Iterator<Integer> it=q[index].iterator();
			while(it.hasNext()) {
				index=it.next();
				if(!visited[index]) {
					visited[index]=true;
					qq.offer(index);
				}
			}
		}
		
	}

	void adjAdd(int ver, int idx) {
		q[ver].add(idx);
	}
}
