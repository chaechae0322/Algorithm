package Programmers;

import java.util.Arrays;

public class kakao5 {

	public static void main(String[] args) {
		int n =9;
		int[][] path = {
				//{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}
				//{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}
				{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}
		};
		int[][] order = {
				//{8,5},{6,7},{4,1}
				//{4,1},{5,2}
				{4,1},{8,7},{6,5}
		};
		System.out.println(solution(n, path, order));

	}
	static int[][] graph;
	static int[][] ordergraph;
	public static boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        
        graph = new int[n][n];
        ordergraph = new int[n][n];
        for(int i=0; i<path.length; i++) {
        	graph[path[i][0]][path[i][1]] = 1;
        	graph[path[i][1]][path[i][0]] = 1;
        }
        
        System.out.println("graph check");
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		System.out.print(graph[i][j]+" ");
        	}
        	System.out.println();
        }
        
        for(int i=0; i<order.length; i++) {
        	ordergraph[order[i][0]][order[i][1]] = 1;
        }
        
        boolean[] visited= new boolean[n];
        
        visited[0]=true;
        traverse(0,visited, n);
        
        //traverse(0,visited, n);
        boolean isopen = true;
        for(int i=0; i<order.length; i++) {
        	if(!visited[order[i][0]]) {
        		isopen = false;
        		break;
        	}
        }
    
        
        if(stop||isopen) answer =true;
        else answer = false;
        
        return answer;
    }
	static boolean stop=false;
	private static void traverse(int pos, boolean[] visited, int n) {
		if(stop) return;
		
		System.out.println("visit "+pos);
		
		//다 방문했는지 확인
		boolean allcheck=true;
		for(int i=0; i<visited.length; i++) {
			if(!visited[i]) {
				allcheck=false;
				break;
			}
		}
		if(allcheck) stop = true;
		
		System.out.println(Arrays.toString(visited));
		
		
		
		loop:for(int i=0; i<n; i++) {
			if(graph[pos][i]==1 && !visited[i]) {
				System.out.println("연결되어있다:"+i);
				for(int k=0; k<n; k++) {
					if(ordergraph[k][i]==1) { //앞에 거쳐야하는 방이 있을 때
						System.out.println("앞에 거쳐야하는 방이 있다:"+k);
						if(!visited[k]) {
							System.out.println("안 거쳤을때");
							continue loop;  // 안 거쳤을때
						}
						else { // 거쳤을 때
							System.out.println("거쳤을 때");
							visited[i]=true;
							traverse(i, visited, n);
							i=0;
							continue loop;
						}
					}
				}
				
				visited[i]=true;
				traverse(i, visited, n);
				//System.out.println("ㅇㅇㅇ i:"+i);
				//i=0;
				//continue loop;
			
			}
		}
		
	}

}
