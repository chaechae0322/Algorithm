package beakjoon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * B1260_BFS와DFS
 * 2020.02.03
 */
public class B1260_BFS와DFS {
    static int V,E,start;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V=sc.nextInt(); E=sc.nextInt();
        start=sc.nextInt();

        graph=new ArrayList[V+1];
        
        for(int i=1; i<=V; i++) 
            graph[i]=new ArrayList<Integer>();

        int a=0, b=0;
        for(int i=0; i<E; i++){
            a=sc.nextInt(); b=sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<=V; i++){
            Collections.sort(graph[i]);
        }

        
        boolean[] visited=new boolean[V+1];
        visited[start]=true;
        dfs(start,visited);
        System.out.println();
        bfs();

    }
    public static void bfs(){
        Queue<Integer> q= new LinkedList<>();
        boolean[] visited=new boolean[V+1];
        visited[start]=true;
        q.add(start);

        while(!q.isEmpty()){
            int tmp=q.poll();
            System.out.print(tmp+" ");
            for(int i=0; i<graph[tmp].size(); i++){
                if(!visited[graph[tmp].get(i)]){
                    q.add(graph[tmp].get(i));
                    visited[graph[tmp].get(i)]=true;
                }
            }
        }
        
    }
    public static void dfs(int idx, boolean[] visited){
        System.out.print(idx+" ");
        for(int i=0; i<graph[idx].size(); i++){
            if(!visited[graph[idx].get(i)]){
                visited[graph[idx].get(i)]=true;
                dfs(graph[idx].get(i), visited);
            }
        }
    }
    
}  
